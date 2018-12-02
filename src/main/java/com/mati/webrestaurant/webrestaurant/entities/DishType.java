package com.mati.webrestaurant.webrestaurant.entities;

import javax.persistence.*;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name="dish_type")
public class DishType {


    @OneToMany(mappedBy = "dishType", cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Dish> dishes;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="dish_type_id")
    private int dishTypeId;

    @Column(name="dish_type_name")
    private String dishTypeName;

    public DishType(){

    }

    public DishType(String dishTypeName) {
        this.dishTypeName = dishTypeName;
    }

    public int getDishTypeId() {
        return dishTypeId;
    }

    public void setDishTypeId(int dishTypeId) {
        this.dishTypeId = dishTypeId;
    }

    public String getDishTypeName() {
        return dishTypeName;
    }

    public void setDishTypeName(String dishTypeName) {
        this.dishTypeName = dishTypeName;
    }
}
