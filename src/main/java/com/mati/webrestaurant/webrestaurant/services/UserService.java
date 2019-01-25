package com.mati.webrestaurant.webrestaurant.services;


import com.mati.webrestaurant.webrestaurant.entities.OrderDetail;
import com.mati.webrestaurant.webrestaurant.entities.User;
import com.mati.webrestaurant.webrestaurant.entities.UserType;
import com.mati.webrestaurant.webrestaurant.repositories.UserRepository;
import com.mati.webrestaurant.webrestaurant.repositories.UserTypeRepository;
import org.apache.commons.codec.digest.DigestUtils;
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
        tempUser.setPassword(DigestUtils.sha256Hex(tempUser.getPassword()));
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

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    public List<String> getLogins() {

        List<User> users = userRepository.findAll();
        List<String> logins = new ArrayList<>();
        for(User u: users){
            logins.add(u.getLogin());
        }

        return logins;
    }

    public List<String> getEmails() {
        List<User> users = userRepository.findAll();
        List<String> emails = new ArrayList<>();

        for(User u: users){
            emails.add(u.getEmail());
        }

        return emails;
    }

    public List<User> getUserByLogin(String login) {
       return userRepository.findAllByLogin(login);
    }

    public List<User> getUserByEmail(String email) {
        return userRepository.findAllByEmail(email);
    }


}
