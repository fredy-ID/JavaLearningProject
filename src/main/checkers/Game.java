package main.checkers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {
    Player playerOne = new Player(1, "white");
    Player playerTwo = new Player(2, "black");
    Player defaultNullPlayer = new Player(-1, "none");

    Utils utils = new Utils();

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

        //start game session
        Player currentPlayer = playerTwo;
        System.out.println("____ Now playing ____"+currentPlayer.getColor());
        while (true) {
            gameView.displayBoard(board.getBoard());
            System.out.println("current player : " + currentPlayer.getColor());
            String input = currentPlayer.getInput("Type coord (ex: g4) : ");

            char[] mapCoord = gameView.getMapCoord();

            // convert input to row and column
            int rowNumber = -1;
            int columnNumber = -1;
            if (input.length() >= 2) {
                char rowChar = Character.toUpperCase(input.charAt(0));
                char colChar = input.charAt(1);
                // search for row index
                for (int i = 0; i < mapCoord.length; i++) {
                    if (mapCoord[i] == rowChar) {
                        rowNumber = i;
                        break;
                    }
                }
                // convert column to number
                if (Character.isDigit(colChar)) {
                    columnNumber = Character.getNumericValue(colChar) - 1; // '1' -> 0
                }
            }

            // Validation des coordonnées
            Piece selectedPiece = utils.validatePosition(rowNumber, columnNumber, board.getBoard());
            if(selectedPiece == null) {
                System.out.println("invalid coordinates or empty square. try again.");
                continue;
            }
            // Vérifie que la pièce appartient bien au joueur courant
            if(selectedPiece != null && selectedPiece.toString().equals(""+currentPlayer.getId())) {
                Piece[] surrounding = selectedPiece.checkAround(board.getBoard(), defaultNullPlayer);
                System.out.println("surrounding : "+ Arrays.toString(surrounding));

                //possible actions, terminal display text
                String text = " ";
                for(int i=0; i<surrounding.length;i++){
                    if(surrounding[i]==null){
                        if(i==0){text+="left ";}
                        if(i==1){text+=" or right";}
                    }
                }

                System.out.println("text : "+ text);
                //get next move
                input = currentPlayer.getInput(text);
                selectedPiece.goTo(input);
                // display board
                gameView.displayBoard(board.getBoard());
                // change player
                currentPlayer = (currentPlayer == playerOne) ? playerTwo : playerOne;
            } else {
                System.out.println("invalid piece selection !");
            }
        }
    }

    private List<Piece> generatePieces(List<Coord> whitePlayerSquares, List<Coord> blackPlayerSquares){
        List<Piece> startingPieces = new ArrayList<>();

        for (Coord whitePlayerSquare : whitePlayerSquares) {
            startingPieces.add(new Piece(whitePlayerSquare.getRow(), whitePlayerSquare.getCol(), playerOne));
        }

        for (Coord blackPlayerSquare : blackPlayerSquares) {
            startingPieces.add(new Piece(blackPlayerSquare.getRow(), blackPlayerSquare.getCol(), playerTwo));
        }

        return startingPieces;
    }

    //take player action
    //check if player action is winning play
    //continue or end game
}
