package com.ycos.user.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.ycos.user.R;
import com.ycos.user.Utility.Utils;

public class RateUs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_us);

        Utils.blackIconStatusBar(RateUs.this, R.color.light_Background);

    }
}