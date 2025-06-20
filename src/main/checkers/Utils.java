package main.checkers;

public class Utils {

    public Piece convertIfNull(Piece piece, int x, int y, Player player) {

        if (piece == null) {
            return new Piece(x, y, player);
        }
        return piece;
    }

    public Piece nullIfNotExists(Piece piece) {

        if (piece == null) {
            System.out.println("DO NOT EXIT");
            return null;
        }
        return piece;
    }
}
