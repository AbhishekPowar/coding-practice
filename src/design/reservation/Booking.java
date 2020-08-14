package design.reservation;

import java.time.LocalDateTime;
import java.util.UUID;

public class Booking {

    public enum Status{ BOOKED, CANCELED}
    private final String _id;
    private Room room;
    private Status status;
    private Slot slot;
    private LocalDateTime bookingTime;
    private LocalDateTime lastUpdatedTime;
    private boolean isModified = false;

    public Booking(Room room, Slot slot) {
        this._id = UUID.randomUUID().toString();
        this.room = room;
        this.slot = slot;
    }

    public String getId() {
        return this._id;
    }
    public void book() {
        this.room.bookSlot(slot);
        this.status = Status.BOOKED;
        this.bookingTime = LocalDateTime.now();
        this.lastUpdatedTime = LocalDateTime.now();
    }

    public Room getRoom() {
        return room;
    }

    public Slot getSlot() {
        return slot;
    }

    public void updateSlot(Slot updatedSlot) {
        this.slot = updatedSlot;
        this.lastUpdatedTime = LocalDateTime.now();
        this.isModified = true;
    }

    public LocalDateTime getBookingTime() {
        return bookingTime;
    }

    public Booking cancel() {
        this.room.clearSlot(this.slot);
        this.status = Status.CANCELED;
        this.lastUpdatedTime = LocalDateTime.now();
        this.room = null;
        return this;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "_id='" + _id + '\'' +
                ", room=" + room.getName() +
                ", status=" + status +
                ", slot=" + slot +
                ", bookingTime=" + bookingTime +
                ", lastUpdatedTime=" + lastUpdatedTime +
                ", isModified=" + isModified +
                '}';
    }
}
