package com.mati.webrestaurant.webrestaurant.services;


import com.mati.webrestaurant.webrestaurant.entities.Dish;
import com.mati.webrestaurant.webrestaurant.entities.DishType;
import com.mati.webrestaurant.webrestaurant.repositories.DishRepository;
import com.mati.webrestaurant.webrestaurant.repositories.DishTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DishService {

    @Autowired
    private DishRepository dishRepository;
    @Autowired
    DishTypeRepository dishTypeRepository;

    public List<Dish> getAllDishes() {
        List<Dish> dishes = new ArrayList<>();

         dishRepository.findAll().forEach(dishes::add);

        return dishes;
    }
    public List<Dish> getAllDishesByDishType(int dishTypeId){
        List<Dish> dishes = new ArrayList<>();

        dishRepository.findAllByDishTypeDishTypeId(dishTypeId).forEach(dishes::add);

        return dishes;
    }
    public List<Dish> getAllDishesByString(String string){
        List<Dish> dishes = new ArrayList<>();
        dishRepository.findAllByDishNameContains(string).forEach(dishes::add);

        return dishes;

    }

    public void addDish(Dish dish) {
        DishType dishType = dishTypeRepository.getOne(dish.getDishType().getDishTypeId());
        Dish tempDish = dish;
        tempDish.setDishType(dishType);

        dishRepository.save(tempDish);
    }

    public Optional<Dish> getDish(int dishId){
        Optional<Dish> dish = dishRepository.findById(dishId);

        return dish;
    }

    public void deleteDish(int id) {
        dishRepository.deleteById(id);
    }
}
