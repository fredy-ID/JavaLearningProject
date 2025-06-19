package main;

import java.util.Scanner;
import java.util.Arrays;

// ConnectFour

public class GameConnectFour {

    private void displayBoard(int[][] board) {
        for (int i=0; i<board.length; i++) { // rows
            System.out.println(Arrays.toString(board[i]));
        }
    }

    // Ask name
    public void Play() {
        int[][] board = {
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0}
        };
        boolean gameStatus = true;
        Scanner scanner = new Scanner(System.in);

        int playerOne = 1;
        int playerTwo = 2;
        int currentPlayer = playerOne;

        while (gameStatus) {
            System.out.println("Player : "+currentPlayer+" is playing.");
            System.out.println("Possible choices :  1,2,3,4,5,6");
            displayBoard(board);

            int choice = scanner.nextInt();
            System.out.println("You selected column : "+choice);

            boolean boardUpdated = false;
            int[] selectedBoardLine = null;

            //update board
            for (int i = board.length - 1; i >= 0; i--) { // rows
                for (int j = 0; j < board[i].length; j++) { //columns
                    if(j==choice-1 && board[i][j]==0){
                        board[i][j] = currentPlayer;
                        selectedBoardLine=board[i];
                        boardUpdated = true;
                    }
                }
                //board already updated
                if (boardUpdated) {
                    break;
                }
            }

            //board status
            boolean winningPlay = false;
            int winningPoints = 0;

            //column win
            for (int i=0; i<board.length; i++) { // rows
                if(board[i][choice-1]==currentPlayer){
                    winningPoints++;
                    if(winningPoints==4){
                        winningPlay=true;
                        System.out.println("Player "+currentPlayer+" You won (column)! ");
                        displayBoard(board);
                        break;
                    }
                    continue;
                }
                else {
                    winningPoints=0;
                }
            }

            //horizontal win
            if(selectedBoardLine != null && !winningPlay){
                winningPoints=0;
                for (int i=0; i<selectedBoardLine.length; i++) {
                    if(selectedBoardLine[i]==currentPlayer){
                        winningPoints++;
                        if(winningPoints==4){
                            winningPlay=true;
                            System.out.println("You won (horizontal)! ");
                            displayBoard(board);
                            break;
                        }
                    }
                    else{
                        winningPoints=0;
                    }
                }
            }
            System.out.println("Board status ");
            displayBoard(board);

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
