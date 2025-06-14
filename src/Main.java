import Game.Board;
import Game.Cells;
import Game.Move;
import Game.Player;
import api.AiEngine;
import api.GameEngine;
import api.RuleEngine;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GameEngine game = new GameEngine();

        AiEngine ai = new AiEngine();
        RuleEngine rule = new RuleEngine();
        Board board=game.start("Tic-Tac-Toe");
        while(!rule.isComplete(board).isOver()) {
            Player opponent=new Player("O");
            Player computer=new Player("X");
            System.out.println("Make your move");
            System.out.println(board);
            Scanner sc = new Scanner(System.in);
            int row = sc.nextInt();
            int col = sc.nextInt();
            Move oppMove = new Move(new Cells(row, col),opponent);
            game.move(board, opponent, oppMove);
            System.out.println(board);
            if(!rule.isComplete(board).isOver()){
            Move computerMove = ai.suggetMove(computer, board);

            game.move(board, computer, computerMove);
        }
            System.out.println("Game Results:"+ rule.isComplete(board));
            System.out.println(board);
    }}
}
