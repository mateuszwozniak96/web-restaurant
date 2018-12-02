package com.mati.webrestaurant.webrestaurant.controllers;

import com.mati.webrestaurant.webrestaurant.entities.*;
import com.mati.webrestaurant.webrestaurant.services.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Controller
public class CrudController {
    @Autowired
    private DishService dishService;

    @GetMapping("/list")
    private String getDishes(Model model){
        List<Dish> dishes;
        dishes = dishService.getAllDishes();

        model.addAttribute(dishes);

        return "dish-list";
    }

    @GetMapping("/showFormUpdate")
    public String showFormUpdate(@PathVariable("dishId") int dishId, Model model){
        Optional<Dish> dish;
        dish = dishService.getDish(dishId);

        model.addAttribute("dishId",dish);

        return "dish-form";
    }
    @GetMapping("/showFormAdd")
    public String showFormAdd(Model model){
        Dish dish = new Dish();
        model.addAttribute("dish",dish);
        return "dish-form";
    }
    public void delete(){

    }

}
