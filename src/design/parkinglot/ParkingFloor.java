package design.parkinglot;

import design.parkinglot.exception.ParkingFullException;
import design.parkinglot.spot.ParkingSpot;
import design.parkinglot.system.ParkingDisplayBoard;
import design.parkinglot.vehicle.Car;
import design.parkinglot.vehicle.Truck;
import design.parkinglot.vehicle.Van;
import design.parkinglot.vehicle.Vehicle;

import java.util.Deque;
import java.util.LinkedList;
import java.util.UUID;

public class ParkingFloor {
    private String _id;
    private int floorNumber;

    private Deque<ParkingSpot> smallSpots;
    private Deque<ParkingSpot> mediumSpots;
    private Deque<ParkingSpot> largeSpots;
    private Deque<ParkingSpot> xLargeSpots;

    private ParkingDisplayBoard parkingDisplayBoard;

    public ParkingFloor(int floorNumber) {
        this._id = UUID.randomUUID().toString();
        this.floorNumber = floorNumber;

        this.smallSpots = new LinkedList<>();
        this.largeSpots = new LinkedList<>();
        this.mediumSpots = new LinkedList<>();
        this.xLargeSpots = new LinkedList<>();
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
        if(vehicle instanceof Car) {
            if(mediumSpots.size() > 0 )
                return mediumSpots.poll();
            if(largeSpots.size() > 0)
                return largeSpots.poll();
            if(xLargeSpots.size() > 0)
                return xLargeSpots.poll();
        }

        if(vehicle instanceof Van) {
            if(!largeSpots.isEmpty())
                return largeSpots.poll();
            if(!xLargeSpots.isEmpty())
                return xLargeSpots.poll();
        }
        if(vehicle instanceof Truck)
            if(!xLargeSpots.isEmpty())
                return xLargeSpots.poll();

        throw new ParkingFullException();
    }
    public ParkingSpot addParkingSpot(ParkingSpot parkingSpot) {

        Deque<ParkingSpot> updated = null;
        switch (parkingSpot.getType()) {
            case SMALL: smallSpots.push(parkingSpot);
            updated = smallSpots;
            break;
            case LARGE: largeSpots.push(parkingSpot);
            updated = largeSpots;
            break;
            case MEDIUM: mediumSpots.push(parkingSpot);
            updated = mediumSpots;
            break;
            case XLARGE: xLargeSpots.push(parkingSpot);
            updated = xLargeSpots;
            break;
            default:
                throw new IllegalArgumentException("Illegal Type passed");
        }

        if(updated != null)
            this.parkingDisplayBoard.update(parkingSpot.getType(), updated.size());
        return parkingSpot;
    }
}
