package com.example.calculatecubicweight;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.calculatecubicweight.data.Objects;
import com.example.calculatecubicweight.utils.GlobalUtils;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String AIR_CONDITIONER = "Air Conditioners";
    
    private TextView mAverageWeight;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Objects> productsList;
    private ArrayList<Objects> categoryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAverageWeight = findViewById(R.id.average_weight);

        productsList = new ArrayList<>();
        categoryList = new ArrayList<>();

        recyclerView = findViewById(R.id.list_item);

        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setNestedScrollingEnabled(false);
        MyViewModel model = new ViewModelProvider(this).get(MyViewModel.class);
        model.getProducts().observe(this, new Observer<List<Objects>>() {
            @Override
            public void onChanged(List<Objects> products) {
                updateUI(products);
            }
        });
    }

    private void updateUI(List<Objects> products) {
        if (products != null && !products.isEmpty()) {
            productsList.addAll(products);
            float averageWeight = GlobalUtils.calculateAverageCubicWeight(AIR_CONDITIONER, productsList);
            categoryList = GlobalUtils.getCategoryList(AIR_CONDITIONER, productsList);
            mAdapter = new MyAdapter(categoryList);
            recyclerView.setAdapter(mAdapter);
            mAverageWeight.setText(String.valueOf(averageWeight));
        }
    }
}
