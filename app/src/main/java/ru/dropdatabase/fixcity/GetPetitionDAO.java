package ru.dropdatabase.fixcity;


import android.content.Intent;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseError;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.MutableData;
import com.google.firebase.database.Query;
import com.google.firebase.database.Transaction;
import com.google.firebase.database.ValueEventListener;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class GetPetitionDAO implements getPetition {

    FirebaseDatabase database;
    int counter, tmp;
    public GetPetitionDAO() {
        database = FirebaseDatabase.getInstance();

        Query mutq = database.getReference("mutator");
        tmp = -1;
        try {
                mutq.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    Log.d("mytag", "!"+snapshot.getValue(Integer.class).toString());
                    setCounter(snapshot.getValue(Integer.class));
                }
                @Override
                public void onCancelled(@NonNull DatabaseError error) {}
            });
        }catch (Exception e){
            Log.d("mytag", e.toString());
        }
    }
    void setCounter(int tmp) {
        this.tmp = tmp;

        if(tmp == -1){
            counter = 0;
            database.getReference("mutator").setValue(counter);
        }else{
            counter = tmp;
            Log.d("mytag", "tmp is not null " + Integer.toString(counter));
        }
    }

    private int incrementCounter(){
        int res = counter;
        database.getReference("mutator").setValue(counter + 1);
        counter = counter + 1;
        return res;
    }

    @Override
    public void update(int petitionId, Petition petition) {
        DatabaseReference myRef = database.getReference("petitions").child(petition.getTitle());
        myRef.setValue(petition);
        saveComments(petition.getTitle(), petition.getComments());
    }

    @Override
    public void save(Petition petition) {

        Log.d("mytag", "save");
        update(incrementCounter(), petition);
    }
    protected void saveComments(String title, List<Comment> c){
        DatabaseReference myRef = database.getReference("comments").child(title);
        myRef.setValue(c);
    }
    @Override
    public Query getPetitionsWithoutComments() {
        Query res = database
                .getReference()
                .child("petitions");
        return res;
    }

    @Override
    public Query getPetition(String title) {
        Query res = database
                .getReference()
                .child("petitions").child(title);
        return res;
    }

    @Override
    public Query getComments(String title) {
        Query res = database
                .getReference()
                .child("comments").child(title);
        return res;

    }
}
