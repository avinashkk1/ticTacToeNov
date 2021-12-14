package dev.naman.strategies.automove;

import dev.naman.models.Board;
import dev.naman.models.Move;

public class RandomMoveStrategy implements IAutomaticMoveStrategy {
    @Override
    public Move makeMove(Board board) {
        for ( int i = 0; i < board.getNumberOfRows(); ++i ) {
            for ( int j = 0; j < board.getNumberOfColumns(); ++ j ) {
                if ( board.getBoard().get(i).get(j).getSymbol() == null ) {
                    return new Move(i, j);
                }
            }
        }
        return null;
    }
}
