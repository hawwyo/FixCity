package ru.dropdatabase.fixcity;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class GetPetitionDAO implements getPetition {

    FirebaseDatabase database;
    int counter;
    public GetPetitionDAO() {
        database = FirebaseDatabase.getInstance();
        Query mutq = database.getReference().child("mutator");
        int tmp = -1;
        try {
            tmp = mutq.get().getResult().getValue(Integer.class);
        }catch (Exception e){

        }
        if(tmp == -1){
            counter = 0;
            database.getReference("mutator").setValue(counter);
        }else{
            counter = tmp;
        }
    }
    int incrementCounter(){
        int res = counter;
        database.getReference("mutator").setValue(counter + 1);
        counter = counter + 1;
        return res;
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
