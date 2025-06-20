package main.checkers;

public class Piece {
    //piece position
    private int[] position;
    private final Player player;

    public Piece(int x, int y, Player player) {
        this.position = new int[]{x,y};
        this.player = player;
    }

    public int[] getPosition() {
        return position;
    }

    public void setPosition(int x, int y) {
        this.position = new int[]{x,y};
    }

    public Player getPlayer() {
        return player;
    }

    //piece observation
    public Piece[] checkAround(Piece[][] board, Player defaultNullPlayer) {

        Utils utils = new Utils();
        int top1, top2, right1, left1;
        int bottom1, bottom2, right2, left2;

        if(this.player.getColor().equals("white")){
            Piece topRightState = null;
            Piece topLeftState = null;

            top1 = position[0] + 1; // top
            right1 = position[1] + 1; // right
            top2 = position[0] + 1; // top
            left1 = position[1] - 1; // left

            if (top1 >= 0 && top1 < board.length &&
                    right1 >= 0 && right1 < board[0].length) {

                topRightState = board[top1][right1];
            }

            if (top2 >= 0 && top2 < board.length &&
                    left1 >= 0 && left1 < board[0].length) {
                topLeftState = board[top2][left1];
            }

            return new Piece[] {topRightState, topLeftState};
        }else {
            Piece bottomRightState = null;
            Piece bottomLeftState = null;

            bottom1 = position[0] - 1; // bottom
            right2 = position[1] + 1; // right
            bottom2 = position[0] - 1; // bottom
            left2 = position[1] - 1; // left

            if (bottom1 >= 0 && bottom1 < board.length &&
                    right2 >= 0 && right2 < board[0].length) {
                bottomRightState = board[bottom1][right2];
            }

            if (bottom2 >= 0 && bottom2 < board.length &&
                    left2 >= 0 && left2 < board[0].length) {

                bottomLeftState = board[bottom2][left2];
            }

            return new Piece[] {bottomRightState, bottomLeftState};
        }
    }

    //piece movement
    private void goTo(int x, int y) {
        this.position = new int[] {x,y};
    }

    @Override
    public String toString() {
        return ""+player.getId();
    }

}
