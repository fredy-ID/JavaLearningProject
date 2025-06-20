package main.checkers;

import java.util.Arrays;

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

        if(this.player.getColor().equals("white")){
            Piece topRightState = utils.convertIfNull(
                    board[position[0]+1][position[1]+1],
                    position[0]+1, position[1]+1, defaultNullPlayer);

            Piece topLeftState = utils.convertIfNull(
                    board[position[0]+1][position[1]-1],
                    position[0]+1, position[1]-1, defaultNullPlayer);

            System.out.println("Pièces topRightState : " + topRightState);
            System.out.println("Pièces topLeftState : " + topLeftState);

            return new Piece[] {topRightState, topLeftState};
        }else {
            Piece bottomRightState = utils.convertIfNull(
                    board[position[0]-1][position[1]+1],
                    position[0]-1, position[1]+1, defaultNullPlayer );

            Piece bottomLeftState = utils.convertIfNull(
                    board[position[0]-1][position[1]-1],
                    position[0]-1, position[1]-1, defaultNullPlayer);

            System.out.println("Pièces bottomRightState : " + bottomRightState);
            System.out.println("Pièces bottomLeftState : " + bottomLeftState);

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
