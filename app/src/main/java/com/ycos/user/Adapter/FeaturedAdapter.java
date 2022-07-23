package com.ycos.user.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ycos.user.Model.FeaturedModel;
import com.ycos.user.R;

import java.util.ArrayList;

public class FeaturedAdapter extends RecyclerView.Adapter<FeaturedAdapter.featuredViewHolder> {
    ArrayList<FeaturedModel> DataHolder;

    public FeaturedAdapter(ArrayList<FeaturedModel> dataHolder) {
        DataHolder = dataHolder;
    }

    @NonNull
    @Override
    public featuredViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.featured_row_item, parent, false);
        return new featuredViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull featuredViewHolder holder, int position) {
        holder.imageView.setImageResource(DataHolder.get(position).getImage());
        holder.textView.setText(DataHolder.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return DataHolder.size();
    }

    class featuredViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public featuredViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.featured_image);
            textView = itemView.findViewById(R.id.featured_txt);

        }
    }
}
