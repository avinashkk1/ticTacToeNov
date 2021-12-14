package dev.naman.controllers;

import dev.naman.models.Board;
import dev.naman.models.Game;
import dev.naman.models.Move;
import dev.naman.models.Player;
import dev.naman.strategies.movevalidation.IValidationStrategy;
import dev.naman.strategies.winning.IWinningStrategy;

import java.util.List;

public class GameController {

    public static void run(Game game) {
        Player winner = null;
        Board board = game.getBoard();
        List<Player> players = game.getPlayers();
        int numberOfPossibleTurns = board.getNumberOfRows() * board.getNumberOfColumns();
        int numberOfTurnsTillNow = 0;
        int currentPlayer = 0;
        int numberOfPlayers = players.size();

        board.printBoard();
        while (winner == null && numberOfTurnsTillNow < numberOfPossibleTurns) {
            // Assuming player 1 gets the first chance to play

            Move move = players.get(currentPlayer).makeMove(board);
            for (IValidationStrategy validationStrategy: game.getValidationStrategies()) {
                validationStrategy.validateMove(board, move);
            }
            board.getBoard()
                    .get(move.getX())
                    .get(move.getY())
                    .setSymbol(players.get(currentPlayer).getSymbol());
            board.printBoard();

            for (IWinningStrategy winningStrategy: game.getWinningStrategies()) {
                winner = winningStrategy.checkWinner(board, players);
                if ( winner != null ) {
                    break;
                }
            }

            currentPlayer = currentPlayer + 1;
            currentPlayer = currentPlayer % numberOfPlayers;
            numberOfTurnsTillNow = numberOfTurnsTillNow + 1;
        }

        if ( winner != null ) {
            System.out.println("Player " + winner.getSymbol().getSymbol() + " wins the game");
        } else {
            System.out.println("Game result: Draw");
        }

    }
}
