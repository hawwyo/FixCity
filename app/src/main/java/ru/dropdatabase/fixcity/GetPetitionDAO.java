package ru.dropdatabase.fixcity;

import android.graphics.Bitmap;

import java.util.List;

public class GetPetitionDAO implements getPetitionInfo {
    @Override
    public String getPetitionTitle(int petitionId) {
        return null;
    }

    @Override
    public Bitmap getPetitionBitmap(int petitionId) {
        return null;
    }

    @Override
    public String getPetitionDescription(int petitionId) {
        return null;
    }

    @Override
    public List<Comment> getPetitionComments(int petitionId) {
        return null;
    }

    @Override
    public int getPetitionCommentsCnt(int petitionId) {
        return 0;
    }

    @Override
    public int getPetitionLikesCnt(int petitionId) {
        return 0;
    }
}
