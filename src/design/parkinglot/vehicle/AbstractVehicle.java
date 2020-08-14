package design.parkinglot.vehicle;

import design.parkinglot.Ticket;

public abstract class AbstractVehicle implements Vehicle {

    private final String licensePlate;
    private Ticket ticket;

    public AbstractVehicle(String licensePlate) {
        this.licensePlate = licensePlate;
    }
    public String getLicensePlate() {
        return licensePlate;
    }
    public void assignTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
