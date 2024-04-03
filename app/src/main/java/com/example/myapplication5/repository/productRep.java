package com.example.myapplication5.repository;

import com.example.myapplication5.data_source.product_dataSource;
import com.example.myapplication5.model.products;

import java.io.Serializable;

public class productRep implements productInterf, Serializable {
    private product_dataSource currentProductManager;
    public productRep() {}
    public productRep(String goodName, String goodAmount) {
        currentProductManager = new product_dataSource(new products(goodName, goodAmount));
    }
    public String getCurrentProductName() {
        return currentProductManager.getCurrentProduct().getProductName();
    }

    public String getCurrentProductAmount() {
        return currentProductManager.getCurrentProduct().getProductAmount();
    }

    public void setCurrentProductName(String productName) {
        products currentProduct = currentProductManager.getCurrentProduct();
        currentProduct.setProductName(productName);
        currentProductManager.SetCurrentProduct(currentProduct);
    }
    public void setCurrentProductAmount(String productAmount) {
        products currentProduct = currentProductManager.getCurrentProduct();
        currentProduct.setProductAmount(productAmount);
        currentProductManager.SetCurrentProduct(currentProduct);
    }
    public products getProduct() {
        return currentProductManager.getCurrentProduct();
    }
}
