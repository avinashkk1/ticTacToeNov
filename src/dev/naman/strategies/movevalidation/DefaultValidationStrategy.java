package dev.naman.strategies.movevalidation;

import dev.naman.exceptions.InvalidMoveException;
import dev.naman.models.Board;
import dev.naman.models.Move;

public class DefaultValidationStrategy implements IValidationStrategy {
    @Override
    public boolean validateMove(Board board, Move move) {
        if ( ! (move.getX() >= 0 && move.getX() < board.getNumberOfRows()) ) {
            throw new InvalidMoveException("X value supplied is not within board dimensions");
        }

        if ( ! (move.getY() >= 0 && move.getY() < board.getNumberOfColumns()) ) {
            throw new InvalidMoveException("Y value supplied is not within board dimensions");
        }

        if ( board.getBoard().get(move.getX()).get(move.getY()).getSymbol() != null ) {
            throw new InvalidMoveException("Supplied (X,Y) is already filled in the board");
        }

        return true;
    }
}
