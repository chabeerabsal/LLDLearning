package Game;

import boards.TicTacToeBoard;

public interface Board {

    public abstract void move(Move move);


    public TicTacToeBoard copy();
}
