package com.mati.webrestaurant.webrestaurant.services;

import com.mati.webrestaurant.webrestaurant.entities.OrderDetail;
import com.mati.webrestaurant.webrestaurant.entities.OrderTable;
import com.mati.webrestaurant.webrestaurant.entities.Status;
import com.mati.webrestaurant.webrestaurant.entities.User;
import com.mati.webrestaurant.webrestaurant.repositories.OrderDetailRepository;
import com.mati.webrestaurant.webrestaurant.repositories.OrderRepository;
import com.mati.webrestaurant.webrestaurant.repositories.StatusRepository;
import com.mati.webrestaurant.webrestaurant.repositories.UserRepository;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private StatusRepository statusRepository;
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private JavaMailSender javaMailSender;

    public List<OrderTable> getAllOrders() {
        List<OrderTable> orderTables = new ArrayList<>();

        orderRepository.findAllByOrderByDateTimeDesc().forEach(orderTables::add);

        return orderTables;
    }

    public int addOrder(OrderTable order) {
        User user = userRepository.getOne(order.getUser().getUserId());
        OrderTable tempOrder = order;
        tempOrder.setUser(user);

        Status status = statusRepository.getOne(order.getStatus().getStatusId());
        order.setStatus(status);

        orderRepository.save(tempOrder);




        return tempOrder.getOrderId();
    }

    public OrderTable getOrderById(int i) {
        return orderRepository.getByOrderId(i);
    }

    public void deleteOrderById(int orderId) {

        OrderTable order = getOrderById(orderId);
        User user = order.getUser();
        sendDeleteOrderNotification(user,order);
        orderRepository.deleteById(orderId);


    }

    public List<OrderTable> getOrdersByUserId(int userId) {
        return orderRepository.findAllByUserUserId(userId);
    }

    private  void sendAddOrderNotification(User user, OrderTable order){
        StringBuilder emailText = new StringBuilder();
        emailText.append("Dziękujemy za złożenie zamówienia nr: ")
                 .append(buildOrder(order));

        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(user.getEmail());
        mail.setFrom("ourwebrestaurant@gmail.com");
        mail.setSubject("Złożenie zamówienia w serwisie Our Web Restaurant");
        mail.setText(emailText.toString());
        javaMailSender.send(mail);
    }

    private void sendDeleteOrderNotification(User user, OrderTable order){



        StringBuilder emailText = new StringBuilder();
        emailText.append("Zamówienie zostało anulowane: ")
                .append(buildOrder(order));

        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(user.getEmail());
        mail.setFrom("ourwebrestaurant@gmail.com");
        mail.setSubject("Rezygnacja z zamówienia ");
        mail.setText(emailText.toString());
        javaMailSender.send(mail);
    }
    private String buildOrder(OrderTable order){
        List<OrderDetail> orderDetails = new LinkedList<>();
        orderDetailRepository.findAllByOrderTableOrderId(order.getOrderId()).forEach(orderDetails::add);

        StringBuilder orderDetail = new StringBuilder("Zamowienie nr: ").append(order.getOrderId());

        for(OrderDetail detail: orderDetails){
            orderDetail.append("\nDanie: ").append(detail.getDish().getDishName())
                    .append("   Ilosc: ").append(detail.getDishAmount());
        }
        orderDetail.append("\nŁacznie: ").append(order.getValue());


        return orderDetail.toString();

    }

    public void sentPlaceOrderMail(int orderId) {
        OrderTable orderTable = orderRepository.getOne(orderId);
        User user = orderTable.getUser();

        sendAddOrderNotification(user,orderTable);
    }
}
