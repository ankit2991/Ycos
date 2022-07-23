package com.ycos.user.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.ycos.user.R;
import com.ycos.user.Utility.Utils;

public class ServiceDetail extends AppCompatActivity {
    TextView pr_header;
    FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_detail);

        Utils.blackIconStatusBar(ServiceDetail.this, R.color.light_Background);

        floatingActionButton = findViewById(R.id.floatingBtn);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ServiceDetail.this, Cart.class);
                startActivity(intent);
            }
        });

        // press BackActivity onClick
        ImageView imageView = findViewById(R.id.back_button);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ServiceDetail.this, ServiceList.class);
                startActivity(intent);
            }
        });

        pr_header = findViewById(R.id.pr_header);
        pr_header.setText("Service Details");
    }
}