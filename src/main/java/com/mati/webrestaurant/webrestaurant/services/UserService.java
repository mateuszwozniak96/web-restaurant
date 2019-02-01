package com.mati.webrestaurant.webrestaurant.services;


import com.mati.webrestaurant.webrestaurant.entities.OrderDetail;
import com.mati.webrestaurant.webrestaurant.entities.User;
import com.mati.webrestaurant.webrestaurant.entities.UserType;
import com.mati.webrestaurant.webrestaurant.repositories.UserRepository;
import com.mati.webrestaurant.webrestaurant.repositories.UserTypeRepository;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
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

    @Autowired
    private JavaMailSender javaMailSender;




    public void addUser(User user){
        UserType userType = userTypeRepository.getOne(user.getUserType().getUserTypeId());
        User tempUser = user;
        tempUser.setUserType(userType);
        tempUser.setPassword(DigestUtils.sha256Hex(tempUser.getPassword()));
        userRepository.save(tempUser);
        sendNotification(user);
    }

    public void updateUser(User user){
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

    private  void sendNotification(User user){
        StringBuilder emailText = new StringBuilder();
        emailText.append("Dziękujemy za rejestrację w naszej aplikacji ")
                 .append(user.getLogin())
                 .append(".\nOd teraz możesz składać zamówienia oraz rezerwację.\n")
                .append("Zyczmy przyjemnego użytkowania.\n")
                 .append("Pozdrawia zespół Our Web Restaurant");

        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(user.getEmail());
        mail.setFrom("ourwebrestaurant@gmail.com");
        mail.setSubject("Rejestracja w serwisie Our Web Restaurant");
        mail.setText(emailText.toString());
        javaMailSender.send(mail);
    }
}
