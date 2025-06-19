package main.connectFour;

import java.util.Arrays;

public class Board {
    private int[][] board;

    public int[][] GetBoard() {
        this.board = new int[][] {
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0}
        };

        return this.board;
    }



    public Object[] updateBoard(int choice, int currentPlayer, int[][] board) {
        boolean boardUpdated = false;
        int selectedBoardLine = -9999;

        for (int i = board.length - 1; i >= 0; i--) { // rows
            for (int j = 0; j < board[i].length; j++) { //columns
                if(j==choice-1 && board[i][j]==0){
                    board[i][j] = currentPlayer;
                    selectedBoardLine=i;
                    boardUpdated = true;
                }
            }
            //board already updated
            if (boardUpdated) {
                break;
            }
        }

        return new Object[] {selectedBoardLine, board};
    }

}
