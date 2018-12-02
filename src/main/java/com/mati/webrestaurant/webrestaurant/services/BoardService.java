package com.mati.webrestaurant.webrestaurant.services;



import com.mati.webrestaurant.webrestaurant.entities.*;
import com.mati.webrestaurant.webrestaurant.repositories.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoardService {

    @Autowired
    public BoardRepository boardRepository;

    public List<Board> getAllBoards() {
        List<Board> boards = new ArrayList<>();

        boardRepository.findAll().forEach(boards::add);

        return boards;
    }
    public void addBoard(Board board){
        boardRepository.save(board);
    }
}
