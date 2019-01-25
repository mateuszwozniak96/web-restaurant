package com.mati.webrestaurant.webrestaurant.controllers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Dictionary {
    private String login;
    private String register;
    private String reservation;
    private String about;
    private String changeTheme;
    private String changeLang;
    private String welcome;
    private String all;
    private String mainDishes;
    private String soup;
    private String drink;
    private String desserts;
    private String yourOrder;
    private String serachDish;
    private String dishName;
    private String dishType;
    private String price;
    private String details;
    private String description;
    private String ingredients;
    private String password;
    private String createAccount;
    private String reservTable;
    private String pickDate;
    private String tableNumber;
    private String tableType;
    private String reservationHour;
    private String confirmPassword;
    private String confirmEmail;
    private String firstName;
    private String lastName;
    private String alreadyRegister;
    private String inputAmount;
    private String addToOrder;
    private String admin;
    private String logout;
    private String orders;
    private String serach;
    private String order;
    private String orderNumber;
    private String orderDate;
    private String delete;
    private String amount;
    private String orderHistory;
    private String thanksOrder;
    private String continuee;
    private String summary;
    private String pickTable;
    private String reserv;
    private String pickHour;
    private String tableSize;
    private String table;
    private String confirm;
    private String changeStatus;
    private String orderDetails;
    private String hideTaken;
    private String hideDetails;
    private String dishes;
    private String users;


    public Dictionary(String lang){

        if(lang.equals("pol")){
            setPolish();
        }
        else if(lang.equals("eng")){
            setEnglish();
        }
    }


    private void setEnglish() {
        Properties properties;
        properties = new Properties();
        String InFile = "C:\\Users\\Mateusz\\IdeaProjects\\web-restaurant\\src\\main\\java\\com\\mati\\webrestaurant\\webrestaurant\\controllers\\englishLang.properties";
        InputStream inputVariables = null;
        try {
            inputVariables = new FileInputStream(InFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            properties.load(inputVariables);
        } catch (IOException e) {
            e.printStackTrace();
        }
        login = properties.getProperty("login");
        register= properties.getProperty("register");
        reservation= properties.getProperty("reservation");
        about= properties.getProperty("about");
        changeTheme= properties.getProperty("changeTheme");
        changeLang= properties.getProperty("changeLang");
        welcome= properties.getProperty("welcome");
        all = properties.getProperty("all");
        mainDishes= properties.getProperty("mainDishes");
        soup= properties.getProperty("soup");
        drink= properties.getProperty("drink");
        desserts= properties.getProperty("desserts");
         yourOrder= properties.getProperty("yourOrder");
         serachDish= properties.getProperty("serachDish");
         dishName= properties.getProperty("dishName");
         dishType= properties.getProperty("dishType");
         price= properties.getProperty("price");
         details= properties.getProperty("details");
         description= properties.getProperty("description");
         ingredients= properties.getProperty("ingredients");
         password= properties.getProperty("password");
         createAccount= properties.getProperty("createAccount");
         reservTable= properties.getProperty("reservTable");
         pickDate= properties.getProperty("pickDate");
         tableNumber= properties.getProperty("tableNumber");
         tableType= properties.getProperty("tableType");
         reservationHour= properties.getProperty("reservationHour");
         confirmPassword= properties.getProperty("confirmPassword");
         confirmEmail= properties.getProperty("confirmEmail");
         firstName= properties.getProperty("firstName");
         lastName= properties.getProperty("lastName");
         alreadyRegister= properties.getProperty("alreadyRegister");
         inputAmount= properties.getProperty("inputAmount");
         addToOrder= properties.getProperty("addToOrder");
         admin= properties.getProperty("admin");
         logout= properties.getProperty("logout");
         orders= properties.getProperty("orders");
         serach= properties.getProperty("serach");
         order= properties.getProperty("order");
         orderNumber= properties.getProperty("orderNumber");
         orderDate= properties.getProperty("orderDate");
         delete= properties.getProperty("delete");
         amount= properties.getProperty("amount");
         orderHistory= properties.getProperty("orderHistory");
         thanksOrder= properties.getProperty("thanksOrder");
         continuee= properties.getProperty("continue");
         summary= properties.getProperty("summary");
         pickTable= properties.getProperty("pickTable");
         reserv= properties.getProperty("reserv");
         pickHour= properties.getProperty("pickHour");
         tableSize= properties.getProperty("tableSize");
         table= properties.getProperty("table");
         confirm= properties.getProperty("confirm");
         changeStatus= properties.getProperty("changeStatus");
         orderDetails= properties.getProperty("orderDetails");
         hideTaken= properties.getProperty("hideTaken");
         hideDetails= properties.getProperty("hideDetails");
         dishes= properties.getProperty("dishes");
         users= properties.getProperty("users");


    }

    private void setPolish(){
            Properties properties;
            properties = new Properties();
            String InFile = "C:\\Users\\Mateusz\\IdeaProjects\\web-restaurant\\src\\main\\java\\com\\mati\\webrestaurant\\webrestaurant\\controllers\\polishLang.properties";
            InputStream inputVariables = null;
            try {
                inputVariables = new FileInputStream(InFile);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                properties.load(inputVariables);
            } catch (IOException e) {
                e.printStackTrace();
            }
        login = properties.getProperty("login");
        register= properties.getProperty("register");
        reservation= properties.getProperty("reservation");
        about= properties.getProperty("about");
        changeTheme= properties.getProperty("changeTheme");
        changeLang= properties.getProperty("changeLang");
        welcome= properties.getProperty("welcome");
        all = properties.getProperty("all");
        mainDishes= properties.getProperty("mainDishes");
        soup= properties.getProperty("soup");
        drink= properties.getProperty("drink");
        desserts= properties.getProperty("desserts");
        yourOrder= properties.getProperty("yourOrder");
        serachDish= properties.getProperty("serachDish");
        dishName= properties.getProperty("dishName");
        dishType= properties.getProperty("dishType");
        price= properties.getProperty("price");
        details= properties.getProperty("details");
        description= properties.getProperty("description");
        ingredients= properties.getProperty("ingredients");
        password= properties.getProperty("password");
        createAccount= properties.getProperty("createAccount");
        reservTable= properties.getProperty("reservTable");
        pickDate= properties.getProperty("pickDate");
        tableNumber= properties.getProperty("tableNumber");
        tableType= properties.getProperty("tableType");
        reservationHour= properties.getProperty("reservationHour");
        confirmPassword= properties.getProperty("confirmPassword");
        confirmEmail= properties.getProperty("confirmEmail");
        firstName= properties.getProperty("firstName");
        lastName= properties.getProperty("lastName");
        alreadyRegister= properties.getProperty("alreadyRegister");
        inputAmount= properties.getProperty("inputAmount");
        addToOrder= properties.getProperty("addToOrder");
        admin= properties.getProperty("admin");
        logout= properties.getProperty("logout");
        orders= properties.getProperty("orders");
        serach= properties.getProperty("serach");
        order= properties.getProperty("order");
        orderNumber= properties.getProperty("orderNumber");
        orderDate= properties.getProperty("orderDate");
        delete= properties.getProperty("delete");
        amount= properties.getProperty("amount");
        orderHistory= properties.getProperty("orderHistory");
        thanksOrder= properties.getProperty("thanksOrder");
        continuee= properties.getProperty("continue");
        summary= properties.getProperty("summary");
        pickTable= properties.getProperty("pickTable");
        reserv= properties.getProperty("reserv");
        pickHour= properties.getProperty("pickHour");
        tableSize= properties.getProperty("tableSize");
        table= properties.getProperty("table");
        confirm= properties.getProperty("confirm");
        changeStatus= properties.getProperty("changeStatus");
        orderDetails= properties.getProperty("orderDetails");
        hideTaken= properties.getProperty("hideTaken");
        hideDetails= properties.getProperty("hideDetails");
        dishes= properties.getProperty("dishes");
        users= properties.getProperty("users");
    }


    public String getLogin() {
        return login;
    }

    public String getRegister() {
        return register;
    }

    public String getReservation() {
        return reservation;
    }

    public String getAbout() {
        return about;
    }

    public String getChangeTheme() {
        return changeTheme;
    }

    public String getChangeLang() {
        return changeLang;
    }

    public String getWelcome() {
        return welcome;
    }

    public String getAll() {
        return all;
    }

    public String getMainDishes() {
        return mainDishes;
    }

    public String getSoup() {
        return soup;
    }

    public String getDrink() {
        return drink;
    }

    public String getDesserts() {
        return desserts;
    }

    public String getYourOrder() {
        return yourOrder;
    }

    public String getSerachDish() {
        return serachDish;
    }

    public String getDishName() {
        return dishName;
    }

    public String getDishType() {
        return dishType;
    }

    public String getPrice() {
        return price;
    }

    public String getDetails() {
        return details;
    }

    public String getDescription() {
        return description;
    }

    public String getIngredients() {
        return ingredients;
    }

    public String getPassword() {
        return password;
    }

    public String getCreateAccount() {
        return createAccount;
    }

    public String getReservTable() {
        return reservTable;
    }

    public String getPickDate() {
        return pickDate;
    }

    public String getTableNumber() {
        return tableNumber;
    }

    public String getTableType() {
        return tableType;
    }

    public String getReservationHour() {
        return reservationHour;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public String getConfirmEmail() {
        return confirmEmail;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAlreadyRegister() {
        return alreadyRegister;
    }

    public String getInputAmount() {
        return inputAmount;
    }

    public String getAddToOrder() {
        return addToOrder;
    }

    public String getAdmin() {
        return admin;
    }

    public String getLogout() {
        return logout;
    }

    public String getOrders() {
        return orders;
    }

    public String getSerach() {
        return serach;
    }

    public String getOrder() {
        return order;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public String getDelete() {
        return delete;
    }

    public String getAmount() {
        return amount;
    }

    public String getOrderHistory() {
        return orderHistory;
    }

    public String getThanksOrder() {
        return thanksOrder;
    }

    public String getContinuee() {
        return continuee;
    }

    public String getSummary() {
        return summary;
    }

    public String getPickTable() {
        return pickTable;
    }

    public String getReserv() {
        return reserv;
    }

    public String getPickHour() {
        return pickHour;
    }

    public String getTableSize() {
        return tableSize;
    }

    public String getTable() {
        return table;
    }

    public String getConfirm() {
        return confirm;
    }

    public String getChangeStatus() {
        return changeStatus;
    }

    public String getOrderDetails() {
        return orderDetails;
    }

    public String getHideTaken() {
        return hideTaken;
    }

    public String getHideDetails() {
        return hideDetails;
    }

    public String getDishes() {
        return dishes;
    }

    public String getUsers() {
        return users;
    }
}
