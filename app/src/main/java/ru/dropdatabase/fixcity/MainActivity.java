package ru.dropdatabase.fixcity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  {

    GetPetitionDAO DAO = new GetPetitionDAO();
    List<Petition> petitions;
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Petition toSave = new Petition();
        toSave.setTitle("update test");
        List<Comment> ls = new ArrayList<Comment>();
        ls.add(new Comment("da","soglasen"));
        ls.add(new Comment("da2","net"));
        toSave.setComments(ls);

        DAO.save(toSave);
//        DAO.getComments(0)
//                .addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                for (DataSnapshot ds : snapshot.getChildren()) {
//                    Comment wi = ds.getValue(Comment.class);
//
//                    Log.d("mytag", wi.getText());
//                }
//            }
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });

        Petition toSave2 = new Petition();
        toSave2.setTitle("second");
        List<Comment> ls2 = new ArrayList<Comment>();
        ls2.add(new Comment("net","second"));
        ls2.add(new Comment("net","netda"));
        toSave2.setComments(ls2);

        DAO.save(toSave2);
    }


}
