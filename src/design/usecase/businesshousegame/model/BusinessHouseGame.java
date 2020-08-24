package design.usecase.businesshousegame.model;

import design.usecase.businesshousegame.actors.Player;
import design.usecase.businesshousegame.processor.CommandProcessor;

import java.util.Arrays;
import java.util.List;

public class BusinessHouseGame {

    private final String cellOrder;
    private final String diceInput;

    public BusinessHouseGame(final String cellOrder, final String diceInput) {
        this.cellOrder = cellOrder;
        this.diceInput = diceInput;
    }

    public void run() {
        Board board = new Board(cellOrder);
        List<List<Integer>> diceMoves = CommandProcessor.getDiceMoves(diceInput);

        int playerSize = diceMoves.size();
        int movesPerPlayer = diceMoves.get(0).size();

        Player[] players = new Player[playerSize];

        for (int playerNumber=0; playerNumber<players.length; playerNumber++)
            players[playerNumber] = new Player();

        for(int move=0; move < movesPerPlayer; move++) {
            for(int playerNumber=0; playerNumber < players.length; playerNumber++) {
                if(players[playerNumber].getTurnsLeft() > 0) {
                    board.move(players[playerNumber], diceMoves.get(playerNumber).get(move));
                    players[playerNumber].decrementTurn();
                }
            }
        }

        printGameResult(players);

    }

    public void printGameResult(Player[] players) {
        System.out.println("###### GAME ########");
        int curr = 1;
        for(Player player: players)
            System.out.println("Player#"+curr+++": "+ player);
    }
}
