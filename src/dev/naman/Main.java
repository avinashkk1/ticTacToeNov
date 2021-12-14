package dev.naman;

import dev.naman.controllers.GameController;
import dev.naman.factories.PlayerFactory;
import dev.naman.models.*;
import dev.naman.strategies.automove.RandomMoveStrategy;
import dev.naman.strategies.movevalidation.DefaultValidationStrategy;
import dev.naman.strategies.winning.DefaultWinningStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        SymbolRegistry symbolRegistry = new SymbolRegistry();
        symbolRegistry.addSymbol('X');
        symbolRegistry.addSymbol('O');

        HashMap<String, User> users = new HashMap<>();
        User user = User.getBuilder()
                .seUserName("avinash")
                .setEmail("avinash@gmail.com")
                .build();
        users.put("avinash", user);

        Game game = Game.getBuilder()
                .addPlayer(
                        PlayerFactory.createHumanPlayer()
                            .setUser(users.get("avinash"))
                            .setSymbol('O')
                            .build()
                )
                .addPlayer(
                        PlayerFactory.createBot()
                            .setMoveStrategy(new RandomMoveStrategy())
                            .setSymbol('X')
                            .build()
                )
                .addWinningStrategy(new DefaultWinningStrategy())
                .addValidationStrategy(new DefaultValidationStrategy())
                .setRows(3)
                .setColumns(3)
                .build();
        GameController.run(game);
    }
}
