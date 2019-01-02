package com.mati.webrestaurant.webrestaurant.controllers;

import com.mati.webrestaurant.webrestaurant.entities.OrderDetail;
import com.mati.webrestaurant.webrestaurant.services.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class OrderDetailController {
    @Autowired
    private OrderDetailService orderDetailService;

    @GetMapping("/order-details")
    public List<OrderDetail> getOrderDetails(){
        List<OrderDetail> orderDetails;

        orderDetails = orderDetailService.getAllOrderDetails();

        return orderDetails;
    }

    @GetMapping("/order-details/{orderId}")
    public List<OrderDetail> getDetailsByOrder(@PathVariable int orderId){
        return orderDetailService.getDetailsByOrderId(orderId);
    }

    @PostMapping("/order-details")
    public void addOrderDetails(@RequestBody OrderDetail orderDetail){
        orderDetailService.addOrderDetail(orderDetail);

    }
    @DeleteMapping("order-details/{orderDetailId}")
    public void deleteOrderDetailById(@PathVariable int orderDetailId){
        orderDetailService.deleteOrderDetailById(orderDetailId);
    }

}
