package design.parkinglot;

import design.parkinglot.exception.ParkingFullException;
import design.parkinglot.spot.ParkingSpot;
import design.parkinglot.vehicle.Vehicle;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    private final Map<String, ParkingFloor> floorMap;
    private final Map<String, ParkingSpot> runningParkingMap;
    private final Map<String, String> parkingSpotFloorMap;

    private static ParkingLot _instance = null;

    public static ParkingLot getInstance() {
        if(_instance == null)
            _instance = new ParkingLot();
        return _instance;
    }
    private ParkingLot() {
        this.floorMap = new HashMap<>();
        this.runningParkingMap = new HashMap<>();
        this.parkingSpotFloorMap = new HashMap<>();
    }

    public void addFloor(ParkingFloor parkingFloor) {
        floorMap.putIfAbsent(parkingFloor.getId(), parkingFloor);
    }

    public void addSpot(String floorId, ParkingSpot parkingSpot) {
        if(floorMap.containsKey(floorId)) {
            floorMap.get(floorId).addParkingSpot(parkingSpot);
            parkingSpotFloorMap.put(parkingSpot.getId(), floorId);
        }
    }

    public void removeFloor(ParkingFloor parkingFloor) {
        floorMap.remove(parkingFloor.getId());
    }

    public ParkingSpot removeVehicle(Vehicle vehicle) {
        ParkingSpot parkingSpot = runningParkingMap.remove(vehicle.getLicensePlate());
        parkingSpot.clearParkingSpace();
        floorMap.get(parkingSpotFloorMap.get(parkingSpot.getId())).addParkingSpot(parkingSpot);
        return parkingSpot;
    }

    public Ticket issueNewTicket(Vehicle vehicle) throws ParkingFullException {
        ParkingSpot spot = findFirstAvailableSpot(vehicle);
        spot.assignVehicle(vehicle);
        Ticket ticket = new Ticket(spot);
        return ticket;
    }
    private ParkingSpot findFirstAvailableSpot(Vehicle vehicle) throws ParkingFullException {
        for (Map.Entry<String, ParkingFloor> entry: floorMap.entrySet()) {
            ParkingSpot parkingSpot = entry.getValue().getParkingSpot(vehicle);
            if( parkingSpot != null)
                return parkingSpot;
        }
        return null;
    }
}
