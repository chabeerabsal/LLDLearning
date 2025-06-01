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

    @Override
    public String toString() {
        String result="";
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(cells[i][j]!=null)
                result+=cells[i][j];
                else
                    result+="_";
            }
            result+="\n";
        }
        return result;
    }
}
