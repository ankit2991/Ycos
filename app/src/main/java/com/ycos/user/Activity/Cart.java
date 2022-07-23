package com.ycos.user.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ycos.user.Adapter.CartAdapter;
import com.ycos.user.Adapter.ServiceListAdapter;
import com.ycos.user.Model.CartModel;
import com.ycos.user.Model.ServiceListModel;
import com.ycos.user.R;
import com.ycos.user.Utility.Utils;

import java.util.ArrayList;

public class Cart extends AppCompatActivity {
    AppCompatButton btn;
    TextView pr_header;
    private RecyclerView cartRecyclerview;
    ArrayList<CartModel> dataHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        Utils.blackIconStatusBar(Cart.this, R.color.light_Background);

        //ServicesList recyclerview
        cartRecyclerview = findViewById(R.id.cart_recyclerView);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1);
        cartRecyclerview.setLayoutManager(gridLayoutManager);

        //initialize dataHolder for ServicesList recyclerview
        dataHolder = new ArrayList<>();

        CartModel cartMod1 = new CartModel(R.drawable.ic_logo,
                "Car Wash Services", "Only Cash", "800");
        dataHolder.add(cartMod1);
        CartModel cartMod2 = new CartModel(R.drawable.ic_logo,
                "Car Wash Services", "Only Cash", "800");
        dataHolder.add(cartMod2);

        cartRecyclerview.setAdapter(new CartAdapter(dataHolder));

        btn = findViewById(R.id.cart_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Cart.this, CartDetails.class);
                startActivity(intent);
            }
        });

        // press BackActivity onClick
        ImageView imageView = findViewById(R.id.back_button);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Cart.this, ServiceDetail.class);
                startActivity(intent);
            }
        });

        pr_header = findViewById(R.id.pr_header);
        pr_header.setText("Cart");
    }
}