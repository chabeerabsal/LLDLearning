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
            int threshold=3;
            if(countMoves(board1)<threshold) {
                suggestion=getBasicMove(board1, computer);
            }
            else{
                suggestion=smartMove(board1,computer);
            }
            if(suggestion!=null)
                return suggestion;
            throw new IllegalStateException();
        }
        throw new IllegalArgumentException();
    }

    private Move smartMove(TicTacToeBoard board1, Player player) {
        RuleEngine ruleEngine = new RuleEngine();
        //victorious move
        for(int i=0;i<3;i++) {
            for (int j = 0; j < 3; j++) {
                if (board1.getSymbol(i, j) == null) {
                    Move move = new Move(new Cells(i, j), player);
                    board1.move(move);
                    if (ruleEngine.isComplete(board1).isOver()) {
                        return move;
                    }

                }
            }
        }
        //defensive
        for(int i=0;i<3;i++) {
            for (int j = 0; j < 3; j++) {
                if (board1.getcells(i, j) == null) {
                    Move move = new Move(new Cells(i, j), player.flip());
                    TicTacToeBoard boardcopy=board1.copy();
                    boardcopy.move(move);
                    if (ruleEngine.isComplete(boardcopy).isOver()) {
                        return new Move(new Cells(i, j), player);
                    }

                }
            }
        }
       return getBasicMove(board1,player);
    }

    private int countMoves(TicTacToeBoard board1) {
        int count=0;
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                if(board1.getcells(i,j)==null)
                    count++;

            }
        }
        return count;

    }

    private Move getBasicMove(TicTacToeBoard board1, Player player) {
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                if(board1.getcells(i,j)==null)
                    return new Move(new Cells(i,j),player);

            }
        }
        throw new IllegalArgumentException();
    }
}
