package ru.dropdatabase.fixcity;

import android.graphics.Bitmap;

import java.util.List;

public interface getPetition {
    public Petition getPetitionWithoutComments(int petitionId);
    public Petition getPetition(int petitionId);
    public List<Comment> getComments(int petitionId);

}
