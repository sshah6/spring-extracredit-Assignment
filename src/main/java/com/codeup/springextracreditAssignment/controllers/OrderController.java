package com.codeup.springextracreditAssignment.controllers;

import com.codeup.springextracreditAssignment.models.Order;
import com.codeup.springextracreditAssignment.repositories.OrderRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class OrderController {

    private OrderRepository ordersDao;

    public OrderController(OrderRepository ordersDao) {
        this.ordersDao = ordersDao;
    }

    //When /orders/create entered, navigate to create page
    @GetMapping("/orders/create")
    public String getToCreatePage(){
        return "orders/create";
    }

    //Create orders. push to database and redirect to index page
    @PostMapping("/orders/create")
    public String createOrder(@RequestParam String email, @RequestParam Double totalPrice){
       Order order = new Order(email, totalPrice);
       ordersDao.save(order);
       return "redirect:/orders";
    }

    //Find all the orders and show them in index page
    @GetMapping("/orders")
    public String getAllOrders(Model model){
        List<Order> orders = ordersDao.findAll();
        model.addAttribute("orders", orders);
        return "orders/index";
    }

    //Find order by Id
    @GetMapping("/orders/{id}")
    public String findById(@PathVariable long id, Model model){
        System.out.println(id);
        Order order = ordersDao.findById(id).get();
        model.addAttribute("order", order);
        return "orders/show";
    }

    //Delete order by id
    @GetMapping("/orders/{id}/delete")
    public String deleteOrder(@PathVariable long id){
        ordersDao.deleteById(id);
        return "redirect:/orders";
    }

    //Finding the order by id to update
    @GetMapping("/orders/{id}/update")
    public String updateOrder(@PathVariable long id, Model model){
        Order order = ordersDao.findById(id).get();
        model.addAttribute("order", order);
        return "orders/update";
    }

    @PostMapping("/orders/{id}/update")
    public String updatedOrder(@PathVariable long id, @RequestParam String email, @RequestParam double totalPrice, Model model){
       Order order = new Order(id, email, totalPrice);
       ordersDao.save(order);
       Order orderById = ordersDao.findById(id).get();

       model.addAttribute("orderById", orderById);
       return "orders/updated";
    }

}
