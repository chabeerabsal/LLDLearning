package boards;

import Game.Board;
import Game.Cells;

public class TicTacToeBoard extends Board {
    String[][] cells = new String[3][3];



    public String getcells(int row, int col) {
        return cells[row][col];
    }

    public void setCells(String symbol, Cells cell) {
                  cells[cell.getRow()][cell.getCol()]=symbol;
    }
}
