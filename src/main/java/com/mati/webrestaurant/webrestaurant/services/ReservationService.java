package com.mati.webrestaurant.webrestaurant.services;


import com.mati.webrestaurant.webrestaurant.entities.Board;
import com.mati.webrestaurant.webrestaurant.entities.Reservation;
import com.mati.webrestaurant.webrestaurant.entities.User;
import com.mati.webrestaurant.webrestaurant.repositories.BoardRepository;
import com.mati.webrestaurant.webrestaurant.repositories.ReservationRepository;
import com.mati.webrestaurant.webrestaurant.repositories.UserRepository;
import com.mati.webrestaurant.webrestaurant.repositories.UserTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    @Autowired
    private JavaMailSender javaMailSender;

    public List<Reservation> getAllReservations() {
        List<Reservation> reservations = new ArrayList<>();

        reservationRepository.findAllByOrderByDateTimeDesc().forEach(reservations::add);

        return reservations;
    }

    public int addReservation(Reservation reservation) {

        User user = userRepository.getOne(reservation.getUser().getUserId());
        Reservation tempReservation = reservation;
        tempReservation.setUser(user);

        Board board = boardRepository.getOne(reservation.getBoard().getBoardId());
        tempReservation.setBoard(board);
        reservationRepository.save(tempReservation);
        sendAddReservationNotification(user,reservation);

        return tempReservation.getReservationId();
    }

    public void deleteReservationById(int reservationId) {
        Reservation reservation = getReservationById(reservationId);
        User user = reservation.getUser();

        reservationRepository.deleteById(reservationId);
        sendDeleteReservationNotification(user,reservation);
    }

  public Reservation getReservationById(int reservationId){
        return reservationRepository.getOne(reservationId);
  }

    private void sendDeleteReservationNotification(User user, Reservation reservation){
        StringBuilder emailText = new StringBuilder();
        emailText.append("Rezerwacja została anulowana: ")
                .append("Numer rezerwacji: ").append(reservation.getReservationId())
                .append("\nNumerStolika: ").append(reservation.getBoard().getBoardId())
                .append("\nTyp Stolika: ").append(reservation.getBoard().getBoardType())
                .append("\nData rezerwacji: ").append(reservation.getDateTime())
                .append("\nUzytkownik: ").append(user.getLogin());

        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(user.getEmail());
        mail.setFrom("ourwebrestaurant@gmail.com");
        mail.setSubject("Rezygnacja z rezerwacji");
        mail.setText(emailText.toString());
        javaMailSender.send(mail);
    }
    private void sendAddReservationNotification(User user, Reservation reservation){
        StringBuilder emailText = new StringBuilder();
        emailText.append("Rezerwacja stolika w Our Web Restaurant: ")
                .append("Numer rezerwacji: ").append(reservation.getReservationId())
                .append("\nNumerStolika: ").append(reservation.getBoard().getBoardId())
                .append("\nTyp Stolika: ").append(reservation.getBoard().getBoardType())
                .append("\nData rezerwacji: ").append(reservation.getDateTime())
                .append("\nUzytkownik: ").append(user.getLogin())
                .append("\n\nPozdrawia zespol Our Web Restaurant.");

        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(user.getEmail());
        mail.setFrom("ourwebrestaurant@gmail.com");
        mail.setSubject("Rezerwacja stolika w Our Web Restaurant");
        mail.setText(emailText.toString());
        javaMailSender.send(mail);
    }
}
