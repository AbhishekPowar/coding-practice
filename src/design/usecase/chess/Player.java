package design.usecase.chess;

public class Player {

    private boolean isWhite;
    private boolean turn;
    private Board board;

    public Player(Board board) {
        this.board = board;
    }
    public boolean isWhite() {
        return isWhite;
    }

    public void setWhite(boolean white) {
        isWhite = white;
    }

    public boolean isTurn() {
        return turn;
    }

    public void setTurn(boolean turn) {
        this.turn = turn;
    }

    public void move() {
        System.out.println("Move");
        setTurn(false);
    }
}
