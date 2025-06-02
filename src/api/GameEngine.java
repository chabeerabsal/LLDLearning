package api;

import Game.*;
import boards.TicTacToeBoard;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class GameEngine {
    public Board start(String type){
        if(type.equals("Tic-Tac-Toe"))
        {
            return new TicTacToeBoard();
        }
        else{
        throw new IllegalArgumentException();
    }}
    public void move(Board board, Player player, Move move){
        if(board instanceof TicTacToeBoard){
            board.move(move);


        }

    }



}

