package main.checkers;

import java.util.List;

public class BoardCheckersInitialSetup {
    private final List<Coord> whitePlayerSquares;
    private final List<Coord> blackPlayerSquares;

    public BoardCheckersInitialSetup(List<Coord> whitePlayerSquares, List<Coord> blackPlayerSquares) {
        this.whitePlayerSquares = whitePlayerSquares;
        this.blackPlayerSquares = blackPlayerSquares;
    }

    public List<Coord> getWhitePlayerSquares() {
        return whitePlayerSquares;
    }

    public List<Coord> getBlackPlayerSquares() {
        return blackPlayerSquares;
    }
}