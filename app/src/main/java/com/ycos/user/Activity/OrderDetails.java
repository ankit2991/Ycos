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
import com.ycos.user.Adapter.OrderDetailsAdapter;
import com.ycos.user.Model.OrderDetailModel;
import com.ycos.user.Model.OrderModel;
import com.ycos.user.R;
import com.ycos.user.Utility.Utils;

import java.util.ArrayList;

public class OrderDetails extends AppCompatActivity {
    TextView pr_header;
    private RecyclerView orderDetailsRecyclerview;
    ArrayList<OrderDetailModel> dataHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);

        Utils.blackIconStatusBar(OrderDetails.this, R.color.light_Background);

        //order recyclerview
        orderDetailsRecyclerview = findViewById(R.id.orderDetails_recycleView);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1);
        orderDetailsRecyclerview.setLayoutManager(gridLayoutManager);

        //initialize dataHolder for order recyclerview
        dataHolder = new ArrayList<>();

        OrderDetailModel orderMod1 = new OrderDetailModel(R.drawable.ic_logo,
                "Car Wash Service", "Only Wash", "Jodhpur Service Center");
        dataHolder.add(orderMod1);
        OrderDetailModel orderMod2 = new OrderDetailModel(R.drawable.ic_logo,
                "Car Wash Service", "Only Wash", "Jodhpur Service Center");
        dataHolder.add(orderMod2);

        orderDetailsRecyclerview.setAdapter(new OrderDetailsAdapter(dataHolder));

        // press BackActivity onClick
        ImageView imageView = findViewById(R.id.back_button);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OrderDetails.this, Orders.class);
                startActivity(intent);
            }
        });

        pr_header = findViewById(R.id.pr_header);
        pr_header.setText("Order Details");
    }
}