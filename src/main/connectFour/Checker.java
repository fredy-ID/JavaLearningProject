package main.connectFour;

public class Checker {

    /*
    public boolean checkWinningCondition() {
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

        return winningPlay;
    }
    */

    public static class CheckResult {
        private int winningPoints;
        private int[][] board;

        public CheckResult(int winningPoints, int[][] board) {
            this.winningPoints = winningPoints;
            this.board = board;
        }

        public int getWinningPoints() {
            return winningPoints;
        }

        public int[][] getBoard() {
            return board;
        }
    }

    public CheckResult checkColumn(
            int[][] board,
            int choice,
            int currentPlayer){

            int winningPoints=0;

            for (int i=0; i<board.length; i++) { // rows
                if(board[i][choice-1]==currentPlayer){
                    winningPoints++;
                    if(winningPoints==4){
                        break;
                    }
                    continue;
                }
                else {
                    winningPoints=0;
                }
            }
        return new CheckResult(winningPoints, board);
    }

    public CheckResult checkRow(
            int[][] board,
            int selectedBoardLine,
            int currentPlayer){

            int winningPoints=0;
            if(board[selectedBoardLine] != null){
                for (int i=0; i<board[selectedBoardLine].length; i++) {
                    if(board[selectedBoardLine][i]==currentPlayer){
                        winningPoints++;
                    }
                    else{
                        winningPoints=0;
                    }
                }
            }

        return new CheckResult(winningPoints, board);
    }

    /*
    public int checkToTopLeft(int[][] board, int choice, int selectedBoardLine, int currentPlayer, int winningPoints){
        for(int i=0; i<board.length; i++){
            int indexToCheck = choice - (i+1);
            int rowToCheck = selectedBoardLine - (i+1);
            if (indexToCheck >= 0 && rowToCheck >= 0) {
                if(board[rowToCheck][indexToCheck]==currentPlayer) {
                    winningPoints++;
                    if(winningPoints==4){
                        System.out.println("You won (horizontal)! ");
                        board.displayBoard(board);
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

     */

    /*
    public int checkToBottomRight(int[][] board, int choice, int selectedBoardLine, int currentPlayer, int winningPoints) {
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

     */

    public int checkToTopRight(
            int[][] board,
            int choice,
            int selectedBoardLine,
            int currentPlayer,
            int winningPoints) {



        return winningPoints;
    }

    public int checkToBottomLeft(
            int[][] board,
            int choice,
            int selectedBoardLine,
            int currentPlayer,
            int winningPoints) {

        return winningPoints;
    }

}
