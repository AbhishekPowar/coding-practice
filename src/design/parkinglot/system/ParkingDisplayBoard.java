package design.parkinglot.system;

import design.parkinglot.spot.ParkingSpot;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ParkingDisplayBoard {
    private final String _id;
    private final Map<ParkingSpot.SpotType, Integer> spotTypeMap;

    public ParkingDisplayBoard() {
        this._id = UUID.randomUUID().toString();
        this.spotTypeMap = new HashMap<>();
    }
    public void display() {
        System.out.println("####### Parking Floor Data ######");
        System.out.println("#TYPE            #AVAILABLE SPOT");
        for (Map.Entry<ParkingSpot.SpotType, Integer> entry: spotTypeMap.entrySet())
            System.out.println(entry.getKey()+"       "+entry.getValue());
        System.out.println("##################################");
    }
    public String getId() {
        return this._id;
    }
    public void update(ParkingSpot.SpotType type, int updatedSpots) {
        this.spotTypeMap.put(type, updatedSpots);
    }
}
