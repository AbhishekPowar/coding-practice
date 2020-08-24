package design.usecase.businesshousegame.model;

import design.usecase.businesshousegame.actors.Player;

public class Jail implements Cell {
    @Override
    public void apply(Player player) {
        player.payAmountToBank(150);
    }
}
