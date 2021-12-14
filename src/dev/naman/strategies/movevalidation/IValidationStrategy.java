package dev.naman.strategies.movevalidation;

import dev.naman.models.Board;
import dev.naman.models.Move;

public interface IValidationStrategy {
    boolean validateMove(Board board, Move move);
}
