package ru.dropdatabase.fixcity;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.List;

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
            System.out.println(e.getMessage());
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
        petition.setId(incrementCounter());
        DatabaseReference myRef = database.getReference("petitions").child(Integer.toString(petition.getId()));
        myRef.setValue(petition);
        saveComments(petition.getId(), petition.getComments());
    }
    protected void saveComments(int id, List<Comment> c){
        DatabaseReference myRef = database.getReference("comments").child(Integer.toString(id));
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
    public Query getPetition(int petitionId) {
        Query res = database
                .getReference()
                .child("petitions").child(Integer.toString(petitionId));
        return res;
    }

    @Override
    public Query getComments(int petitionId) {
        Query res = database
                .getReference()
                .child("comments").child(Integer.toString(petitionId));
        return res;

    }
}
