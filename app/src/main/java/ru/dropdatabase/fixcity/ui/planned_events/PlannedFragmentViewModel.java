package ru.dropdatabase.fixcity.ui.planned_events;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PlannedFragmentViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public PlannedFragmentViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Запланированные события");
    }

    public LiveData<String> getText() {
        return mText;
    }
}