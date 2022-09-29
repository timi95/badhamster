package com.rodent.badhamster.service;

import com.rodent.badhamster.model.Orders;
import com.rodent.badhamster.repository.OrdersRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Data
@AllArgsConstructor
@Service
@Slf4j
public class OrderService implements IOrderService {

    @Autowired
    OrdersRepository ordersRepository;

    @Override
    public List< Orders> populateOrders() {
        return ordersRepository.findAll();
    }

    @Override
    public  Orders getOrder(Long id) {
        return ordersRepository.findById(id).get();
    }

    @Override
    public void applyDiscount(Double discount,  Orders order) {
        if (discount > 1) return;
        var currentPrice = order.getPrice();
        order.setPrice(currentPrice * discount);
        ordersRepository.save(order);
    }

    @Override
    public void addOrder(Orders order) {
        ordersRepository.save(order);
    }
}
