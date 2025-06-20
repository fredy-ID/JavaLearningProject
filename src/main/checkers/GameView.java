package main.checkers;

import java.util.Arrays;

public class GameView {
    //display board

    private char[] mapCoord;

    public GameView() {
        //TODO : Use ascii
        this.mapCoord = new char[] {
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'
        };
    }

    public char[] getMapCoord() {
        return mapCoord;
    }

    public void displayBoard(Piece[][] board) {
        for (int i=0; i<board.length; i++) { // rows
            System.out.println(this.mapCoord[i]+"| "+Arrays.toString(board[i])+" |");
        }
    }
}
