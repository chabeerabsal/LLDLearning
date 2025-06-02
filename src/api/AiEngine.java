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
            for(int i=0;i<3;i++)
            {
                for(int j=0;j<3;j++)
                {
                    if(board1.getcells(i,j)==null)
                        return new Move(new Cells(i,j),computer);

                }
            }
            throw new IllegalStateException();
        }
        throw new IllegalArgumentException();
    }
}
