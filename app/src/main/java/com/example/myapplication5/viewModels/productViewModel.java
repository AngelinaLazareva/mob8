package com.example.myapplication5.viewModels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication5.repository.productInterf;
import com.example.myapplication5.repository.productRep;
public class productViewModel extends ViewModel {
    private final MutableLiveData<productInterf> uiState =
            new MutableLiveData<>(new productRep(null, null));
    public MutableLiveData<productInterf> getUiState() {
        return uiState;
    }

    public void inputProductParameters(String productName, String productAmount) {
        uiState.setValue(
                new productRep(productName, productAmount)
        );
    }
}