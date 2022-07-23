package com.ycos.user.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.ycos.user.R;
import com.ycos.user.Utility.Utils1;

public class OTPVerification extends AppCompatActivity {
    AppCompatButton btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otpverification);

        Utils1.blackIconStatusBar(OTPVerification.this, R.color.light_Background1);

        btn = findViewById(R.id.submit_btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OTPVerification.this, Home.class);
                startActivity(intent);
            }
        });
    }
}