package com.rodent.badhamster;

import com.rodent.badhamster.model.Orders;
import com.rodent.badhamster.service.IOrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class TestOrderService {

    @Autowired
    IOrderService orderService;
    @BeforeEach
    void setup(){
        Orders order1 = new Orders().builder()
                .id(1l)
                .name("order 1")
                .description("lorem")
                .price(10.0)
                .build();

        Orders order2 = new Orders().builder()
                .id(2l)
                .name("order 2")
                .description("lorem")
                .price(20.0)
                .build();

        Orders order3 = new Orders().builder()
                .id(3l)
                .name("order 3")
                .description("lorem")
                .price(30.0)
                .build();


        orderService.addOrder(order1);
        orderService.addOrder(order2);
        orderService.addOrder(order3);
    }

    @Test
    void ordersAreSeeded(){
        assertTrue(orderService.populateOrders().size() > 0);
    }

    @Test
    void discountApplied(){
        var check = orderService.getOrder(1l);
        var previousPrice = check.getPrice();
        orderService.applyDiscount(0.5, check);

        assertTrue(check.getPrice() < previousPrice);
    }

    @Test
    void discountValueLimit(){
        var check = orderService.getOrder(1l);
        var previousPrice = check.getPrice();
        orderService.applyDiscount(5.0, check);

        assertEquals(previousPrice,check.getPrice());
    }
}
