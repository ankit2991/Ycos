package com.ycos.user.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ycos.user.Model.CartModel;
import com.ycos.user.Model.ServiceListModel;
import com.ycos.user.R;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.cartViewHolder> {
    ArrayList<CartModel> DataHolder;

    public CartAdapter(ArrayList<CartModel> dataHolder) {
        DataHolder = dataHolder;
    }

    @NonNull
    @Override
    public cartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_row_item, parent, false);
        return new cartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull cartViewHolder holder, int position) {
        holder.cart_img.setImageResource(DataHolder.get(position).getImage());
        holder.cartName_txt.setText(DataHolder.get(position).getTitle1());
        holder.cartPayMod_txt.setText(DataHolder.get(position).getTitle2());
        holder.cartRupee_txt.setText(DataHolder.get(position).getTitle3());
    }

    @Override
    public int getItemCount() {
        return DataHolder.size();
    }

    class cartViewHolder extends RecyclerView.ViewHolder {
        ImageView cart_img;
        TextView cartName_txt;
        TextView cartPayMod_txt;
        TextView cartRupee_txt;

        public cartViewHolder(@NonNull View itemView) {
            super(itemView);

            cart_img = itemView.findViewById(R.id.cart_img);
            cartName_txt = itemView.findViewById(R.id.cartName_txt);
            cartPayMod_txt = itemView.findViewById(R.id.cartPayMod_txt);
            cartRupee_txt = itemView.findViewById(R.id.cartRupee_txt);
        }
    }
}
