package com.example.myapplication5.repository;


import java.util.ArrayList;
import java.util.HashMap;

import com.example.myapplication5.data_source.order_dataSource;
import com.example.myapplication5.model.products;

public class OrderRep implements orderInterf {
    order_dataSource ordermanager = null;
    public OrderRep(ArrayList<products> values) {
        if (values != null) {
            this.ordermanager = new order_dataSource(new HashMap<Integer, products>());
            for (products good : values) {
                ordermanager.putProductToOrder(good);
            }
        }
    }
    @Override
    public ArrayList<products> getOrderedPositions() {
        if (ordermanager != null)
            return ordermanager.getOrder();
        return null;
    }
    @Override
    public void setOrderedPositions(ArrayList<products> orderedPositions) {
        if (ordermanager == null)
            ordermanager = new order_dataSource(new HashMap<Integer, products>());
        for (products good : orderedPositions) {
            ordermanager.putProductToOrder(good);
        }
    }
    @Override
    public void putProduct(products good) {
        if (ordermanager != null)
            ordermanager.putProductToOrder(good);
        else {
            ordermanager = new order_dataSource(new HashMap<Integer, products>());
            ordermanager.putProductToOrder(good);
        }
    }
    @Override
    public products getProduct(int position) {
        if (ordermanager != null)
            return ordermanager.getProductById(position);
        return null;
    }
}