package main.checkers;

public class Piece {
    //piece position
    private int[] position;
    private int[] nextRightPosition;
    private int[] nextLeftPosition;
    private final Player player;

    Utils utils = new Utils();

    public Piece(int x, int y, Player player) {
        this.position = new int[]{x,y};
        this.player = player;
    }

    public void goTo(String direction) {
        switch (direction) {
            case "left":
                this.position = getNextLeftPosition();
                break;
            case "right":
                this.position = getNextRightPosition();
        }
    }

    //piece observation
    public Piece[] checkAround(Piece[][] board, Player defaultNullPlayer) {

        int top1, top2, right1, left1;
        int bottom1, bottom2, right2, left2;

        //TODO : To refactor
        if(this.player.getColor().equals("black")){
            Piece bottomRightState, bottomLeftState;

            bottom1 = position[0] - 1; // bottom
            right2 = position[1] + 1; // right
            bottom2 = position[0] - 1; // bottom
            left2 = position[1] - 1; // left

            bottomLeftState = utils.validatePosition(bottom1, right2, board);
            bottomRightState = utils.validatePosition(bottom2, left2, board);

            setNextLeftPosition(bottomLeftState != null ? bottomLeftState.getPosition() : null);
            setNextRightPosition(bottomRightState != null ? bottomRightState.getPosition() : null);

            return new Piece[] {bottomRightState, bottomLeftState};
        }else {
            Piece topRightState, topLeftState;

            top1 = position[0] + 1; // top
            right1 = position[1] + 1; // right
            top2 = position[0] + 1; // top
            left1 = position[1] - 1; // left

            topLeftState = utils.validatePosition(top1, right1, board);
            topRightState = utils.validatePosition(top2, left1, board);

            setNextLeftPosition(topLeftState != null ? topLeftState.getPosition() : null);
            setNextRightPosition(topRightState != null ? topRightState.getPosition() : null);

            return new Piece[] {topRightState, topLeftState};
        }
    }

    public int[] getPosition() {
        return position;
    }

    public int[] getNextRightPosition() {
        return nextRightPosition;
    }

    public void setNextRightPosition(int[] nextRightPosition) {
        this.nextRightPosition = nextRightPosition;
    }

    public int[] getNextLeftPosition() {
        return nextLeftPosition;
    }

    public void setNextLeftPosition(int[] nextLeftPosition) {
        this.nextLeftPosition = nextLeftPosition;
    }

    @Override
    public String toString() {
        return ""+player.getId();
    }

}
