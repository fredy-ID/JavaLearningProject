package main.checkers;

import java.util.ArrayList;
import java.util.List;

public class Game {
    Player playerOne = new Player(1, "white");
    Player playerTwo = new Player(2, "black");

    public void play(int height, int width, int startingRows) {
        //get board
        Board board = new Board(height,width, startingRows);
        GameView gameView = new GameView();
        BoardCheckersInitialSetup allStartingAvailableSquares;

        allStartingAvailableSquares = board.initBoardGame();

        List<Coord> whitePlayerSquares = allStartingAvailableSquares.getWhitePlayerSquares();
        List<Coord> blackPlayerSquares = allStartingAvailableSquares.getBlackPlayerSquares();

        List<Piece> startingPieces = this.generatePieces(whitePlayerSquares, blackPlayerSquares);

        board.boardSetPieces(startingPieces);

        boolean gameSessionUp = true;

        while (gameSessionUp) {
            int currentPlayer = playerOne.getId();
            gameView.displayBoard(board.getBoard());

            gameSessionUp=false;
        }


    }

    private List<Piece> generatePieces(List<Coord> whitePlayerSquares, List<Coord> blackPlayerSquares){
        List<Piece> startingPieces = new ArrayList<>();

        //Enhanced for loop O.O what ??? xD
        for (Coord whitePlayerSquare : whitePlayerSquares) {
            startingPieces.add(new Piece(whitePlayerSquare.getRow(), whitePlayerSquare.getCol(), playerOne));
        }

        for(int i=0; i<blackPlayerSquares.size(); i++){
            startingPieces.add(new Piece(blackPlayerSquares.get(i).getRow(), blackPlayerSquares.get(i).getCol(), playerTwo));
        }

        return startingPieces;
    }

    //take player action
    //check if player action is winning play
    //continue or end game
}
