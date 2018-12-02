package com.mati.webrestaurant.webrestaurant.controllers;



import com.mati.webrestaurant.webrestaurant.services.*;
import com.mati.webrestaurant.webrestaurant.entities.*;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RestaurantController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserTypeService userTypeService;

    @Autowired
    private BoardService boardService;

    @Autowired
    private DishService dishService;
    @Autowired
    private DishTypeService dishTypeService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderDetailService orderDetailService;
    @Autowired
    private ReservationService reservationService;
    @Autowired
    private StatusService statusService;


    @GetMapping("/")
    public String getHome(){
        return "index";
    }
    @GetMapping("/usertypes")
    public List<UserType> getUserTypes(){
        List<UserType> userTypes;
        userTypes = userTypeService.getAllUserType();
        return  userTypes;
    }
    @GetMapping("/users")
    public List<User> getUsers(){
        List<User> users;

        users = userService.getUsers();
        return users;
    }

    @GetMapping("/boards")
    public List<Board> getBoards(){
        List<Board> boards;
        boards = boardService.getAllBoards();

        return boards;
    }

    @GetMapping("/dishes")
    public List<Dish>getDishes(){
        List<Dish> dishes;
        dishes = dishService.getAllDishes();


        return dishes;

    }


    @GetMapping("/dish-types")
    public List<DishType> getDishTypes(){
        List<DishType> dishTypes;

        dishTypes = dishTypeService.getAllDishTypes();

        return dishTypes;
    }
    @GetMapping("/orders")
    public List<OrderTable> getOrders(){

        List<OrderTable> orderTables;

        orderTables = orderService.getAllOrders();

        return orderTables;
    }
    @GetMapping("/order-details")
    public List<OrderDetail> getOrderDetails(){
        List<OrderDetail> orderDetails;

        orderDetails = orderDetailService.getAllOrderDetails();

        return orderDetails;
    }
    @GetMapping("/reservations")
    public List<Reservation> getReservations(){

        List<Reservation> reservations;

        reservations = reservationService.getAllReservations();

        return reservations;
    }
    @GetMapping("/statuses")
    public List<Status> getStatuses(){
        List<Status> statuses;

        statuses = statusService.getAllStatuses();

        return statuses;
    }
    @GetMapping("/dishes/{dishTypeId}")
    public List<Dish> getDishesByDishType(@PathVariable int dishTypeId){
        List<Dish> dishes;

        dishes = dishService.getAllDishesByDishType(dishTypeId);
        return dishes;
    }

    @PostMapping("/boards")
    public void addBoard(@RequestBody Board board){
        boardService.addBoard(board);
    }
    @PostMapping("/dishes")
    public void addDish(@RequestBody Dish dish){
        dishService.addDish(dish);
    }
    @PostMapping("/dish-types")
        public void addDishType(@RequestBody DishType dishType){
        dishTypeService.addDishType(dishType);
    }
    @PostMapping("/orders")
        public void addOrder(@RequestBody OrderTable order){
            orderService.addOrder(order);
        }
    @PostMapping("/order-details")
    public void addOrderDetails(@RequestBody OrderDetail orderDetail){
        orderDetailService.addOrderDetail(orderDetail);
    }
    @PostMapping("/reservations")
    public void addReservation(@RequestBody Reservation reservation){
        reservationService.addReservation(reservation);
    }
    @PostMapping("/statuses")
    public void addStatus(@RequestBody Status status){
        statusService.addStatus(status);
    }
    @PostMapping("/users")
    public void addUser(@RequestBody User user){

        userService.addUser(user);
    }
    @PostMapping("/usertypes")
    public void addUserType(@RequestBody UserType userType){
        userTypeService.addUserType(userType);
   }
   @DeleteMapping("dishes/{id}")
    public void deleteDish(@PathVariable int id){
        dishService.deleteDish(id);
   }

}
