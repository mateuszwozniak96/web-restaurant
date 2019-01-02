package com.mati.webrestaurant.webrestaurant.controllers;


import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class RestaurantController {

    @GetMapping("/")
    public String getHome(){
        return "index";
    }


}
