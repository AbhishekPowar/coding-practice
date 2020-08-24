package design.usecase.parkinglot.spot;

public class MediumParkingSpot extends ParkingSpot {
    public MediumParkingSpot() {
        super(SpotType.MEDIUM);
    }

    @Override
    public double getRatePerHour() {
        return 8;
    }
}
