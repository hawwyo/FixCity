package ru.dropdatabase.fixcity;

import androidx.annotation.NonNull;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private AppBarConfiguration mAppBarConfiguration;

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

//        }); deleted fab
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_join, R.id.nav_gallery, R.id.nav_slideshow)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

        Petition toSave2 = new Petition();
        toSave2.setTitle("second");
        List<Comment> ls2 = new ArrayList<Comment>();
        ls2.add(new Comment("net","second"));
        ls2.add(new Comment("net","netda"));
        toSave2.setComments(ls2);

        DAO.save(toSave2);
    }

}

