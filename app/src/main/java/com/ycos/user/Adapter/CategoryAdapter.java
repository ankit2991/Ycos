package com.ycos.user.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.ycos.user.Activity.ServiceList;
import com.ycos.user.Model.CategoryModel;
import com.ycos.user.Model.ServiceCentersModel;
import com.ycos.user.R;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.categoryViewHolder> {
    Context context;


    ArrayList<CategoryModel> DataHolder;

    public CategoryAdapter(Context context, ArrayList<CategoryModel> dataHolder) {
        this.context = context;
        DataHolder = dataHolder;
    }

    @NonNull
    @Override
    public categoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.categorys_row_item, parent, false);
        return new categoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull categoryViewHolder holder, int position) {
        holder.category_img.setImageResource(DataHolder.get(position).getImage());
        holder.category_txt.setText(DataHolder.get(position).getTitle());
        holder.category_cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ServiceList.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return DataHolder.size();
    }

    class categoryViewHolder extends RecyclerView.ViewHolder {
        CardView category_cardView;
        ImageView category_img;
        TextView category_txt;

        public categoryViewHolder(@NonNull View itemView) {
            super(itemView);
            category_img = itemView.findViewById(R.id.category_img);
            category_cardView = itemView.findViewById(R.id.category_cardView);
            category_txt = itemView.findViewById(R.id.category_txt);

        }
    }
}
