package com.mati.webrestaurant.webrestaurant.controllers;

import com.mati.webrestaurant.webrestaurant.entities.Dish;
import com.mati.webrestaurant.webrestaurant.services.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class DishController {
    @Autowired
    private DishService dishService;

    @GetMapping("/dishes")
    public List<Dish> getDishes(){
        List<Dish> dishes;
        dishes = dishService.getAllDishes();

        return dishes;

    }

    @GetMapping("/dishes/{dishTypeId}")
    public List<Dish> getDishesByDishType(@PathVariable int dishTypeId){
        List<Dish> dishes;

        dishes = dishService.getAllDishesByDishType(dishTypeId);
        return dishes;
    }
    @GetMapping("/dishes/{dishTypeId}/{dishId}")
    public Optional<Dish> getDish(@PathVariable int dishTypeId, @PathVariable int dishId){
        return dishService.getDish(dishId);
    }

    @GetMapping(value="/dishes", params = "string")
    public List<Dish> getDishesByString(@RequestParam("string") String string){
        return dishService.getAllDishesByString(string);
    }

    @PostMapping("/dishes")
    public void addDish(@RequestBody Dish dish){
        dishService.addDish(dish);
    }


    @DeleteMapping("dishes/{id}")
    public void deleteDish(@PathVariable int id){
        dishService.deleteDish(id);
    }
}
