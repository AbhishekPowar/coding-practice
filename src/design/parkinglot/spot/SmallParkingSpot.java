package design.parkinglot.spot;

import design.parkinglot.spot.ParkingSpot;

public class SmallParkingSpot extends ParkingSpot {

    public SmallParkingSpot() {
        super(SpotType.SMALL);
    }

    @Override
    public double getRatePerHour() {
        return 5;
    }
}
