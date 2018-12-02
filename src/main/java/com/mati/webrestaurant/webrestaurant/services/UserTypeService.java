package com.mati.webrestaurant.webrestaurant.services;


import com.mati.webrestaurant.webrestaurant.entities.UserType;
import com.mati.webrestaurant.webrestaurant.repositories.UserTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserTypeService {
    @Autowired
    public UserTypeRepository userTypeRepository;

    public void addUserType(UserType userType){
        userTypeRepository.save(userType);
    }

    public Optional<UserType> getUserType(int id){
        return userTypeRepository.findById(id);
    }
    public List<UserType> getAllUserType(){
        List<UserType> userTypes = new ArrayList<>();
        userTypeRepository.findAll().forEach(userTypes::add);

        return userTypes;
    }

}
