package com.in28minutes.learnspringframework.game;

import org.springframework.stereotype.Component;

@Component
public class GameRunner {
    GamingConsole game;

    public GameRunner(GamingConsole game) {
        this.game = game;
    }

    public void run() {
        System.out.println("Running the Game: " + game);
        game.up();
        game.right();
        game.left();
        game.down();
    }
}
