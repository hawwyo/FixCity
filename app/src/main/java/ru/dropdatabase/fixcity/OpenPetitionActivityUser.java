package ru.dropdatabase.fixcity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import ru.dropdatabase.fixcity.views.PetitionTileView;

public class OpenPetitionActivityUser extends AppCompatActivity {

    ImageView image;
    TextView title;
    TextView desctiption;
    BottomNavigationView bottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tile_full);

        image = findViewById(R.id.petition_image);
        title = findViewById(R.id.petition_title);

        desctiption = findViewById(R.id.petition_desc);
        bottom = findViewById(R.id.nav_view);

        String title_str = getIntent().getStringExtra("title");
//
//        Petition loadedPetition = GetPetitionInfoSingleton.getInstanceOf().getPetition( title_str ).get().getResult().child();
        image.setImageBitmap( BitmapFactory.decodeResource( getResources(), R.drawable.rubbish) );
        title.setText( getIntent().getStringExtra("title") );
        desctiption.setText( getIntent().getStringExtra("title") );
//
        bottom.getMenu().getItem(0).setTitle( getIntent().getStringExtra("likes") );
        bottom.getMenu().getItem(1).setTitle( getIntent().getStringExtra("commentsCount") );

        //TODO petition date;

    }
}