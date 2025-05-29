package api;

import Game.Board;
import Game.GameResult;
import Game.Move;
import Game.Player;
import boards.TicTacToeBoard;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class GameEngine {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

    }

    public Board start(){
        return new Board();
    }
    public void move(Board board, Player player, Move move){

    }
    public GameResult isComplete(Board board){

         if(board instanceof TicTacToeBoard)
         {
             TicTacToeBoard board1 = (TicTacToeBoard) board;
             boolean rowComplete=true;
             String firstCharacter="_";
             for(int i=0;i<3;i++)
             {
                 rowComplete=true;

                 for(int j=0;j<3;j++)
                 {
                     firstCharacter=board1.getcells([i][0]);
                     if(!board1.cells[i][j].equals(firstCharacter)) {
                         rowComplete = false;
                         break;
                     }
                 }
                 if(rowComplete)
                     return new GameResult(true,firstCharacter);

               boolean  colComplete=true;

                 for(int j=0;j<3;j++)
                 {
                     firstCharacter=board1.cells[0][i];
                     if(!board1.cells[j][i].equals(firstCharacter)) {
                         colComplete = false;
                         break;
                     }
                 }
                 if(colComplete)
                     return new GameResult(true,firstCharacter);

                 boolean  diagComplete=true;

                 for(int j=0;j<3;j++)
                 {
                     firstCharacter=board1.cells[0][0];
                     if(!board1.cells[i][i].equals(firstCharacter)) {
                         diagComplete = false;
                         break;
                     }
                 }
                 if(diagComplete)
                     return new GameResult(true,firstCharacter);
                 boolean  revdiagComplete=true;

                 for(int j=0;j<3;j++)
                 {
                     firstCharacter=board1.cells[0][2];
                     if(!board1.cells[i][2-i].equals(firstCharacter)) {
                         colComplete = false;
                         break;
                     }
                 }
                 if(colComplete)
                     return new GameResult(true,firstCharacter);
             }
          int count=0;
             for(int i=0;i<3;i++)
             {
                 for(int j=0;j<3;j++)
                 {
                     if(board1.cells[i][j]!=null)
                         count++;

                 }
             }
             if(count==9)
                 return new GameResult(true,"_");
             else
                 return new GameResult(false,"_");

         }
         return new GameResult(false,"_");
    }
}

