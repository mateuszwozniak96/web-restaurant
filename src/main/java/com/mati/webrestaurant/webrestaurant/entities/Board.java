package com.mati.webrestaurant.webrestaurant.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="board")
public class Board {


    @OneToMany(mappedBy = "board",cascade = {CascadeType.ALL})
    private List<Reservation> reservations;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="board_id")
    private int boardId;

    @Column(name="board_type")
    private String boardType;

    public Board() {

    }

    public Board(String boardType) {
        this.boardType = boardType;
    }

    public void add(Reservation reservation){
        if(reservation == null){
            reservations = new ArrayList<>();
        }

        reservations.add(reservation);
    }

    public int getBoardId() {
        return boardId;
    }

    public void setBoardId(int boardId) {
        this.boardId = boardId;
    }

    public String getBoardType() {
        return boardType;
    }

    public void setBoardType(String boardType) {
        this.boardType = boardType;
    }
}
