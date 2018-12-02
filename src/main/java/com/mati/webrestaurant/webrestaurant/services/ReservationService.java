package com.mati.webrestaurant.webrestaurant.services;


import com.mati.webrestaurant.webrestaurant.entities.Board;
import com.mati.webrestaurant.webrestaurant.entities.Reservation;
import com.mati.webrestaurant.webrestaurant.entities.User;
import com.mati.webrestaurant.webrestaurant.entities.UserType;
import com.mati.webrestaurant.webrestaurant.repositories.BoardRepository;
import com.mati.webrestaurant.webrestaurant.repositories.ReservationRepository;
import com.mati.webrestaurant.webrestaurant.repositories.UserRepository;
import com.mati.webrestaurant.webrestaurant.repositories.UserTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private UserTypeRepository userTypeRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BoardRepository boardRepository;

    public List<Reservation> getAllReservations() {
        List<Reservation> reservations = new ArrayList<>();

        reservationRepository.findAll().forEach(reservations::add);

        return reservations;
    }

    public void addReservation(Reservation reservation) {

        User user = userRepository.getOne(reservation.getUser().getUserId());
        Reservation tempReservation = reservation;
        tempReservation.setUser(user);

        Board board = boardRepository.getOne(reservation.getBoard().getBoardId());
        tempReservation.setBoard(board);
        reservationRepository.save(tempReservation);
    }
}
