package com.mati.webrestaurant.webrestaurant.controllers;

import com.google.gson.Gson;
import com.mati.webrestaurant.webrestaurant.entities.Board;
import com.mati.webrestaurant.webrestaurant.services.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class BoardController {
    @Autowired
    private BoardService boardService;

    @GetMapping("/boards")
    public List<Board> getBoards(){
        List<Board> boards;
        boards = boardService.getAllBoards();

        return boards;
    }

    @PostMapping("/boards")
    public void addBoard(@RequestBody Board board){
        boardService.addBoard(board);
    }
    @DeleteMapping("/boards/{boardId}")
    public void deleteBoardById(@PathVariable int boardId){
        boardService.deleteBoardById(boardId);
    }

}
