package main.checkers;

public class Utils {

    public Piece validatePosition(int row, int column, Piece[][] board) {
        Piece result;

        if (row >= 0 && row < board.length &&
                column >= 0 && column < board[0].length) {
            result = board[row][column];
        }else{
            result = null;
        }
        System.out.println("result ____ + "+result+" row : "+row+" column : "+column);
        return result;
    }
}
