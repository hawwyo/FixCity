package ru.dropdatabase.fixcity;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import ru.dropdatabase.fixcity.views.PetitionTileView;

public class PetitionHolder extends RecyclerView.ViewHolder {

    public PetitionTileView petition;

    public PetitionHolder(@NonNull View itemView) {
        super(itemView);
        petition = itemView.findViewById(R.id.petition_tile);
    }
}
