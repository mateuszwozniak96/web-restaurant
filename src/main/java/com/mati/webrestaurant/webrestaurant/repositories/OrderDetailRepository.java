package com.mati.webrestaurant.webrestaurant.repositories;


import com.mati.webrestaurant.webrestaurant.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface OrderDetailRepository extends JpaRepository<OrderDetail,Integer> {
    List<OrderDetail> findAllByOrderTableOrderId(int orderId);
}
