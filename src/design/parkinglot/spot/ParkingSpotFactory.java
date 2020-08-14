package design.parkinglot.spot;

public class ParkingSpotFactory {
    public static ParkingSpot getInstance(ParkingSpot.SpotType spotType) {
        switch (spotType) {
            case MEDIUM: return new MediumParkingSpot();
            case SMALL: return new SmallParkingSpot();
            case LARGE: return new LargeParkingSpot();
            case XLARGE: return new XLargeParkingSpot();
            default:
                throw new IllegalArgumentException("Invalid Spot Type");
        }
    }
}
