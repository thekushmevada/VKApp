package com.example.vkapp.ui.Department;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import java.util.ArrayList;
import java.util.List;

public class DepartmentViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    private static final String TAG = "DepartmentViewModel";
    private MutableLiveData<List<Department>> mutableLiveData;

    public LiveData<List<Department>> getMovieList() {
        if(mutableLiveData == null){
            mutableLiveData = new MutableLiveData<>();
            initMovieList();
        }

        return mutableLiveData;
    }

    private void initMovieList() {
        List<Department> departmentlist = new ArrayList<>();
        
    }
}