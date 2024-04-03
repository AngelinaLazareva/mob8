package com.example.myapplication5.viewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication5.repository.orderInterf;
import com.example.myapplication5.repository.OrderRep;
import com.example.myapplication5.model.products;


import java.util.ArrayList;

public class orderViewModel extends ViewModel {
    private final MutableLiveData<orderInterf> uiState =
            new MutableLiveData<>(new OrderRep(null));
    public LiveData<orderInterf> getUiState() {
        return uiState;
    }

    public void addProductToOrder(products product) {
        orderInterf order;
        order = uiState.getValue();
        if (order != null)
            order.putProduct(product);
        else {
            ArrayList<products> products = new ArrayList<>();
            products.add(product);
            order = new OrderRep(products);
        }

        uiState.setValue(
                order
        );
    }
}