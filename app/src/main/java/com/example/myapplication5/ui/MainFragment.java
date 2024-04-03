// MainFragment.java
package com.example.myapplication5.ui;



import com.example.myapplication5.R;
import com.example.myapplication5.data_pac.Orders;
import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.myapplication5.R;


import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;


import com.example.myapplication5.model.products;
import com.example.myapplication5.viewModels.orderViewModel;

import java.util.ArrayList;

public class MainFragment extends Fragment {
    Button main_fragment_button1;
    Button main_fragment_button2;
    TextView main_fragment_text_view;
    public MainFragment() {
        super(R.layout.fragment_main);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        main_fragment_button1 = (Button) getActivity().findViewById(R.id.fragment_main_button1);
        main_fragment_button2 = (Button) getActivity().findViewById(R.id.fragment_main_button2);
        main_fragment_text_view = (TextView) getActivity().findViewById(R.id.text_view);
        orderViewModel order = new ViewModelProvider(getActivity()).get(orderViewModel.class);
        order.getUiState().observe(getViewLifecycleOwner(), uiState -> {
            String info;

            if (uiState.getOrderedPositions() == null)
                info = "There are : 0 products";
            else {
                int arrayLength = uiState.getOrderedPositions().size();
                info = "The amount of products is: " + Integer.toString(arrayLength);
            }
            main_fragment_text_view.setText(info);
        });
        main_fragment_button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_firstFragment);
            }
        });
        main_fragment_button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_thirdFragment);
            }
        });
    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}