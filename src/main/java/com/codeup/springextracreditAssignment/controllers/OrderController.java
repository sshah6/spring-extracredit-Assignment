package com.codeup.springextracreditAssignment.controllers;

import com.codeup.springextracreditAssignment.models.Order;
import com.codeup.springextracreditAssignment.repositories.OrderRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class OrderController {

    private OrderRepository ordersDao;

    public OrderController(OrderRepository ordersDao) {
        this.ordersDao = ordersDao;
    }

    @GetMapping("/orders/create")
    public String getToCreatePage(){
        return "orders/create";
    }

    @PostMapping("/orders/create")
    public String createOrder(@RequestParam String email, @RequestParam Double totalPrice){
       Order order = new Order(email, totalPrice);
       ordersDao.save(order);
       return "redirect:/orders";
    }

    @GetMapping("/orders")
    public String getAllOrders(Model model){
        List<Order> orders = ordersDao.findAll();
        model.addAttribute("orders", orders);
        return "orders/index";
    }

}
