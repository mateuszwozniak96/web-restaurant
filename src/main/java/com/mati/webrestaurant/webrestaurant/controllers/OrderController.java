package com.mati.webrestaurant.webrestaurant.controllers;

import com.mati.webrestaurant.webrestaurant.entities.OrderTable;
import com.mati.webrestaurant.webrestaurant.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/orders")
    public List<OrderTable> getOrders(){

        List<OrderTable> orderTables;

        orderTables = orderService.getAllOrders();

        return orderTables;
    }

    @GetMapping("/orders/{userId}")
    public List<OrderTable> getOrdersByUserId(@PathVariable int userId){
        return orderService.getOrdersByUserId(userId);
    }

    @PostMapping("/orders")
    public int addOrder(@RequestBody OrderTable order){

        return orderService.addOrder(order);
    }
    @GetMapping("/orders/{orderId}/sentmail")
    public void sentPlaceOrderMail(@PathVariable int orderId){
        orderService.sentPlaceOrderMail(orderId);
    }

    @DeleteMapping("/orders/{orderId}")
    public void deleteOrderById(@PathVariable int orderId){
        orderService.deleteOrderById(orderId);
    }
}
