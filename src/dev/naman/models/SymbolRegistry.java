package dev.naman.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SymbolRegistry {
    private static List<Symbol> symbols = new ArrayList<>();

    public static void addSymbol(char symbol) {
        for (Symbol symbol1: symbols) {
            if (symbol1.getSymbol() == symbol) {
                return;
            }
        }
        symbols.add(new Symbol(symbol));
    }

    public static List<Symbol> getSymbols() {
        return symbols;
    }
}
