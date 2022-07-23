package com.ycos.user.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;

import com.ycos.user.Adapter.CarTypeAdapter;
import com.ycos.user.Model.CarTypeModel;
import com.ycos.user.R;
import com.ycos.user.Utility.RecyclerViewClickListener;
import com.ycos.user.Utility.Utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class CartDetails extends AppCompatActivity {

    TextView DateFormat;
    TextView TimeFormat;

    // Date Piker Dialog
    DatePickerDialog.OnDateSetListener onDateSetListener;
    // time piker Dialog
    TimePickerDialog mTimePicker;

    TextView pr_header;

    TextView tv_car_type;
    private RecyclerView carTypeRecyclerview;
    ArrayList<CarTypeModel> carTypeModelArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_details);

        Utils.blackIconStatusBar(CartDetails.this, R.color.light_Background);


        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        //Date piker
        DateFormat = findViewById(R.id.DateFormat);
        DateFormat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(CartDetails.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        DateFormat.setText(SimpleDateFormat.getDateInstance().format(calendar.getTime()));
                    }
                }, year, month, day);
                datePickerDialog.show();
            }
        });

        //time piker
        TimeFormat = findViewById(R.id.TimeFormat);
        TimeFormat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar currentTime = Calendar.getInstance();
                int hour = currentTime.get(Calendar.HOUR_OF_DAY);
                int minute = currentTime.get(Calendar.MINUTE);
                mTimePicker = new TimePickerDialog(CartDetails.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        TimeFormat.setText(selectedHour + ":" + selectedMinute);
                    }
                }, hour, minute, true);//Yes 24 hour time
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();

            }
        });


        //initialize dataHolder for carType recyclerview
        carTypeModelArrayList = new ArrayList<>();

        CarTypeModel carMod1 = new CarTypeModel("Thar");
        carTypeModelArrayList.add(carMod1);
        CarTypeModel carMod2 = new CarTypeModel("Mahindra");
        carTypeModelArrayList.add(carMod2);
        CarTypeModel carMod3 = new CarTypeModel("Suzuki");
        carTypeModelArrayList.add(carMod3);
        CarTypeModel carMod4 = new CarTypeModel("MG");
        carTypeModelArrayList.add(carMod4);


        //Dialog Box
        tv_car_type = findViewById(R.id.tv_car_type);
        tv_car_type.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                carTypeDialog();
            }
        });

        // press BackActivity onClick
        ImageView imageView = findViewById(R.id.back_button);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CartDetails.this, Cart.class);
                startActivity(intent);
            }
        });

        pr_header = findViewById(R.id.pr_header);
        pr_header.setText("Cart Details");
    }

    public void carTypeDialog() {
        final Dialog dialog = new Dialog(CartDetails.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.cartype);

        //carType recyclerview
        carTypeRecyclerview = dialog.findViewById(R.id.carType_recyclerview);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1);
        carTypeRecyclerview.setLayoutManager(gridLayoutManager);


        carTypeRecyclerview.setAdapter(new CarTypeAdapter(new RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                tv_car_type.setText(carTypeModelArrayList.get(position).getTitle());
                dialog.dismiss();
            }
        }, CartDetails.this, carTypeModelArrayList));


        dialog.show();
    }
}