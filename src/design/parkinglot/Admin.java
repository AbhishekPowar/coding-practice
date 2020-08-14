package design.parkinglot;

import design.parkinglot.spot.ParkingSpot;
import design.parkinglot.system.ParkingDisplayBoard;

public class Admin {

    private ParkingLot parkingLot;

    public Admin() {
        this.parkingLot = ParkingLot.getInstance();
    }

    public ParkingFloor addParkingFloor(int floorNumber) {
        ParkingFloor floor = new ParkingFloor(floorNumber);
        floor.setParkingDisplayBoard(new ParkingDisplayBoard());

        this.parkingLot.addFloor(floor);
        return floor;
    }

    public void addParkingSpot(String floorId, ParkingSpot parkingSpot) {
        this.parkingLot.addSpot(floorId, parkingSpot);
    }

    public void addParkingDisplayBoard(String floorId, ParkingDisplayBoard parkingDisplayBoard) {

    }

}
