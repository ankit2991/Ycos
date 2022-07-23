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

import com.ycos.user.Activity.OrderDetails;
import com.ycos.user.Model.OrderModel;
import com.ycos.user.R;

import java.util.ArrayList;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.orderViewHolder> {
    Context context;

    public OrderAdapter(Context context, ArrayList<OrderModel> dataHolder) {
        this.context = context;
        DataHolder = dataHolder;
    }

    ArrayList<OrderModel> DataHolder;

    @NonNull
    @Override
    public orderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.orders_row_item, parent, false);
        return new orderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull orderViewHolder holder, int position) {
        holder.orderDetails_img.setImageResource(DataHolder.get(position).getImage1());
        holder.orderUnchecked_img.setImageResource(DataHolder.get(position).getImage2());
        holder.OrderServiceNo_txt.setText(DataHolder.get(position).getTitle1());
        holder.OrderDate.setText(DataHolder.get(position).getTitle2());
        holder.orderTime.setText(DataHolder.get(position).getTitle3());
        holder.orderServiceName_txt.setText(DataHolder.get(position).getTitle4());
        holder.OrderShopName_txt.setText(DataHolder.get(position).getTitle5());
        holder.orderDetails_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, OrderDetails.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return DataHolder.size();
    }

    class orderViewHolder extends RecyclerView.ViewHolder {
        ImageView orderDetails_img;
        ImageView orderUnchecked_img;
        TextView OrderServiceNo_txt;
        TextView OrderDate;
        TextView orderTime;
        TextView orderServiceName_txt;
        TextView OrderShopName_txt;

        public orderViewHolder(@NonNull View itemView) {
            super(itemView);
            orderDetails_img = itemView.findViewById(R.id.orderDetails_img);
            orderUnchecked_img = itemView.findViewById(R.id.orderUnchecked_img);
            OrderServiceNo_txt = itemView.findViewById(R.id.OrderServiceNo_txt);
            OrderDate = itemView.findViewById(R.id.OrderDate);
            orderTime = itemView.findViewById(R.id.orderTime);
            orderServiceName_txt = itemView.findViewById(R.id.orderServiceName_txt);
            OrderShopName_txt = itemView.findViewById(R.id.OrderShopName_txt);
        }
    }
}
