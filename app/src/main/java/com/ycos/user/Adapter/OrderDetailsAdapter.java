package com.ycos.user.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ycos.user.Model.OrderDetailModel;
import com.ycos.user.Model.OrderModel;
import com.ycos.user.R;

import java.util.ArrayList;

public class OrderDetailsAdapter extends RecyclerView.Adapter<OrderDetailsAdapter.orderDetailsViewHolder> {
    ArrayList<OrderDetailModel> DataHolder;

    public OrderDetailsAdapter(ArrayList<OrderDetailModel> dataHolder) {
        DataHolder = dataHolder;
    }

    @NonNull
    @Override
    public orderDetailsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.orderdetails_row_item, parent, false);
        return new orderDetailsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull orderDetailsViewHolder holder, int position) {
        holder.orderDetails_img.setImageResource(DataHolder.get(position).getImage());
        holder.orderDeName_txt.setText(DataHolder.get(position).getTitle1());
        holder.orderDeMod_txt.setText(DataHolder.get(position).getTitle2());
        holder.orderDeShopName_txt.setText(DataHolder.get(position).getTitle3());
    }

    @Override
    public int getItemCount() {
        return DataHolder.size();
    }

    class orderDetailsViewHolder extends RecyclerView.ViewHolder {
        ImageView orderDetails_img;
        TextView orderDeName_txt;
        TextView orderDeMod_txt;
        TextView orderDeShopName_txt;

        public orderDetailsViewHolder(@NonNull View itemView) {
            super(itemView);

            orderDetails_img = itemView.findViewById(R.id.orderDetails_img);
            orderDeName_txt = itemView.findViewById(R.id.orderDeName_txt);
            orderDeMod_txt = itemView.findViewById(R.id.orderDeMod_txt);
            orderDeShopName_txt = itemView.findViewById(R.id.orderDeShopName_txt);
        }
    }
}
