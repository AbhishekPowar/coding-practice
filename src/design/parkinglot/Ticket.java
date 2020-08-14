package design.parkinglot;

import design.parkinglot.spot.ParkingSpot;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

public class Ticket {
    private final String _id;
    private final ParkingSpot parkingSpot;
    private final LocalDateTime issuedAt;
    private double ticketAmount;

    public Ticket(ParkingSpot parkingSpot) {
        this._id = UUID.randomUUID().toString();
        this.parkingSpot = parkingSpot;
        this.issuedAt = LocalDateTime.now();
    }

    public double getTicketAmount() {
        long between = ChronoUnit.HOURS.between(LocalDateTime.now(), issuedAt);
        return between * parkingSpot.getRatePerHour();
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "_id='" + _id + '\'' +
                ", parkingSpot=" + parkingSpot +
                ", issuedAt=" + issuedAt +
                ", ticketAmount=" + ticketAmount +
                '}';
    }
}
