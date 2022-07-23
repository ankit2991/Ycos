package com.ycos.user.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ycos.user.Model.CarModelModel;
import com.ycos.user.Model.CarTypeModel;
import com.ycos.user.R;
import com.ycos.user.Utility.RecyclerViewClickListener;

import java.util.ArrayList;

public class CarModelAdapter extends RecyclerView.Adapter<CarModelAdapter.carModelViewHolder> {
    RecyclerViewClickListener aClickListener;
    Context context;
    ArrayList<CarModelModel> carModelModels;

    public CarModelAdapter(RecyclerViewClickListener aClickListener, Context context, ArrayList<CarModelModel> carModelModels) {
        this.aClickListener = aClickListener;
        this.context = context;
        this.carModelModels = carModelModels;
    }

    @NonNull
    @Override
    public carModelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dialogboxcarmodel_row_item, parent, false);
        return new carModelViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull carModelViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.carModel_txt.setText(carModelModels.get(position).getTitle());

        holder.carModel_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                aClickListener.onClick(view, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return carModelModels.size();
    }

    class carModelViewHolder extends RecyclerView.ViewHolder {

        TextView carModel_txt;

        public carModelViewHolder(@NonNull View itemView) {
            super(itemView);
            carModel_txt = itemView.findViewById(R.id.carModel_txt);

        }
    }
}
