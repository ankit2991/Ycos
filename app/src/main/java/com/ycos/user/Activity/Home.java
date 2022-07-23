package com.ycos.user.Activity;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ycos.user.Adapter.FeaturedAdapter;
import com.ycos.user.Adapter.ServiceCentersAdapter;
import com.ycos.user.Model.FeaturedModel;
import com.ycos.user.Model.ServiceCentersModel;
import com.ycos.user.R;
import com.ycos.user.Utility.Utils;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class Home extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ImageView imageView;

    ImageView popularRight_img;

    TextView UserSideProfile, UserCategory, USerOrdersHistory, aboutUS, contactUs, termsCondition, shareApp, rateUS;
    AppCompatButton sideMenu_logout;

    private RecyclerView featuredRecyclerview;
    ArrayList<FeaturedModel> dataHolder;

    private RecyclerView serviceCentersRecyclerview;
    ArrayList<ServiceCentersModel> dataHolder2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Utils.blackIconStatusBar(Home.this, R.color.light_Background);


        UserSideProfile = findViewById(R.id.UserSideProfile);
        UserCategory = findViewById(R.id.UserCategory);
        USerOrdersHistory = findViewById(R.id.USerOrdersHistory);
        aboutUS = findViewById(R.id.aboutUS);
        contactUs = findViewById(R.id.contactUs);
        termsCondition = findViewById(R.id.termsCondition);
        shareApp = findViewById(R.id.shareApp);
        rateUS = findViewById(R.id.rateUS);
        sideMenu_logout = findViewById(R.id.sideMenu_logout);
        popularRight_img = findViewById(R.id.popularRight_img);

        popularRight_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, SCenters.class);
                startActivity(intent);
            }
        });
        UserSideProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, MyProfile.class);
                startActivity(intent);
            }
        });

        UserCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, Category.class);
                startActivity(intent);
            }
        });

        USerOrdersHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, Orders.class);
                startActivity(intent);
            }
        });

        aboutUS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, MyProfile.class);
                startActivity(intent);
            }
        });

        contactUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, MyProfile.class);
                startActivity(intent);
            }
        });

        termsCondition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, MyProfile.class);
                startActivity(intent);
            }
        });

        shareApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, MyProfile.class);
                startActivity(intent);
            }
        });

        rateUS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, MyProfile.class);
                startActivity(intent);
            }
        });

        sideMenu_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, Login.class);
                startActivity(intent);
            }
        });


        drawerLayout = findViewById(R.id.DrawerLayout);
        navigationView = findViewById(R.id.navigation_view);
        imageView = findViewById(R.id.menu_bar);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });


        /*------- Navigation Drawer Menu -------*/
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.navigation_open, R.string.navigation_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setCheckedItem(R.id.DrawerLayout);


        //featured recyclerview
        featuredRecyclerview = findViewById(R.id.FeaturedServices);

        LinearLayoutManager GridLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        featuredRecyclerview.setLayoutManager(GridLayoutManager);

        //initialize dataHolder for featured recyclerview
        dataHolder = new ArrayList<>();

        FeaturedModel lisMod1 = new FeaturedModel(R.drawable.ic_logo, "Repairing");
        dataHolder.add(lisMod1);
        FeaturedModel lisMod2 = new FeaturedModel(R.drawable.ic_logo, "Car Wash");
        dataHolder.add(lisMod2);
        FeaturedModel lisMod3 = new FeaturedModel(R.drawable.ic_logo, "Wash");
        dataHolder.add(lisMod3);

        featuredRecyclerview.setAdapter(new FeaturedAdapter(dataHolder));


        //featured recyclerview
        serviceCentersRecyclerview = findViewById(R.id.popularServices);

        LinearLayoutManager ServiceGridLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        serviceCentersRecyclerview.setLayoutManager(ServiceGridLayoutManager);

        //initialize dataHolder for featured recyclerview
        dataHolder2 = new ArrayList<>();

        ServiceCentersModel SerMod1 = new ServiceCentersModel(R.drawable.ic_logo, R.drawable.ic_eye,
                R.drawable.ic_location, "Jodhpur Car Services", "1000");
        dataHolder2.add(SerMod1);
        ServiceCentersModel SerMod2 = new ServiceCentersModel(R.drawable.ic_logo, R.drawable.ic_eye,
                R.drawable.ic_location, "Jodhpur Car Services", "1000");
        dataHolder2.add(SerMod2);
        ServiceCentersModel SerMod3 = new ServiceCentersModel(R.drawable.ic_logo, R.drawable.ic_eye,
                R.drawable.ic_location, "Jodhpur Car Services", "1000");
        dataHolder2.add(SerMod3);

        serviceCentersRecyclerview.setAdapter(new ServiceCentersAdapter(Home.this, dataHolder2));
    }
}