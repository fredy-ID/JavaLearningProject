package main.connectFour;

public class Board {
    private final int[][] board;

    public Board() {
        this.board = new int[][]{
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0}
        };
    }

    public int[][] getBoard() {
        return board;
    }

    public final int updateBoard(int choice, int currentPlayer) {
        for (int i = this.board.length - 1; i >= 0; i--) { // rows
            for (int j = 0; j < this.board[i].length; j++) { //columns
                if(j==choice-1 && this.board[i][j]==0){
                    this.board[i][j] = currentPlayer;
                    return i;
                }
            }
        }
        return -1;
    }
}
