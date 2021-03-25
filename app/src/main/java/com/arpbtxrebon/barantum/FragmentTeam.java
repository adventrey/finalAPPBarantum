package com.arpbtxrebon.barantum;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class FragmentTeam extends Fragment {
    RecyclerView rv_team;
    ArrayList<DataModelActivity> arrayListDataTeam = new ArrayList<>();

    public FragmentTeam() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_team, container, false);
        rv_team = view.findViewById(R.id.rv_team);
        rv_team.setHasFixedSize(true);
        arrayListDataTeam.addAll(DataActivity.getListDataModel());
        rv_team.setLayoutManager(new GridLayoutManager(getContext(), 1, GridLayoutManager.VERTICAL, false));
        AdapterTeam adapterTeam = new AdapterTeam(arrayListDataTeam);
        rv_team.setAdapter(adapterTeam);

        return view;
    }
}