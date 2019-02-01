package com.mati.webrestaurant.webrestaurant.entities;



import javax.persistence.*;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="dish")
public class Dish {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="dish_id")
    private int dishId;

    @Column(name="dish_name")
    private String dishName;
    @Column(name="dish_price")
    private float dishPrice;
    @Column(name="ingredients")
    private String ingredients;
    @Column(name="description")
    private String description;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name="dish_type_id")
    private DishType dishType;


    @OneToMany(mappedBy = "dish", cascade = {CascadeType.ALL})
    private List<OrderDetail> orderDetails;

    @Column(name="dish_image")
    private String dishImage;


    public Dish() {

    }

    public Dish(String dishName, float dishPrice, String ingredients, String description) {
        this.dishName = dishName;
        this.dishPrice = dishPrice;
        this.ingredients = ingredients;
        this.description = description;
    }

    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public float getDishPrice() {
        return dishPrice;
    }

    public void setDishPrice(float dishPrice) {
        this.dishPrice = dishPrice;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DishType getDishType() {
        return dishType;
    }

    public void setDishType(DishType dishType) {
        this.dishType = dishType;
    }

    public String getDishImage() {
        return dishImage;
    }

    public void setDishImage(String dishImage) {
        this.dishImage = dishImage;
    }
}
