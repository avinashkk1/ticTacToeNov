package dev.naman.models;

public abstract class Player {
    private Symbol symbol;

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public abstract Move makeMove(Board board);
}
