package design.usecase.businesshousegame.model;

import design.usecase.businesshousegame.actors.Bank;
import design.usecase.businesshousegame.actors.Player;

public class Lottery implements Cell {
    @Override
    public void apply(Player player) {
        Bank.getInstance().pay(player, 200);
    }
}
