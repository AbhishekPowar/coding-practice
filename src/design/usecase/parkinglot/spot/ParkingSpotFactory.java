package design.usecase.parkinglot.spot;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ParkingSpotFactory {
    private static final Map<ParkingSpot.SpotType, Supplier<ParkingSpot>> objectFactory = new HashMap<>();

    static {
        objectFactory.put(ParkingSpot.SpotType.SMALL, SmallParkingSpot::new);
        objectFactory.put(ParkingSpot.SpotType.MEDIUM, MediumParkingSpot::new);
        objectFactory.put(ParkingSpot.SpotType.LARGE, LargeParkingSpot::new);
        objectFactory.put(ParkingSpot.SpotType.XLARGE, XLargeParkingSpot::new);
    }

    public static ParkingSpot getInstance(ParkingSpot.SpotType spotType) {
        if(objectFactory.containsKey(spotType))
            return objectFactory.get(spotType).get();
        throw new IllegalArgumentException("Parking Spot Type not supported!");
    }
}
