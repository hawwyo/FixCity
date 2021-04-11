package ru.dropdatabase.fixcity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.TextView;

public class AddEventActivity extends AppCompatActivity {
    String EMPTY_STRING = "";
    TextView authorName, petitionTitle, petitionDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);
    }

    boolean validateForm(String name, String title, String description) {
        //дату будем валидироватб а?
        if(name.equals(EMPTY_STRING) || title.equals(EMPTY_STRING) || description.equals(EMPTY_STRING)) {
            return false;
        }
        return true;
    }

    public void onSaveEventClick(View v) {
        authorName = findViewById(R.id.authorName);
        petitionTitle = findViewById(R.id.petitionTitle);
        petitionDescription = findViewById(R.id.petitionDescription);

        String name = authorName.getText().toString();
        String title = petitionTitle.getText().toString();
        String description = petitionDescription.getText().toString();
        //Нужно что-то придумать...
        String picture = Petition.convert(BitmapFactory.decodeResource(getResources(), R.drawable.rubbish));

        if(validateForm(name, title, description)) {
            Petition newPetition = new Petition(name, picture, title, description);
            GetPetitionInfoSingleton.getInstanceOf().save(newPetition);
        }
        finish();
    }
}
