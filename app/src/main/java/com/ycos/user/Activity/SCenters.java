package com.ycos.user.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.ycos.user.Adapter.SCenterAdapter;
import com.ycos.user.Adapter.ServiceCentersAdapter;
import com.ycos.user.Adapter.ServiceListAdapter;
import com.ycos.user.Model.FeaturedModel;
import com.ycos.user.Model.SCenterModel;
import com.ycos.user.Model.ServiceCentersModel;
import com.ycos.user.R;
import com.ycos.user.Utility.Utils;

import java.util.ArrayList;

public class SCenters extends AppCompatActivity {
    private RecyclerView SCenterRecyclerview;
    ArrayList<SCenterModel> dataHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_centers);

        Utils.blackIconStatusBar(SCenters.this, R.color.light_Background);

        //featured recyclerview
        SCenterRecyclerview = findViewById(R.id.SCenter_recyclerView);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1);
        SCenterRecyclerview.setLayoutManager(gridLayoutManager);

        //initialize dataHolder for featured recyclerview
        dataHolder = new ArrayList<>();

        SCenterModel SerMod1 = new SCenterModel(R.drawable.ic_logo, R.drawable.ic_eye,
                R.drawable.ic_location, "Jodhpur Car Services", "Ratanada , Jodhpur", "\u20B9 1000");
        dataHolder.add(SerMod1);
        SCenterModel SerMod2 = new SCenterModel(R.drawable.ic_logo, R.drawable.ic_eye,
                R.drawable.ic_location, "Jodhpur Car Services", "Ratanada , Jodhpur", "\u20B9 1000");
        dataHolder.add(SerMod2);
        SCenterModel SerMod3 = new SCenterModel(R.drawable.ic_logo, R.drawable.ic_eye,
                R.drawable.ic_location, "Jodhpur Car Services", "Ratanada , Jodhpur", "\u20B9 1000");
        dataHolder.add(SerMod3);

        SCenterRecyclerview.setAdapter(new SCenterAdapter(dataHolder, this));
    }
}