package com.mati.webrestaurant.webrestaurant.services;

import com.mati.webrestaurant.webrestaurant.entities.DishType;
import com.mati.webrestaurant.webrestaurant.repositories.DishTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DishTypeService {

    @Autowired
    private DishTypeRepository dishTypeRepository;

    public List<DishType> getAllDishTypes() {
        List<DishType> dishTypes = new ArrayList<>();

      dishTypeRepository.findAll().forEach(dishTypes::add);

        return dishTypes;
    }

    public void addDishType(DishType dishType) {
        dishTypeRepository.save(dishType);
    }

}
