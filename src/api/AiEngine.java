package api;

import Game.Board;
import Game.Cells;
import Game.Move;
import Game.Player;
import boards.TicTacToeBoard;

public class AiEngine {
    public Move suggetMove(Player computer, Board board) {
        if(board instanceof TicTacToeBoard)
        {
            TicTacToeBoard board1 = (TicTacToeBoard) board;
            //simple move by computer

            Move suggestion=null;
            if(isStarting(board1,4)) {
                suggestion=getBasicMove(board1, computer);
            }
//            else{
//                return smartMove(board1,computer);
//            }
            if(suggestion!=null)
                return suggestion;
            throw new IllegalStateException();
        }
        throw new IllegalArgumentException();
    }

    private boolean isStarting(TicTacToeBoard board1, int threshold) {
        int count=0;
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                if(board1.getcells(i,j)==null)
                    count++;

            }
        }
        return count<threshold;

    }

    private Move getBasicMove(TicTacToeBoard board1, Player computer) {
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                if(board1.getcells(i,j)==null)
                    return new Move(new Cells(i,j),computer);

            }
        }
        throw new IllegalArgumentException();
    }
}
