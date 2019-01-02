package com.mati.webrestaurant.webrestaurant.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="order_table")
public class OrderTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="order_id")
    private int orderId;

    @Column(name="value")
    private float value;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name="status_id")
    private Status status;

    @OneToMany(mappedBy = "orderTable", cascade = {CascadeType.ALL})
    private List<OrderDetail> orderDetails;


    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="date_time")
    private Date dateTime;


    public OrderTable(){

    }


    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public OrderTable(float value, Date dateTime) {
        this.value = value;
        this.dateTime = dateTime;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public void add(OrderDetail orderDetail){
        if(orderDetails ==null){
            orderDetails = new ArrayList<>();
        }
        orderDetails.add(orderDetail);
    }
}
