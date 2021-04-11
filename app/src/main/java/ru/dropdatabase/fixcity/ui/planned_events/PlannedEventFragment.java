package ru.dropdatabase.fixcity.ui.planned_events;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import ru.dropdatabase.fixcity.R;

public class PlannedEventFragment extends Fragment {

    private PlannedFragmentViewModel plannedFragmentViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        plannedFragmentViewModel =
                new ViewModelProvider(this).get(PlannedFragmentViewModel.class);
        View root = inflater.inflate(R.layout.fragment_planned_events, container, false);
        final TextView textView = root.findViewById(R.id.text_slideshow);
        plannedFragmentViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}