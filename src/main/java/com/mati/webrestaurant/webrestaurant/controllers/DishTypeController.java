package com.mati.webrestaurant.webrestaurant.controllers;

import com.mati.webrestaurant.webrestaurant.entities.DishType;
import com.mati.webrestaurant.webrestaurant.services.DishTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class DishTypeController {
    @Autowired
    private DishTypeService dishTypeService;

    @GetMapping("/dish-types")
    public List<DishType> getDishTypes(){
        List<DishType> dishTypes;

        dishTypes = dishTypeService.getAllDishTypes();

        return dishTypes;
    }

    @PostMapping("/dish-types")
    public void addDishType(@RequestBody DishType dishType){
        dishTypeService.addDishType(dishType);
    }

    @DeleteMapping("dish-types/{dishTypeId}")
    public void deleteDishTypeById(@PathVariable int dishTypeId){
        dishTypeService.deleteDishTypeById(dishTypeId);
    }
}
