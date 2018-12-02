package com.mati.webrestaurant.webrestaurant.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="user_type")
public class UserType {

    @OneToMany(mappedBy = "userType", cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH})
    private List<User> users;

    @Id
    @Column(name = "user_type_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userTypeId;

    @Column(name = "user_type_name")
    private String userTypeName;

    public UserType(){

    }

    public void add(User user){
        if(users == null){
            users = new ArrayList<>();
        }

        users.add(user);
        user.setUserType(this);
    }



    public int getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(int userTypeId) {
        this.userTypeId = userTypeId;
    }

    public String getUserTypeName() {
        return userTypeName;
    }

    public void setUserTypeName(String userTypeName) {
        this.userTypeName = userTypeName;
    }
}
