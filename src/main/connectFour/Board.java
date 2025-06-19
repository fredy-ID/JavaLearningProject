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



    public int updateBoard(int choice, int currentPlayer, board) {
        boolean boardUpdated = false;
        int selectedBoardLine = -9999;

        for (int i = this.board.length - 1; i >= 0; i--) { // rows
            for (int j = 0; j < this.board[i].length; j++) { //columns
                if(j==choice-1 && this.board[i][j]==0){
                    this.board[i][j] = currentPlayer;
                    selectedBoardLine=i;
                    boardUpdated = true;
                }
            }
            //board already updated
            if (boardUpdated) {
                break;
            }
        }

        return selectedBoardLine;
    }

}
