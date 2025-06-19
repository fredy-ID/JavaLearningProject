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

    private int checkToTopLeft(int[][] board, int choice, int selectedBoardLine, int currentPlayer, int winningPoints){
        for(int i=0; i<board.length; i++){
            int indexToCheck = choice - (i+1);
            int rowToCheck = selectedBoardLine - (i+1);
            if (indexToCheck >= 0 && rowToCheck >= 0) {
                if(board[rowToCheck][indexToCheck]==currentPlayer) {
                    winningPoints++;
                    if(winningPoints==4){
                        System.out.println("You won (horizontal)! ");
                        displayBoard(board);
                        break;
                    }
                }else {
                    winningPoints=0;
                    break;
                }
            } else {
                winningPoints=0;
                break;
            }
        }
        return winningPoints;
    }

    private int checkToBottomRight(int[][] board, int choice, int selectedBoardLine, int currentPlayer, int winningPoints) {
        for(int i=0; i<board.length; i++){
            int indexToCheck = choice++;
            int rowToCheck = selectedBoardLine++;
            System.out.println("rowToCheck : "+rowToCheck);
            System.out.println("indexToCheck : "+indexToCheck);
            System.out.println("board_rowToCheck_.length : "+board[rowToCheck].length);
            if (indexToCheck <= board[rowToCheck].length) {
                if(board[rowToCheck][indexToCheck]==currentPlayer) {
                    winningPoints++;
                    if(winningPoints==4){
                        System.out.println("You won (horizontal)! ");
                        displayBoard(board);
                        break;
                    }
                }else {
                    winningPoints=0;
                    break;
                }
            } else {
                winningPoints=0;
                break;
            }
        }
        return winningPoints;
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

            //TODO : Search another method to initialize selectedBoardLine
            int selectedBoardLine = -9999;

            //update board
            for (int i = board.length - 1; i >= 0; i--) { // rows
                for (int j = 0; j < board[i].length; j++) { //columns
                    if(j==choice-1 && board[i][j]==0){
                        board[i][j] = currentPlayer;
                        selectedBoardLine=i;
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

            //check column win
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
            if(board[selectedBoardLine] != null && !winningPlay){
                winningPoints=0;
                for (int i=0; i<board[selectedBoardLine].length; i++) {
                    if(board[selectedBoardLine][i]==currentPlayer){
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

            //top-left to bottom-right
            if(board[selectedBoardLine] != null && !winningPlay) {
                //to bottom-right
                winningPoints = checkToBottomRight(board, choice, selectedBoardLine, currentPlayer, winningPoints);

                if (winningPoints == 4) {
                    winningPlay = true;
                    System.out.println("You won (vertical top-left/bottom-right)! ");
                    displayBoard(board);
                }
                //token is not in the first row
                if (selectedBoardLine != 0) {
                    // to top-left
                    winningPoints = checkToTopLeft(board, choice, selectedBoardLine, currentPlayer, winningPoints);
                }
                if (winningPoints == 4) {
                    winningPlay = true;
                    System.out.println("You won (vertical top-left/bottom-right)! ");
                    displayBoard(board);
                }
            }

            //top-right to bottom-left



            // TODO: Ajouter la vérification des victoires diagonales ici (haut-gauche/bas-droite et haut-droite/bas-gauche)
            if(board[selectedBoardLine] != null && !winningPlay){
                winningPoints=0;


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
