package design.parkinglot.spot;

public class XLargeParkingSpot extends ParkingSpot {
    public XLargeParkingSpot() {
        super(SpotType.XLARGE);
    }

    @Override
    public double getRatePerHour() {
        return 15;
    }
}
