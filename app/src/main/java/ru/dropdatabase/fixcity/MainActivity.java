package ru.dropdatabase.fixcity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import ru.dropdatabase.fixcity.model.User;

public class MainActivity extends AppCompatActivity implements ValueEventListener {
    User user = new User("Sochi");
    DatabaseReference dbRef;
    FirebaseDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        DatabaseReference dbRef = db.getReference("message").child("item");
        dbRef.setValue("This is a test message").addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Log.d("mytag", "done");
                }else{
                    Log.d("mytag", "Error");
                }
            }
        });
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d("mytag", "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Log.w("mytag", "Failed to read value.", error.toException());
            }
        });
    }

    public void changePlace(User p) {
        dbRef.child("myplace").setValue(p);
    }


    @Override
    public void onDataChange(@NonNull DataSnapshot snapshot) {
        User user = snapshot.getValue(User.class);

        Log.d("mytag", "place: " + user);
        /*
       for (DataSnapshot s: snapshot.getChildren() ) {
           Log.d("mytag", "key: " + s.getKey());
           Place place = s.getValue(Place.class);
           Log.d("mytag", "place: " + place);
       }
         */

    }

    @Override
    public void onCancelled(@NonNull DatabaseError error) {

    }
}