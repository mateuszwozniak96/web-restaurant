package com.mati.webrestaurant.webrestaurant;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

@SpringBootApplication
public class WebRestaurantApplication{

    public static void main(String[] args){

        String url = "jdbc:mysql://localhost:3306/restaurant?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String pass = "admin";
        String login ="root";
        try {
            Connection con = DriverManager.getConnection(url, login, pass);
            Statement statemet = con.createStatement();
            ResultSet resultSet = statemet.executeQuery("select dish_name from dish");
            StringBuilder result = new StringBuilder();
            JTextArea textArea = new JTextArea();
            textArea.setPreferredSize(new Dimension(400,400));
            while(resultSet.next()){
                result.append(resultSet.getString("dish_name")).append("\n");
            }

            JFrame frame = new JFrame("frame");
            frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            frame.setLayout(new FlowLayout());
            frame.add(textArea);
            frame.setSize(new Dimension(400,400));
            JButton button = new JButton("GetDishes");
            button.setPreferredSize(new Dimension(50,20));
            button.setMaximumSize(new Dimension(50,20));
            frame.add(button);
            frame.pack();
            frame.setVisible(true);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println(result.toString());
                    textArea.setText(result.toString());
                }
            });

        }catch (Exception e){
            System.out.println("Nie udalo sie polaczyc z baz");
            e.printStackTrace();
        }

        SpringApplication.run(WebRestaurantApplication.class, args);



    }
}
