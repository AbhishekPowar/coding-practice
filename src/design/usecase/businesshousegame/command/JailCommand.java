package design.usecase.businesshousegame.command;

import design.usecase.businesshousegame.actors.Player;

public class JailCommand implements ICommand{
    @Override
    public void execute(Player player) {
        player.payAmountToBank(150);
    }
}
