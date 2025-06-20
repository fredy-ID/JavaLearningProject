package main.checkers;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final Piece[][] board;
    private final int startingRows;

    public Board(int height, int width, int startingRows) {
        this.board = new Piece[height][width];
        this.startingRows = startingRows;
    }

    public BoardCheckersInitialSetup initBoardGame() {
        return this.generateAvailableSpaces(this.startingRows);
    }

    public void boardSetPieces(List<Piece> pieces) {
        for (int i = 0; i < pieces.size(); i++) {
            for (Piece piece : pieces) {
                this.board[piece.getPosition()[0]][piece.getPosition()[1]] = piece;
            }
        }
    }

    // NOTE : (not relevant, only for code flexibility with board size)
    private BoardCheckersInitialSetup generateAvailableSpaces(int startingRows) {
        /*
            Checker players only splay on dark squares

            The player's pîeces always start with first square witch is black.
            every two row (2,4,6...) the piece start at second square witch is black

            So my setup is : Top-Left (0,0) is White

            (0,0): 0+0=0 (pair) -> White
            (0,1): 0+1=1 (not pair) -> Black
            (0,2): 0+2=2 (pair) -> White
            (1,0): 1+0=1 (not pair) -> Black
            (1,1): 1+1=2 (pair) -> White
            (1,2): 1+2=3 (not pair) -> Black
         */

        //x and y for black player
        List<Coord> blackPlayerCheckerSquares = new ArrayList<>();

        for (int i = 0; i < startingRows; i++) {
            for (int j = 0; j < this.board[0].length; j++) {
                if ((i + j) % 2 != 0) {
                    blackPlayerCheckerSquares.add(new Coord(i, j));
                }
            }
        }

        //x's and y's for white player
        List<Coord> whitePlayerCheckerSquares = new ArrayList<>();

        int boardTotalRows = this.board.length;
        int blackPlayerStartRowIndex = boardTotalRows - startingRows;

        //go to last row
        for (int i = blackPlayerStartRowIndex; i < boardTotalRows; i++) {
            for (int j = 0; j < this.board[0].length; j++) {
                if ((i + j) % 2 != 0) {
                    whitePlayerCheckerSquares.add(new Coord(i, j));
                }
            }
        }

        return new BoardCheckersInitialSetup(whitePlayerCheckerSquares, blackPlayerCheckerSquares);

    }

    public Piece[][] getBoard() {
        return board;
    }

    public int getStartingRows() {
        return startingRows;
    }

    //board init
    //board update
}
