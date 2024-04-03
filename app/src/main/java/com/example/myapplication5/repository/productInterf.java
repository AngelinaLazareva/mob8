package com.example.myapplication5.repository;
import com.example.myapplication5.model.products;
public interface productInterf {


    String getCurrentProductName();
    String getCurrentProductAmount();
    void setCurrentProductName(String productName);
    void setCurrentProductAmount(String productAmount);
    products getProduct();
}
