package design.usecase.businesshousegame;

import design.usecase.businesshousegame.model.BusinessHouseGame;

public class GameSimulation {

    public static void main(String[] args) {
        String cellOrder = "J,H,L,H,E,L,H,L,H,J";
        String movesList = "2,2,1, 4,4,2, 4,4,2, 2,2,1, 4,4,2, 4,4,2, 2,2,1";

        BusinessHouseGame businessHouseGame = new BusinessHouseGame(cellOrder, movesList);
        businessHouseGame.run();

        cellOrder = "J,H,L,H,E,L,H,L,H,J";
        movesList = "2,2,1, 4,2,3, 4,1,3, 2,2,7, 4,7,2, 4,4,2, 2,2,2";
        businessHouseGame = new BusinessHouseGame(cellOrder, movesList);
        businessHouseGame.run();
    }
}
