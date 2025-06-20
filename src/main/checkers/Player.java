package main.checkers;

public class Player {
    private final int id;
    private final String color;

    public enum playerPieces {};

    public int getId() {
        return id;
    }

    public String getColor() {
        return color;
    }

    public Player(int id, String color) {
        this.id = id;
        this.color = color;
    }

    // The player is chosen and is given a default color
    // The player
}
