package com.mati.webrestaurant.webrestaurant.services;

import com.mati.webrestaurant.webrestaurant.entities.OrderTable;
import com.mati.webrestaurant.webrestaurant.entities.Status;
import com.mati.webrestaurant.webrestaurant.entities.User;
import com.mati.webrestaurant.webrestaurant.repositories.OrderRepository;
import com.mati.webrestaurant.webrestaurant.repositories.StatusRepository;
import com.mati.webrestaurant.webrestaurant.repositories.UserRepository;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private StatusRepository statusRepository;
    public List<OrderTable> getAllOrders() {
        List<OrderTable> orderTables = new ArrayList<>();

        orderRepository.findAll().forEach(orderTables::add);

        return orderTables;
    }

    public void addOrder(OrderTable order) {
        User user = userRepository.getOne(order.getUser().getUserId());
        OrderTable tempOrder = order;
        tempOrder.setUser(user);

        Status status = statusRepository.getOne(order.getStatus().getStatusId());
        order.setStatus(status);

        orderRepository.save(tempOrder);
    }
}
