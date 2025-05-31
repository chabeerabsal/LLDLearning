import Game.Board;
import Game.Cells;
import Game.Move;
import Game.Player;
import api.GameEngine;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GameEngine game = new GameEngine();
        Board board=game.start("Tic-Tac-Toe");
        while(!game.isComplete(board).isOver()) {
            Player opponent=new Player("O");
            Player computer=new Player("X");
            System.out.println("Make your move");
            Scanner sc = new Scanner(System.in);
            int row = sc.nextInt();
            int col = sc.nextInt();
            Move oppMove = new Move(new Cells(row, col));
            game.move(board, opponent, oppMove);
            if(!game.isComplete(board).isOver()){
            Move computerMove = game.suggetMove(computer, board);
            game.move(board, computer, computerMove);
        }
            System.out.println("Game Results:"+ game.isComplete(board));
    }}
}
