package dev.naman.models;

import dev.naman.exceptions.DuplicateSymbolException;
import dev.naman.exceptions.InvalidPlayersQuanityException;
import dev.naman.strategies.movevalidation.IValidationStrategy;
import dev.naman.strategies.winning.IWinningStrategy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Game {
    private List<Player> players = new ArrayList<>();
    private Board board;
    private List<IWinningStrategy> winningStrategies = new ArrayList<>();
    private List<IValidationStrategy> validationStrategies = new ArrayList<>();



    public List<IWinningStrategy> getWinningStrategies() {
        return winningStrategies;
    }

    public List<IValidationStrategy> getValidationStrategies() {
        return validationStrategies;
    }

    public void setValidationStrategies(List<IValidationStrategy> validationStrategies) {
        this.validationStrategies = validationStrategies;
    }


    public List<Player> getPlayers() {
        return players;
    }

    public Board getBoard() {
        return board;
    }


    public static Builder getBuilder() {
        return new Builder();
    }

    public static class Builder {
        private Game game;
        private int rows;
        private int columns;

        Builder() {
            this.game = new Game();
        }

        public Builder addPlayer(Player player) {
            game.getPlayers().add(player);
            return this;
        }

        public Builder addWinningStrategy(IWinningStrategy strategy) {
            game.winningStrategies.add(strategy);
            return this;
        }

        public Builder addValidationStrategy(IValidationStrategy validationStrategy) {
            game.validationStrategies.add(validationStrategy);
            return this;
        }

        public Builder setRows(int rows) {
            this.rows = rows;
            return this;
        }

        public Builder setColumns(int columns) {
            this.columns = columns;
            return this;
        }

        public Game build() {
            if (game.getPlayers().size() < 2) {
                throw new InvalidPlayersQuanityException();
            }
            Set<Character> symbols = new HashSet<>();

            for (Player player: game.getPlayers()) {
                if (symbols.contains(player.getSymbol().getSymbol())) {
                    throw new DuplicateSymbolException();
                }
                symbols.add(player.getSymbol().getSymbol());
            }

            game.board = new Board(rows, columns);
            return game;
        }
    }
}
