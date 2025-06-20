package main;

import main.checkers.Game;

public class GameCheckers {

    public void Play() {
        Game game = new Game();

        game.play(8, 8, 3);
    }

}
