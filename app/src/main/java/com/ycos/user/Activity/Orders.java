package com.ycos.user.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ycos.user.Adapter.OrderAdapter;
import com.ycos.user.Model.OrderModel;
import com.ycos.user.R;
import com.ycos.user.Utility.Utils;

import java.util.ArrayList;

public class Orders extends AppCompatActivity {
    TextView pr_header;

    private RecyclerView orderRecyclerview;
    ArrayList<OrderModel> dataHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);

        Utils.blackIconStatusBar(Orders.this, R.color.light_Background);

        //order recyclerview
        orderRecyclerview = findViewById(R.id.order_recycleView);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1);
        orderRecyclerview.setLayoutManager(gridLayoutManager);

        //initialize dataHolder for order recyclerview
        dataHolder = new ArrayList<>();

        OrderModel orderMod1 = new OrderModel(R.drawable.ic_eye1, R.drawable.ic_unchecked,
                "Service No: #234", "22 July 2022", "1:40 PM", "Car Wash", "Jodhpur Car Service");
        dataHolder.add(orderMod1);
        OrderModel orderMod2 = new OrderModel(R.drawable.ic_unchecked, R.drawable.ic_eye1,
                "Service No: #234", "22 July 2022", "1:40 PM", "Car Wash", "Jodhpur Car Service");
        dataHolder.add(orderMod2);

        orderRecyclerview.setAdapter(new OrderAdapter(this, dataHolder));

        // press BackActivity onClick
        ImageView imageView = findViewById(R.id.back_button);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Orders.this, Home.class);
                startActivity(intent);
            }
        });

        pr_header = findViewById(R.id.pr_header);
        pr_header.setText("Orders");
    }
}