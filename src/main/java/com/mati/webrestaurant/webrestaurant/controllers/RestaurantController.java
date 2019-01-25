package com.mati.webrestaurant.webrestaurant.controllers;


import org.springframework.web.bind.annotation.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@RestController
@CrossOrigin(origins = "*")
public class RestaurantController {

    @GetMapping("/")
    public String getHome(){
        return "index";
    }

    @GetMapping("/eng")
    public Dictionary getEnglishDictionary(){


        return new Dictionary("eng");
    }

    @GetMapping("/pol")
    public Dictionary getPolishDictionary(){
        Dictionary dictionary = new Dictionary("pol");

      return dictionary;
    }

}
