package dev.naman.models;

import dev.naman.strategies.automove.IAutomaticMoveStrategy;

public class Bot extends Player {
    private IAutomaticMoveStrategy automaticMoveStrategy;

    public static Builder getBuilder() {
        return new Builder();
    }

    @Override
    public Move makeMove(Board board) {
        return automaticMoveStrategy.makeMove(board);
    }

    public static class Builder {
        private Bot bot;

        Builder() {
            this.bot = new Bot();
        }

        public Builder setMoveStrategy(IAutomaticMoveStrategy strategy) {
            this.bot.automaticMoveStrategy = strategy;
            return this;
        }

        public Builder setSymbol(char symbol) {
            this.bot.setSymbol(new Symbol(symbol));
            return this;
        }

        public Bot build() {
            return this.bot;
        }
    }
}


// A or B or C
// A and B and C