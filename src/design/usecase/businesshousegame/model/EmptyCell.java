package design.usecase.businesshousegame.model;

import design.usecase.businesshousegame.actors.Player;

public class EmptyCell implements Cell{
    @Override
    public void apply(Player player) {
        // do nothing as of now
    }
}
