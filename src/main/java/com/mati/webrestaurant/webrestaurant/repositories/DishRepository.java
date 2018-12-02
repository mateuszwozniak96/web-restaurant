package com.mati.webrestaurant.webrestaurant.repositories;


import com.mati.webrestaurant.webrestaurant.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DishRepository extends JpaRepository<Dish,Integer> {
    public List<Dish> findAllByDishTypeDishTypeId(int dishTypeId);
}
