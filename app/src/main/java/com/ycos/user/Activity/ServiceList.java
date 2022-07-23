package com.ycos.user.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.ycos.user.Adapter.ServiceListAdapter;
import com.ycos.user.Model.ServiceListModel;
import com.ycos.user.R;
import com.ycos.user.Utility.Utils;

import java.util.ArrayList;

public class ServiceList extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String[] Price = {"Price", "Low-High", "High-Low", "Low", "High"};
    Spinner spinner;
    private RecyclerView ServicesListRecyclerview;
    ArrayList<ServiceListModel> dataHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_list);

        Utils.blackIconStatusBar(ServiceList.this, R.color.light_Background);

        spinner = findViewById(R.id.Spinner);
        spinner.setOnItemSelectedListener(this);

        //Creating the ArrayAdapter instance having the bank name list

        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, Price);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //Setting the ArrayAdapter data on the Spinner
        spinner.setAdapter(aa);


        //ServicesList recyclerview
        ServicesListRecyclerview = findViewById(R.id.serviceList_recyclerView);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1);
        ServicesListRecyclerview.setLayoutManager(gridLayoutManager);

        //initialize dataHolder for ServicesList recyclerview
        dataHolder = new ArrayList<>();

        ServiceListModel SerLiMod1 = new ServiceListModel(R.drawable.ic_logo, R.drawable.ic_eye1, R.drawable.ic_cart1,
                "Car Wash Services", "Only Cash", "800");
        dataHolder.add(SerLiMod1);
        ServiceListModel SerLiMod2 = new ServiceListModel(R.drawable.ic_logo, R.drawable.ic_eye1, R.drawable.ic_cart1,
                "Car Wash Services", "Only Cash", "800");
        dataHolder.add(SerLiMod2);

        ServicesListRecyclerview.setAdapter(new ServiceListAdapter(this, dataHolder));

        // press BackActivity onClick
        ImageView imageView = findViewById(R.id.back_button);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ServiceList.this, Category.class);
                startActivity(intent);
            }
        });

    }


    //Performing action onItemSelected and onNothing selected
    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }


}
