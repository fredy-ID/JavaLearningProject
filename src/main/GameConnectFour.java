package main;

/*
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

        int[][] board = boardClass.getBoard();
        gameView.displayBoard(board);

        while (gameStatus) {
            Checker.CheckResult checkResult;

            System.out.println("Player : "+currentPlayer+" is playing.");
            System.out.println("Possible choices :  1,2,3,4,5,6");


            int choice = scanner.nextInt();
            System.out.println("You selected column : "+choice);

            //TODO : Search another method to initialize selectedBoardLine
            int selectedBoardLine;
            Object[] updateResult;

            updateResult=boardClass.updateBoard(choice, currentPlayer);
            selectedBoardLine = (int) updateResult[0];
            board = (int[][]) updateResult[1];

            //System.out.println("Board 1 : "+ Arrays.deepToString(board));



            if (selectedBoardLine==-9999) {
                System.out.println("Selected number is incorrect.");
                break;
            }

            System.out.println("Coin dropped to row : "+selectedBoardLine+ " column "+choice);

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

            checkResult=checker.checkColumn(board, choice, currentPlayer);
            winningPlay=winStatus(checkResult.getWinningPoints());
            board=checkResult.getBoard();

            checkResult=checker.checkRow(board, selectedBoardLine, currentPlayer);
            winningPlay=winStatus(checkResult.getWinningPoints());
            board=checkResult.getBoard();

            System.out.println("winningPlay 3 : "+winningPlay);

            System.out.println("Board status : ");
            gameView.displayBoard(board);

            //continue or end game
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


 */