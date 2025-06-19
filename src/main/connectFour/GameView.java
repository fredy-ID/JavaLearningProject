package main.connectFour;

import java.util.Arrays;

public class GameView {

    public void displayBoard(int[][] board) {
        for (int i=0; i<board.length; i++) { // rows
            System.out.println(Arrays.toString(board[i]));
        }
    }
}
