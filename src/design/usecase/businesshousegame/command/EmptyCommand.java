package design.usecase.businesshousegame.command;

import design.usecase.businesshousegame.actors.Player;

public class EmptyCommand implements ICommand{
    @Override
    public void execute(Player player) {
        // Nothing to do
    }
}
