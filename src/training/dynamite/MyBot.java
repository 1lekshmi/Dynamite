package training.dynamite;

import com.softwire.dynamite.bot.Bot;
import com.softwire.dynamite.game.*;

public class MyBot implements Bot {

    public MyBot() {
        // Are you debugging?
        // Put a breakpoint on the line below to see when we start a new match
        System.out.println("Started new match");
    }

    @Override
    public Move makeMove(Gamestate gamestate) {
        // Are you debugging?
        // Put a breakpoint in this method to see when we make a move
        return gamestate.getRounds().size() < 100 ? Move.D : getWinnableMove(gamestate);
    }

    public Move getWinnableMove(Gamestate gamestate){
        Move P1 = getAllMove();
        if(gamestate.getRounds().size() >100){
            Round lastRound = gamestate.getRounds().get(gamestate.getRounds().size() - 1);
            Move P2 = lastRound.getP2();

            if (P2 == Move.P){
                P1 = Move.S;
            } else if (P2 == Move.S) {
                P1 = Move.R;
            } else if (P2 == Move.R) {
                P1 = Move.P;
            } else if(P2 == Move.D){
                P1 = Move.W;
            } else if (P2 == Move.W) {
                P1 = getRandomMove();
            }
        }
        return P1;
    }

//    public Move getDynamiteMoves(Gamestate gamestate){
//        Move P1 = getAllMove();
//        if (gamestate.)
//    }

    public Move getRandomMove() {
        int randomNumberBetween0And3 = (int)Math.floor(Math.random() * 3.0);
        Move[] possibleMoves = new Move[]{Move.R, Move.P, Move.S};
        return possibleMoves[randomNumberBetween0And3];
    }

    public Move getAllMove(){
        int randomNumberBetween0And3 = (int)Math.floor(Math.random() * 3.0);
        Move[] possibleMoves = new Move[]{Move.R, Move.P, Move.S, Move.D};
        return possibleMoves[randomNumberBetween0And3];

    }

}
