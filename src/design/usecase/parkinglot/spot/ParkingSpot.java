package design.usecase.parkinglot.spot;

import design.usecase.parkinglot.vehicle.Vehicle;

import java.util.UUID;

public abstract class ParkingSpot {

    private final String _id;
    private Vehicle vehicle;
    private final SpotType type;
    private double ratePerHour;

    public enum SpotType {SMALL, MEDIUM, LARGE, XLARGE}

    public ParkingSpot(SpotType type) {
        this._id = UUID.randomUUID().toString();
        this.type = type;
    }

    public String getId() {
        return this._id;
    }

    public void assignVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public SpotType getType() {
        return type;
    }

    public void clearParkingSpace() {
        this.vehicle = null;
    }

    public abstract double getRatePerHour();

    @Override
    public String toString() {
        return "ParkingSpot{" +
                "_id='" + _id + '\'' +
                ", vehicle=" + vehicle +
                ", type=" + type +
                '}';
    }
}
