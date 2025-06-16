package api;

import Game.Board;
import Game.GameResult;
import boards.TicTacToeBoard;

public class RuleEngine {
    public GameResult isComplete(Board board){

        if(board instanceof TicTacToeBoard)
        {
            TicTacToeBoard board1 = (TicTacToeBoard) board;
            boolean someOneIsVictorious=true;
            String firstCharacter="_";
            for(int i=0;i<3;i++) {
                firstCharacter = board1.getcells(i, 0);
                someOneIsVictorious = firstCharacter != null;
                if (firstCharacter != null) {
                    for (int j = 1; j < 3; j++) {

                        if (!firstCharacter.equals(board1.getcells(i, j))) {
                            someOneIsVictorious = false;
                            break;
                        }
                    }
                }
                if (someOneIsVictorious) {
                    return new GameResult(true,firstCharacter);
                }
            }
          

            someOneIsVictorious=true;

            for(int i=0;i<3;i++) {
                firstCharacter = board1.getcells(0, i);
                someOneIsVictorious = firstCharacter != null;
                if (firstCharacter != null) {
                    for (int j = 1; j < 3; j++) {
                        if (!firstCharacter.equals(board1.getcells(j, i))) {
                            someOneIsVictorious = false;
                            break;
                        }
                    }
                }
                if (someOneIsVictorious) {
                    return new GameResult(true,firstCharacter);
                    //Tic-tac-toe- is very hard
                }
            }

            //SOLID pricibles



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
}
