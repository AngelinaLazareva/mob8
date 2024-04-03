package com.example.myapplication5.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import android.widget.TextView;

import android.view.View;
import android.widget.Button;

import com.example.myapplication5.R;

import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.myapplication5.model.products;
import com.example.myapplication5.viewModels.productViewModel;
import com.example.myapplication5.viewModels.orderViewModel;

import com.example.myapplication5.data_pac.Orders;


public class SecondFragment extends Fragment {
    Orders order;
    Button secondFragmentButton1;
    Button secondFragmentButton2;
    TextView second_fragment_text_view;

    public SecondFragment() {super(R.layout.fragment_second);}

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //к листу
        secondFragmentButton2 = (Button) getActivity().findViewById(R.id.fragment_second_button2);

        //Информация о товаре

        second_fragment_text_view = getActivity().findViewById(R.id.fragment_second_text_view2);

        productViewModel productView_Model = new ViewModelProvider(getActivity()).get(productViewModel.class);
        orderViewModel orderView_Model = new ViewModelProvider(getActivity()).get(orderViewModel.class);
        productView_Model.getUiState().observe(getViewLifecycleOwner(), uiState -> {
            String info = uiState.getCurrentProductName() + " " + uiState.getCurrentProductAmount();
            second_fragment_text_view.setText(info);
        });

        secondFragmentButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                orderView_Model.addProductToOrder(productView_Model.getUiState().getValue().getProduct());
                productView_Model.inputProductParameters(null, null);

                Navigation.findNavController(view).navigate(R.id.action_secondFragment_to_thirdFragment);
            }
        });

    }
}