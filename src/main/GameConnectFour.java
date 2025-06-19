package main;

import java.util.Scanner;
import main.connectFour.Board;
import main.connectFour.GameView;
import main.connectFour.Checker;

// ConnectFour

public class GameConnectFour {

    Board boardClass = new Board();
    GameView gameView = new GameView();
    Checker checker = new Checker();

    private boolean winStatus(int points) {
        boolean winState;

        if(points==4){
            winState=true;
        } else {
            winState=false;
        }

        return winState;
    }

    // Ask name
    public void Play() {

        boolean gameStatus = true;
        Scanner scanner = new Scanner(System.in);

        int playerOne = 1;
        int playerTwo = 2;
        int currentPlayer = playerOne;

        while (gameStatus) {
            int[][] board = boardClass.GetBoard();
            Checker.CheckResult checkResult;

            System.out.println("Player : "+currentPlayer+" is playing.");
            System.out.println("Possible choices :  1,2,3,4,5,6");
            gameView.displayBoard(board);

            int choice = scanner.nextInt();
            System.out.println("You selected column : "+choice);

            //TODO : Search another method to initialize selectedBoardLine
            int selectedBoardLine;
            Object[] updateResult;

            updateResult=boardClass.updateBoard(choice, currentPlayer, board);
            selectedBoardLine = (int) updateResult[0];
            board = (int[][]) updateResult[1];

            if (selectedBoardLine==-9999) {
                System.out.println("Selected number is incorrect.");
                break;
            }

            //Check wining condition
            boolean winningPlay = false;
            int winningPoints = 0;

            for(int i=0; i<=1; i++){
                switch (i) {
                    case 0:
                        checkResult=checker.checkColumn(board, choice, currentPlayer);
                        winningPlay=winStatus(checkResult.getWinningPoints());
                        board=checkResult.getBoard();
                        break;
                    case 1:
                        checkResult=checker.checkRow(board, selectedBoardLine, currentPlayer);
                        winningPlay=winStatus(checkResult.getWinningPoints());
                        board=checkResult.getBoard();
                        break;
                }
            }

            System.out.println("Board status ");
            gameView.displayBoard(board);

            //terminer la partie ou continuer
            if(winningPlay){
                gameStatus=false;
                System.out.println("End Game.");
            } else {
                if (currentPlayer == playerOne) {
                    currentPlayer = playerTwo;
                } else {
                    currentPlayer = playerOne;
                }
            }
        }
    }
}
