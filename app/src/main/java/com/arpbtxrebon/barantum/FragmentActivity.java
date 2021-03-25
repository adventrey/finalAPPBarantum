package com.arpbtxrebon.barantum;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;


public class FragmentActivity extends Fragment {

FloatingActionButton floatingActionButton;
    RecyclerView rv_activity;
    ArrayList<DataModelActivity> arrayListData = new ArrayList<>();

    public FragmentActivity() {
        // Required empty public constructor
    }


    public static FragmentActivity newInstance(String param1, String param2) {
        FragmentActivity fragment = new FragmentActivity();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_activity, container, false);
        rv_activity = view.findViewById(R.id.rv_activity);
        rv_activity.setHasFixedSize(true);
        arrayListData.addAll(DataActivity.getListDataModel());
        rv_activity.setLayoutManager(new GridLayoutManager(getContext(), 1, GridLayoutManager.VERTICAL, false));
        AdapterActivity adapterActivity = new AdapterActivity(arrayListData);
        rv_activity.setAdapter(adapterActivity);
        adapterActivity.setOnItemClickCallBack(new AdapterActivity.OnItemClickCallBack() {
            @Override
            public void onItemClicked(int position) {
                Toast.makeText(getContext(), "Data "+String.valueOf(position) +" ini Bisa Dihapus", Toast.LENGTH_SHORT).show();
            }
        });

        floatingActionButton = view.findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),AddActivity.class));
            }
        });
        return view;
    }
}