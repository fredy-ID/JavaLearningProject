package main.checkers;

import java.util.Scanner;

public class Player {
    private final int id;
    private final String color;
    private String input;

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

    public String getInput(String txt) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(txt);
        this.input = scanner.nextLine().trim();

        return input;
    }

    // The player is chosen and is given a default color
    // The player
}
