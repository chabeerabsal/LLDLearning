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
            TicTacToeBoard board1 = (TicTacToeBoard) board;
            board1.setCells(player.symbol(),move.getCells());

        }

    }
    public GameResult isComplete(Board board){

         if(board instanceof TicTacToeBoard)
         {
             TicTacToeBoard board1 = (TicTacToeBoard) board;
             boolean rowComplete=true;
             String firstCharacter="_";
             for(int i=0;i<3;i++) {
                 firstCharacter = board1.getcells(i, 0);
                 rowComplete = firstCharacter != null;
                 if (firstCharacter != null) {
                     for (int j = 1; j < 3; j++) {

                         if (!firstCharacter.equals(board1.getcells(i, j))) {
                             rowComplete = false;
                             break;
                         }
                     }
                 }
                 if (rowComplete) {
                     break;
                 }
             }
                 if(rowComplete)
                     return new GameResult(true,firstCharacter);

               boolean  colComplete=true;

                 for(int i=0;i<3;i++) {
                     firstCharacter = board1.getcells(0, i);
                     colComplete = firstCharacter != null;
                     if (firstCharacter != null) {
                         for (int j = 1; j < 3; j++) {
                             if (!firstCharacter.equals(board1.getcells(j, i))) {
                                 colComplete = false;
                                 break;
                             }
                         }
                     }
                     if (colComplete) {
                         break;
                     }
                 }
                 if(colComplete)
                     return new GameResult(true,firstCharacter);

                 firstCharacter=board1.getcells(0,0);
                 boolean  diagComplete=firstCharacter!=null;

                 for(int i=0;i<3;i++)
                 {

                     if(firstCharacter != null&&!firstCharacter.equals(board1.getcells(i,i))) {
                         diagComplete = false;
                         break;
                     }
                 }
                 if(diagComplete)
                     return new GameResult(true,firstCharacter);

                 firstCharacter=board1.getcells(0,2);
                 boolean  revdiagComplete=firstCharacter!=null;
                 for(int i=0;i<3;i++)
                 {

                     if(firstCharacter != null&&!firstCharacter.equals(board1.getcells(i,2-i))) {
                         revdiagComplete = false;
                         break;
                     }
                 }
                 if(revdiagComplete)
                     return new GameResult(true,firstCharacter);

          int count=0;
             for(int i=0;i<3;i++)
             {
                 for(int j=0;j<3;j++)
                 {
                     if(board1.getcells(i,j)!=null)
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

    public Move suggetMove(Player computer, Board board) {
        if(board instanceof TicTacToeBoard)
        {
            TicTacToeBoard board1 = (TicTacToeBoard) board;
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                if(board1.getcells(i,j)==null)
                    return new Move(new Cells(i,j));

            }
        }
        throw new IllegalStateException();
    }
        throw new IllegalArgumentException();
    }
}

