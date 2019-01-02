package com.mati.webrestaurant.webrestaurant.controllers;

import com.mati.webrestaurant.webrestaurant.entities.Reservation;
import com.mati.webrestaurant.webrestaurant.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ReservationController {
    @Autowired
    private ReservationService reservationService; @GetMapping("/reservations")

    public List<Reservation> getReservations(){

        List<Reservation> reservations;

        reservations = reservationService.getAllReservations();

        return reservations;
    }

    @PostMapping("/reservations")
    public int  addReservation(@RequestBody Reservation reservation){
        return reservationService.addReservation(reservation);
    }

    @DeleteMapping("/reservations/{reservationId}")
    public void deleteReservationById(@PathVariable int reservationId){
        reservationService.deleteReservationById(reservationId);
    }
}
