package ru.dropdatabase.fixcity;

import android.graphics.Bitmap;

import java.util.List;

public interface getPetitionInfo {
    public String getPetitionTitle(int petitionId);
    public Bitmap getPetitionBitmap(int petitionId);
    public String getPetitionDescription(int petitionId);
    public List<Comment> getPetitionComments(int petitionId);
    public int getPetitionCommentsCnt(int petitionId);
    public int getPetitionLikesCnt(int petitionId);
}
