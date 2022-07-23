package com.ycos.user.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ycos.user.Model.CarTypeModel;
import com.ycos.user.Model.ServiceCentersModel;
import com.ycos.user.R;
import com.ycos.user.Utility.RecyclerViewClickListener;

import java.util.ArrayList;

public class CarTypeAdapter extends RecyclerView.Adapter<CarTypeAdapter.carTypeViewHolder> {
    RecyclerViewClickListener aClickListener;
    Context context;
    ArrayList<CarTypeModel> DataHolder;

    public CarTypeAdapter(RecyclerViewClickListener aClickListener, Context context, ArrayList<CarTypeModel> dataHolder) {
        this.aClickListener = aClickListener;
        this.context = context;

        DataHolder = dataHolder;
    }

    @NonNull
    @Override
    public carTypeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dialogbox_row_item, parent, false);
        return new carTypeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull carTypeViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.carType_txt.setText(DataHolder.get(position).getTitle());

        holder.carType_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                aClickListener.onClick(view, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return DataHolder.size();
    }

    class carTypeViewHolder extends RecyclerView.ViewHolder {

        TextView carType_txt;

        public carTypeViewHolder(@NonNull View itemView) {
            super(itemView);
            carType_txt = itemView.findViewById(R.id.carType_txt);

        }
    }
}
