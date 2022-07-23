package com.ycos.user.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ycos.user.Adapter.CategoryAdapter;
import com.ycos.user.Model.CategoryModel;
import com.ycos.user.R;
import com.ycos.user.Utility.Utils;

import java.util.ArrayList;

public class Category extends AppCompatActivity {
    TextView pr_header;

    private RecyclerView categoryRecyclerview;
    ArrayList<CategoryModel> dataHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        Utils.blackIconStatusBar(Category.this, R.color.light_Background);

        categoryRecyclerview = findViewById(R.id.category_recyclerView);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        categoryRecyclerview.setLayoutManager(gridLayoutManager);

        dataHolder = new ArrayList<>();

        CategoryModel caMod1 = new CategoryModel(R.drawable.ic_logo, "Repairing");
        dataHolder.add(caMod1);

        CategoryModel caMod2 = new CategoryModel(R.drawable.ic_logo, "Repairing");
        dataHolder.add(caMod2);

        CategoryModel caMod3 = new CategoryModel(R.drawable.ic_logo, "Repairing");
        dataHolder.add(caMod3);

        CategoryModel caMod4 = new CategoryModel(R.drawable.ic_logo, "Repairing");
        dataHolder.add(caMod4);

        categoryRecyclerview.setAdapter(new CategoryAdapter(this, dataHolder));

        // press BackActivity onClick
        ImageView imageView = findViewById(R.id.back_button);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Category.this, Home.class);
                startActivity(intent);
            }
        });

        pr_header = findViewById(R.id.pr_header);
        pr_header.setText("Category");
    }
}