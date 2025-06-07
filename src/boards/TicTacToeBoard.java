package boards;

import Game.Board;
import Game.Cells;
import Game.Move;

public class TicTacToeBoard implements Board {
    String[][] cells = new String[3][3];



    public String getcells(int row, int col) {
        return cells[row][col];
    }

    public void setCells(String symbol, Cells cell) {
        if(cells[cell.getRow()][cell.getCol()]==null)
                  cells[cell.getRow()][cell.getCol()]=symbol;
        else
            throw new IllegalStateException();
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

    @Override
    public void move(Move move) {
        setCells(move.getPlayer().symbol(),move.getCells());
    }

    @Override
    public TicTacToeBoard copy() {
        TicTacToeBoard copy = new TicTacToeBoard();
        for (int i = 0; i < 3; i++) {
            System.arraycopy(cells[i],0,copy.cells[i],0,3);
        }
        return copy;
    }


    public String getSymbol(int i, int j) {
        return cells[i][j];
    }
}
