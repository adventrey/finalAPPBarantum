package com.arpbtxrebon.barantum;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterActivity extends RecyclerView.Adapter<AdapterActivity.ListViewHolder> {
    private OnItemClickCallBack onItemClickCallBack;
    public void setOnItemClickCallBack(OnItemClickCallBack onItemClickCallBack) {
        this.onItemClickCallBack = onItemClickCallBack;
    }
    private ArrayList<DataModelActivity>dataModelActivityArrayList;

    public AdapterActivity(ArrayList<DataModelActivity> dataModelActivityArrayList) {
        this.dataModelActivityArrayList = dataModelActivityArrayList;
    }

    @NonNull
    @Override
    public AdapterActivity.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bp_activity, parent, false);

        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterActivity.ListViewHolder holder, int position) {
        DataModelActivity dataModelActivity = dataModelActivityArrayList.get(position);
        holder.tv_nama.setText(dataModelActivity.getNama());
        holder.tv_job.setText(dataModelActivity.getJob());
        holder.tv_status.setText(dataModelActivity.getStatus());
        holder.tv_date.setText(dataModelActivity.getDate());
        holder.tv_activity.setText(dataModelActivity.getActivity());
        holder.iv_edit_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallBack.onItemClicked(position);

            }
        });
    }

    @Override
    public int getItemCount() {
        return dataModelActivityArrayList.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
          TextView tv_nama,tv_job,tv_date,tv_activity,tv_status;
          ImageView iv_edit_activity;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_nama = itemView.findViewById(R.id.tv_activity_nama);
            tv_job = itemView.findViewById(R.id.tv_activity_job);
            tv_status = itemView.findViewById(R.id.tv_activity_status);
            tv_date = itemView.findViewById(R.id.tv_activity_date);
            tv_activity = itemView.findViewById(R.id.tv_activity_activity);
            iv_edit_activity = itemView.findViewById(R.id.iv_activity_edit);

        }
    }
    public interface OnItemClickCallBack {
        void onItemClicked(int position);
    }
}
