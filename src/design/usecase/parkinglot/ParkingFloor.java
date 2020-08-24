package design.usecase.parkinglot;

import design.usecase.parkinglot.exception.ParkingFullException;
import design.usecase.parkinglot.spot.ParkingSpot;
import design.usecase.parkinglot.system.ParkingDisplayBoard;
import design.usecase.parkinglot.vehicle.Vehicle;

import java.util.*;

public class ParkingFloor {
    private final String _id;
    private final int floorNumber;

    private final Map<ParkingSpot.SpotType, Deque<ParkingSpot>> parkingSpotByType;

    private ParkingDisplayBoard parkingDisplayBoard;

    public ParkingFloor(int floorNumber) {
        this._id = UUID.randomUUID().toString();
        this.floorNumber = floorNumber;

        this.parkingSpotByType = new HashMap<>();
    }

    public String getId() {
        return this._id;
    }

    public void setParkingDisplayBoard(ParkingDisplayBoard parkingDisplayBoard) {
        this.parkingDisplayBoard = parkingDisplayBoard;
    }

    public ParkingDisplayBoard getParkingDisplayBoard() {
        return this.parkingDisplayBoard;
    }

    public ParkingSpot getParkingSpot(Vehicle vehicle) throws ParkingFullException {
//        if(vehicle instanceof Car) {
//            if(mediumSpots.size() > 0 )
//                return mediumSpots.poll();
//            if(largeSpots.size() > 0)
//                return largeSpots.poll();
//            if(xLargeSpots.size() > 0)
//                return xLargeSpots.poll();
//        }
//
//        if(vehicle instanceof Van) {
//            if(!largeSpots.isEmpty())
//                return largeSpots.poll();
//            if(!xLargeSpots.isEmpty())
//                return xLargeSpots.poll();
//        }
//        if(vehicle instanceof Truck)
//            if(!xLargeSpots.isEmpty())
//                return xLargeSpots.poll();

        throw new ParkingFullException();
    }

    public void addParkingSpot(final ParkingSpot parkingSpot) {
        this.parkingSpotByType.putIfAbsent(parkingSpot.getType(), new LinkedList<>());
        this.parkingSpotByType.get(parkingSpot.getType()).add(parkingSpot);
        // update display board
        this.parkingDisplayBoard.update(parkingSpot.getType(), this.parkingSpotByType.get(parkingSpot.getType()).size());
    }
}
