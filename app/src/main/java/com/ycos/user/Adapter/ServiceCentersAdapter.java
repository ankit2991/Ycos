package com.ycos.user.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ycos.user.Model.FeaturedModel;
import com.ycos.user.Model.ServiceCentersModel;
import com.ycos.user.R;

import java.util.ArrayList;

public class ServiceCentersAdapter extends RecyclerView.Adapter<ServiceCentersAdapter.serviceCentersViewHolder> {
    ArrayList<ServiceCentersModel> DataHolder;
    Context context;

    public ServiceCentersAdapter(Context context, ArrayList<ServiceCentersModel> dataHolder) {
        this.context = context;
        DataHolder = dataHolder;
    }

    @NonNull
    @Override
    public serviceCentersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.service_centers_row_item, parent, false);
        return new serviceCentersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull serviceCentersViewHolder holder, int position) {
        holder.popular_img.setImageResource(DataHolder.get(position).getImage1());
        holder.details_img.setImageResource(DataHolder.get(position).getImage2());
        holder.location_img.setImageResource(DataHolder.get(position).getImage3());
        holder.popular_txt.setText(DataHolder.get(position).getTitle1());
        holder.price_txt.setText(DataHolder.get(position).getTitle2());

    }

    @Override
    public int getItemCount() {
        return DataHolder.size();
    }

    class serviceCentersViewHolder extends RecyclerView.ViewHolder {
        ImageView popular_img;
        ImageView details_img;
        ImageView location_img;
        TextView popular_txt;
        TextView price_txt;

        public serviceCentersViewHolder(@NonNull View itemView) {
            super(itemView);

            popular_img = itemView.findViewById(R.id.popular_img);
            details_img = itemView.findViewById(R.id.details_img);
            location_img = itemView.findViewById(R.id.location_img);
            popular_txt = itemView.findViewById(R.id.popular_txt);
            price_txt = itemView.findViewById(R.id.price_txt);

        }
    }
}
