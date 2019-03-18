package com.example.basic.Main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.basic.R;

public class MainFragment extends Fragment {

    String[] strings = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "13", "14"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);


        // This is the place where Fragment recycler view works
        // Home Fragment has a recyclerView with 3 columns
        // The recyclerView shows data that are in strings array written above
        // RecyclerView in Fragment is same like in Activity Fragment.
        // You just need to define in which view you will find the RecyclerView
        // Like you can see view.findViewbyId is written.
        // This view comes from MainActivity
        MainFragRecyclerView recyclerAdapter = new MainFragRecyclerView(getContext(),strings);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.mainFragRecyclerView);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), 3);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(recyclerAdapter);
        return view;
    }



}
