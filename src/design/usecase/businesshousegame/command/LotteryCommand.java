package design.usecase.businesshousegame.command;

import design.usecase.businesshousegame.actors.Player;

public class LotteryCommand implements ICommand {
    @Override
    public void execute(Player player) {
        player.collectFromBank(200);
    }
}
