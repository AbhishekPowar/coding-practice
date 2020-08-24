package design.usecase.parkinglot.spot;

public class LargeParkingSpot extends ParkingSpot {
    public LargeParkingSpot() {
        super(SpotType.LARGE);
    }

    @Override
    public double getRatePerHour() {
        return 10;
    }
}
