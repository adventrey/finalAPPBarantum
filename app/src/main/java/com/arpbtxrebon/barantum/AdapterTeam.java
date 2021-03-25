package com.arpbtxrebon.barantum;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterTeam extends RecyclerView.Adapter<AdapterTeam.ListViewHolder> {
    private ArrayList<DataModelActivity> dataModelActivityArrayList;

    public AdapterTeam(ArrayList<DataModelActivity> dataModelActivityArrayList) {
        this.dataModelActivityArrayList = dataModelActivityArrayList;
    }

    @NonNull
    @Override
    public AdapterTeam.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bp_team, parent, false);

        return new AdapterTeam.ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterTeam.ListViewHolder holder, int position) {
        DataModelActivity dataModelActivity = dataModelActivityArrayList.get(position);
        holder.tv_nama.setText(dataModelActivity.getNama());
        holder.tv_job.setText(dataModelActivity.getJob());
    }

    @Override
    public int getItemCount() {
        return dataModelActivityArrayList.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        TextView tv_nama,tv_job;
        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_nama = itemView.findViewById(R.id.tv_team_nama);
            tv_job = itemView.findViewById(R.id.tv_team_job);
        }
    }
}
