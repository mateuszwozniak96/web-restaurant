package com.mati.webrestaurant.webrestaurant.repositories;


import com.mati.webrestaurant.webrestaurant.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderTable,Integer> {

    OrderTable getByOrderId(int orderId);
    List<OrderTable> findAllByOrderByDateTimeDesc();
    List<OrderTable> findAllByUserUserId(int userId);
}
