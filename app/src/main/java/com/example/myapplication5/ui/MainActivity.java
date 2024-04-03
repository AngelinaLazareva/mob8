package com.example.myapplication5.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.lifecycle.ViewModelProvider;
import com.example.myapplication5.viewModels.productViewModel;
import com.example.myapplication5.viewModels.orderViewModel;

import com.example.myapplication5.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        productViewModel productView_Model = new ViewModelProvider(this).get(productViewModel.class);
        orderViewModel orderView_Model = new ViewModelProvider(this).get(orderViewModel.class);
    }

}