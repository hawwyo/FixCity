package ru.dropdatabase.fixcity;

import android.graphics.Bitmap;

import com.google.firebase.database.Query;

import java.util.List;

public interface getPetition {
    public void save(Petition petition);
    public Query getPetitionsWithoutComments();
    public Query getPetition(String title);
    public Query getComments(String title);
    public void update(int petitionId, Petition petition);
}