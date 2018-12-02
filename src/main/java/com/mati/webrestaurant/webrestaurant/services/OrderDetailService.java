package com.mati.webrestaurant.webrestaurant.services;


import com.mati.webrestaurant.webrestaurant.entities.Dish;
import com.mati.webrestaurant.webrestaurant.entities.OrderDetail;
import com.mati.webrestaurant.webrestaurant.entities.OrderTable;
import com.mati.webrestaurant.webrestaurant.repositories.DishRepository;
import com.mati.webrestaurant.webrestaurant.repositories.OrderDetailRepository;
import com.mati.webrestaurant.webrestaurant.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderDetailService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private DishRepository dishRepository;

    public List<OrderDetail> getAllOrderDetails() {
        List<OrderDetail> orderDetails = new ArrayList<>();

        orderDetailRepository.findAll().forEach(orderDetails::add);

        return orderDetails;
    }

    public void addOrderDetail(OrderDetail orderDetail) {
        OrderTable order = orderRepository.getOne(orderDetail.getOrderTable().getOrderId());
        OrderDetail tempOrderDetail = orderDetail;

        Dish dish = dishRepository.getOne(orderDetail.getDish().getDishId());
        orderDetail.setDish(dish);

        tempOrderDetail.setOrderTable(order);
    }
}
