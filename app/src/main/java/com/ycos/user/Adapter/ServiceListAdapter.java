package com.ycos.user.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ycos.user.Activity.ServiceDetail;
import com.ycos.user.Activity.ServiceList;
import com.ycos.user.Model.ServiceListModel;
import com.ycos.user.R;

import java.util.ArrayList;

public class ServiceListAdapter extends RecyclerView.Adapter<ServiceListAdapter.serviceListViewHolder> {
    ArrayList<ServiceListModel> DataHolder;
    Context context;


    public ServiceListAdapter(Context context, ArrayList<ServiceListModel> dataHolder) {
        DataHolder = dataHolder;
        this.context = context;
    }

    @NonNull
    @Override
    public serviceListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.servicelist_row_item, parent, false);
        return new serviceListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull serviceListViewHolder holder, int position) {
        holder.ServiceList_img.setImageResource(DataHolder.get(position).getImage1());
        holder.showServiceList_img.setImageResource(DataHolder.get(position).getImage2());
        holder.ServiceListCart_img.setImageResource(DataHolder.get(position).getImage3());
        holder.ServiceList_txt.setText(DataHolder.get(position).getTitle1());
        holder.payMod_txt.setText(DataHolder.get(position).getTitle2());
        holder.ServiceListRupee_txt.setText(DataHolder.get(position).getTitle3());
        holder.showServiceList_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ServiceDetail.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return DataHolder.size();
    }

    class serviceListViewHolder extends RecyclerView.ViewHolder {

        ImageView ServiceList_img;
        ImageView showServiceList_img;
        ImageView ServiceListCart_img;
        TextView ServiceList_txt;
        TextView payMod_txt;
        TextView ServiceListRupee_txt;

        public serviceListViewHolder(@NonNull View itemView) {
            super(itemView);
            ServiceList_img = itemView.findViewById(R.id.ServiceList_img);
            showServiceList_img = itemView.findViewById(R.id.showServiceList_img);
            ServiceListCart_img = itemView.findViewById(R.id.ServiceListCart_img);
            ServiceList_txt = itemView.findViewById(R.id.ServiceList_txt);
            payMod_txt = itemView.findViewById(R.id.payMod_txt);
            ServiceListRupee_txt = itemView.findViewById(R.id.ServiceListRupee_txt);
        }
    }
}
