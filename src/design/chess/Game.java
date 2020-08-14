package design.chess;

public class Game {

    Board board;
    Player[] players;
    int turn;

    public Game() {
        this.board = new Board();
        System.out.println(board);
        players = new Player[] {new Player(this.board), new Player(this.board)};

        players[0].setWhite(true);
        players[0].setTurn(true);

        this.turn = 0;
    }

    public Player getTurn() {
        return players[this.turn];
    }

    public void start() {
        this.players[this.turn].move();
        this.turn ^= 1;
        players[this.turn].setTurn(true);
    }
}
