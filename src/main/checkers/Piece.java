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
    public int[] checkAround(Player player, int[][] board) {

        if(this.player.getColor().equals("white")){
            int topRightState = board[position[0]+1][position[1]+1];
            int topLeftState = board[position[0]+1][position[1]-1];

            return new int[] {topRightState, topLeftState};
        }else {
            int bottomRightState = board[position[0]-1][position[1]+1];
            int bottomLeftState = board[position[0]-1][position[1]-1];

            return new int[] {bottomRightState, bottomLeftState};
        }
    }

    //piece movement
    private void goTo(int x, int y) {
        this.position = new int[] {x,y};
    }
}
