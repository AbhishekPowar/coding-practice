package design.usecase.parkinglot.spot;

public class SmallParkingSpot extends ParkingSpot {

    public SmallParkingSpot() {
        super(SpotType.SMALL);
    }

    @Override
    public double getRatePerHour() {
        return 5;
    }
}
