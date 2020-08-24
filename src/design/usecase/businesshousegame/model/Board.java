package design.usecase.businesshousegame.model;

import design.usecase.businesshousegame.actors.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class Board {

    private static final Map<String, Supplier<Cell>> cellCodeMapping = new HashMap<>();

    static {
        cellCodeMapping.put("L", Lottery::new);
        cellCodeMapping.put("J", Jail::new);
        cellCodeMapping.put("H", Hotel::new);
        cellCodeMapping.put("E", EmptyCell::new);
    }

    List<Cell> cellList;

    public Board(String cellString) {
        cellList = prepareBoardCellsFromInput(cellString);
    }

    public void move(Player player, int stepValue) {
        int landedCellIndex = nextStepValue(player, stepValue);
        cellList.get(landedCellIndex).apply(player);
        player.setCurrentCell(landedCellIndex);
    }

    private int nextStepValue(Player player, int stepValue) {
        return (player.getCurrentCell() + stepValue) % this.cellList.size();
    }

    private List<Cell> prepareBoardCellsFromInput(String cellString) {
        String[] cellCodes = cellString.split(",");
        List<Cell> cellList = new ArrayList<>();

        for(String cellCode: cellCodes)
            cellList.add(cellCodeMapping.get(cellCode).get());
        return cellList;
    }

    public List<Cell> getBoardCells() {
        return this.cellList;
    }
}
