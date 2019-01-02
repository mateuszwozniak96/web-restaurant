package com.mati.webrestaurant.webrestaurant.controllers;

import com.mati.webrestaurant.webrestaurant.entities.UserType;
import com.mati.webrestaurant.webrestaurant.services.UserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class UserTypeController {
    @Autowired
    private UserTypeService userTypeService;
    @GetMapping("/usertypes")
    public List<UserType> getUserTypes(){
        List<UserType> userTypes;
        userTypes = userTypeService.getAllUserType();
        return  userTypes;
    }

    @PostMapping("/usertypes")
    public void addUserType(@RequestBody UserType userType){
        userTypeService.addUserType(userType);
    }

    @DeleteMapping("/usertypes/{userTypeID}")
    public void deleteUserTypeById(@PathVariable int userTypeId){
        userTypeService.deleteUserTypeById(userTypeId);
    }
}
