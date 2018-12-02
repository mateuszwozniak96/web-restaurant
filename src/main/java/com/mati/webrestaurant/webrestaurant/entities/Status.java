package com.mati.webrestaurant.webrestaurant.entities;


import javax.persistence.*;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="status")
public class Status {


    @OneToMany(mappedBy = "status", cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH})
    private List<OrderTable> orderTables;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="status_id")
    private Integer statusId;

    @Column(name="status_name")
    private String statusName;

    public void add(OrderTable orderTable){
        if(orderTable ==null){
            orderTables = new ArrayList<>();
        }
        orderTables.add(orderTable);
    }
    public Status(){

    }

    public Status(String statusName) {
        this.statusName = statusName;
    }


    public void setOrderTables(List<OrderTable> orderTables) {
        this.orderTables = orderTables;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }
}
