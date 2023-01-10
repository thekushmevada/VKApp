package com.example.vkapp.ui.RequititionApprove;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vkapp.R;

public class RequititionApprove extends Fragment {

    private RequititionApproveViewModel mViewModel;

    public static RequititionApprove newInstance() {
        return new RequititionApprove();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_requitition_approve, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(RequititionApproveViewModel.class);
        // TODO: Use the ViewModel
    }

}