package main.checkers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {
    Player playerOne = new Player(1, "white");
    Player playerTwo = new Player(2, "black");
    Player defaultNullPlayer = new Player(0, "none");

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

        //start game session
        while (gameSessionUp) {
            Player currentPlayer = playerOne;
            gameView.displayBoard(board.getBoard());
            String input = currentPlayer.getInput();

            char[] mapCoord = gameView.getMapCoord();

            //TODO : Find another method to initialize rowNumber
            int rowNumber=-9999;
            int columnNumber = Character.getNumericValue(input.charAt(1));

            for (int i=0; i < mapCoord.length; i++) {
                if (mapCoord[i] == Character.toUpperCase(input.charAt(0))) {
                    rowNumber=i;
                    break;
                }
            }

            Piece selectedPiece = board.getBoard()[rowNumber][columnNumber];
            if(selectedPiece != null) {
                Piece[] surrounding = selectedPiece.checkAround(board.getBoard(), defaultNullPlayer);
                System.out.println("surrounding : "+ Arrays.toString(surrounding));
            }



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
