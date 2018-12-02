package com.mati.webrestaurant.webrestaurant.repositories;


import com.mati.webrestaurant.webrestaurant.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderTable,Integer> {
}
