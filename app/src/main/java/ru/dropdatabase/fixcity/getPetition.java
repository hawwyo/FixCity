package ru.dropdatabase.fixcity;

import android.graphics.Bitmap;

import com.google.firebase.database.Query;

import java.util.List;

public interface getPetition {
    public void save(Petition petition);
    public Query getPetitionsWithoutComments();
    public Query getPetition(int petitionId);
    public Query getComments(int petitionId);

}