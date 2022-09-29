package com.rodent.badhamster.controller;

import com.rodent.badhamster.model.Orders;
import com.rodent.badhamster.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.PostConstruct;

@Controller
public class WebController {
    @Autowired
    IOrderService orderService;
    @Autowired
    WebController(){}

    @GetMapping("/")
    public String myView(Model model){
        model.addAttribute("allOrders", orderService.populateOrders());
        return "index";
    }

    @GetMapping("/applyDiscount")
    public String applyDiscount(@RequestParam String code, @ModelAttribute  Orders order){
        if (code == "FATCAT"){
            orderService.applyDiscount(0.5, order);
        }
        return "index";
    }

    @PostConstruct
    public void seed(){
         Orders order1 = new  Orders().builder()
                .id(1l)
                .name("order 1")
                .description("lorem")
                .price(10.0)
                .build();

         Orders order2 = new  Orders().builder()
                .id(2l)
                .name("order 2")
                .description("lorem")
                .price(20.0)
                .build();

         Orders order3 = new  Orders().builder()
                .id(3l)
                .name("order 3")
                .description("lorem")
                .price(30.0)
                .build();


        orderService.addOrder(order1);
        orderService.addOrder(order2);
        orderService.addOrder(order3);
    }

}