package com.mati.webrestaurant.webrestaurant.controllers;

import com.mati.webrestaurant.webrestaurant.entities.User;
import com.mati.webrestaurant.webrestaurant.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/users")
    public List<User> getUsers(){
        List<User> users;

        users = userService.getUsers();
        return users;
    }

    @GetMapping("/users/{id}")
    public Optional<User> getUser(@PathVariable int id){
        return userService.getUser(id);
    }

    @GetMapping("/logins")
    public List<String> getLogins(){
        return userService.getLogins();
    }
    @GetMapping("/emails")
    public List<String> getEmails(){
        return userService.getEmails();
    }
    @GetMapping(value = "/users", params = "login")
    private List<User> getUserByLogin(@RequestParam("login") String login){
        return  userService.getUserByLogin(login);
    }
    @GetMapping(value="/users", params = "email")
    private List<User> getUserByEmail(@RequestParam("email") String email){
        return  userService.getUserByEmail(email);
    }

    @PostMapping("/users")
    public void addUser(@RequestBody User user){

        userService.addUser(user);
    }
    @PutMapping("/users")
    public void updateUser(@RequestBody User user){

        userService.updateUser(user);
    }

    @DeleteMapping("users/{id}")
    public void deleteUser(@PathVariable int id){
        userService.deleteUser(id);
    }



}
