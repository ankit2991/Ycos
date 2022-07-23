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

import com.ycos.user.Activity.SCenters;
import com.ycos.user.Activity.VendorDetail;
import com.ycos.user.Model.SCenterModel;
import com.ycos.user.Model.ServiceCentersModel;
import com.ycos.user.R;

import java.util.ArrayList;

public class SCenterAdapter extends RecyclerView.Adapter<SCenterAdapter.sCenterViewHolder> {
    ArrayList<SCenterModel> DataHolder;
    Context context;

    public SCenterAdapter(ArrayList<SCenterModel> dataHolder, Context context) {
        DataHolder = dataHolder;
        this.context = context;
    }

    @NonNull
    @Override
    public sCenterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.center_row_item, parent, false);
        return new sCenterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull sCenterViewHolder holder, int position) {
        holder.sCenter_img.setImageResource(DataHolder.get(position).getImage1());
        holder.sCenterDetails_img.setImageResource(DataHolder.get(position).getImage2());
        holder.sCenterLocation_img.setImageResource(DataHolder.get(position).getImage3());
        holder.sCenterName_txt.setText(DataHolder.get(position).getTitle1());
        holder.sCenterAddress_txt.setText(DataHolder.get(position).getTitle2());
        holder.sCenterPrice_txt.setText(DataHolder.get(position).getTitle3());

        holder.sCenterDetails_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, VendorDetail.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return DataHolder.size();
    }

    class sCenterViewHolder extends RecyclerView.ViewHolder {
        ImageView sCenter_img;
        ImageView sCenterDetails_img;
        ImageView sCenterLocation_img;
        TextView sCenterName_txt;
        TextView sCenterAddress_txt;
        TextView sCenterPrice_txt;

        public sCenterViewHolder(@NonNull View itemView) {
            super(itemView);

            sCenter_img = itemView.findViewById(R.id.sCenter_img);
            sCenterDetails_img = itemView.findViewById(R.id.sCenterDetails_img);
            sCenterLocation_img = itemView.findViewById(R.id.sCenterLocation_img);
            sCenterName_txt = itemView.findViewById(R.id.sCenterName_txt);
            sCenterAddress_txt = itemView.findViewById(R.id.sCenterAddress_txt);
            sCenterPrice_txt = itemView.findViewById(R.id.sCenterPrice_txt);
        }
    }
}
