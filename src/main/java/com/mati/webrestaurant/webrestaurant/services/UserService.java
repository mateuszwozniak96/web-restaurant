package com.mati.webrestaurant.webrestaurant.services;


import com.mati.webrestaurant.webrestaurant.entities.User;
import com.mati.webrestaurant.webrestaurant.entities.UserType;
import com.mati.webrestaurant.webrestaurant.repositories.UserRepository;
import com.mati.webrestaurant.webrestaurant.repositories.UserTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    public UserRepository userRepository;
    @Autowired
    public UserTypeRepository userTypeRepository;

    public void addUser(User user){
        UserType userType = userTypeRepository.getOne(user.getUserType().getUserTypeId());
        User tempUser = user;
        tempUser.setUserType(userType);
        userRepository.save(tempUser);
    }

    public Optional<User> getUser(int id){
        return userRepository.findById(id);
    }
    public List<User> getUsers(){
        List<User> users = new ArrayList<>();
        
        userRepository.findAll().forEach(users::add);
    
        return users;
    }
}
