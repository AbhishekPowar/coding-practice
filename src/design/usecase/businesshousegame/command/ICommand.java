package design.usecase.businesshousegame.command;

import design.usecase.businesshousegame.actors.Player;

public interface ICommand {
    void execute(Player player);
}
