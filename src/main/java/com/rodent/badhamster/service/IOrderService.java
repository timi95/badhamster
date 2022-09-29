package com.rodent.badhamster.service;

import com.rodent.badhamster.model.Orders;

import java.util.List;

public interface IOrderService {

    List<Orders> populateOrders();

     Orders getOrder(Long id);

    void applyDiscount(Double discount,  Orders order);

    void addOrder(Orders order);
}
