package dev.naman.strategies.winning;

import dev.naman.exceptions.InvalidBoardException;
import dev.naman.exceptions.InvalidPlayersQuanityException;
import dev.naman.models.Board;
import dev.naman.models.Player;
import dev.naman.models.Symbol;

import java.util.List;

public class DefaultWinningStrategy implements IWinningStrategy {
    @Override
    public Player checkWinner(Board board, List<Player> players) {
        Player winner;

        if ( board == null ) {
            throw new InvalidBoardException("Board is empty");
        }

        if ( players == null ) {
            throw new InvalidPlayersQuanityException("No players found");
        }

        winner = checkBoardRowsForWinner(board, players);
        if ( winner != null ) {
            return winner;
        }

        winner = checkBoardColumnsForWinner(board, players);
        return winner;

        // Check for Diagonals
    }

    private Player checkBoardRowsForWinner(Board board, List<Player> players) {

        for (int i = 0; i < board.getNumberOfRows(); ++i) {
            Symbol symbol = board.getBoard().get(i).get(0).getSymbol();
            if ( symbol == null ) {
                continue;
            }

            int j = 0;
            for (; j < board.getNumberOfColumns(); ++ j) {
                Symbol symbol1 = board.getBoard().get(i).get(j).getSymbol();
                if ( symbol1 == null || symbol1.getSymbol() != symbol.getSymbol() ) {
                    break;
                }
            }

            if ( j == board.getNumberOfColumns() ) {
                for ( Player player : players ) {
                    if ( player.getSymbol().getSymbol() == symbol.getSymbol() ) {
                        return player;
                    }
                }
            }
        }

        return null;
    }

    private Player checkBoardColumnsForWinner(Board board, List<Player> players) {

        for (int i = 0; i < board.getNumberOfColumns(); ++i) {
            Symbol symbol = board.getBoard().get(0).get(i).getSymbol();
            if ( symbol == null ) {
                continue;
            }

            int j = 0;
            for (; j < board.getNumberOfRows(); ++j ) {
                Symbol symbol1 = board.getBoard().get(j).get(i).getSymbol();
                if ( symbol1 == null || symbol1.getSymbol() != symbol.getSymbol() ) {
                    break;
                }
            }

            if ( j == board.getNumberOfRows() ) {
                for ( Player player : players ) {
                    if ( player.getSymbol().getSymbol() == symbol.getSymbol() ) {
                        return player;
                    }
                }
            }
        }

        return null;
    }


}
