package design.usecase.businesshousegame.model;

import design.usecase.businesshousegame.actors.Player;

public interface Cell {
    void apply(Player player);
}
