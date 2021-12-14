package dev.naman.models;

import dev.naman.exceptions.InvalidSymbolException;

import java.util.Scanner;

public class HumanPlayer extends Player {
    User user;

    public static Builder getBuilder() {
        return new Builder();
    }

    @Override
    public Move makeMove(Board board) {
        int x, y;

        System.out.println("Enter player's move (x, y): ");
        Scanner scanner = new Scanner(System.in);
        x = scanner.nextInt();
        y = scanner.nextInt();

        return new Move(x, y);
    }

    public static class Builder {
        private HumanPlayer humanPlayer;

        Builder() {
            this.humanPlayer = new HumanPlayer();
        }

        public Builder setUser(User user) {
            this.humanPlayer.user = user;
            return this;
        }

        public Builder setSymbol(char symbol) {
            for (Symbol symbol1: SymbolRegistry.getSymbols()) {
                if (symbol1.getSymbol() == symbol) {
                    this.humanPlayer.setSymbol(symbol1);
                    return this;
                }
            }
            throw new InvalidSymbolException();
        }

        public HumanPlayer build() {
            return this.humanPlayer;
        }
    }
}
