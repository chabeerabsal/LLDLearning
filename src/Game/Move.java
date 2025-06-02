package Game;

public class Move {

   private Cells cell;
   private Player player;

    public Move(Cells cells, Player player) {
        this.cell = cells;
        this.player = player;
    }


    public Cells getCells() {

        return cell;
    }

    public Player getPlayer() {
        return player;
    }
}

