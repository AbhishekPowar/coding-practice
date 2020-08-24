package design.usecase.reservation;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BookingSystem {
    private List<Room> roomList;

    public BookingSystem(List<Room> roomList) {
        this.roomList = roomList;
    }

    public List<Room> findAvailability(LocalDateTime startDate, LocalDateTime endDate, Integer capacity) {
         List<Room> availableRooms = new ArrayList<>();

         for(Room room: roomList) {
             Slot slot = new Slot(startDate, endDate);
             if((capacity != null && room.getCapacity() >= capacity && room.isAvailable(slot)) || (capacity == null && room.isAvailable(slot)))
                 availableRooms.add(room);
         }
         return availableRooms;
    }

    public Booking book(Room room, LocalDateTime startTime, LocalDateTime endTime) {
        Slot slot = new Slot(startTime, endTime);

        if(!room.isAvailable(slot))
            throw new IllegalArgumentException("Slot not available");

        Booking booking = new Booking(room,slot);
        booking.book();
        System.out.println("Booking Status# "+booking);
        return booking;
    }

    public boolean isUpdateAvailable(Booking booking, LocalDateTime startTime, LocalDateTime endTime) {
        Room room = booking.getRoom();
        Slot oldSlot = booking.getSlot();
        Slot updatedSlot = Slot.of(startTime, endTime);

        room.clearSlot(oldSlot);

        if(room.isAvailable(updatedSlot))
            return true;
        room.bookSlot(oldSlot);
        return false;
    }

    public Booking cancel(Booking booking) {
        return booking.cancel();
    }

    public Booking update(Booking booking, LocalDateTime startTime, LocalDateTime endTime) {
        if(isUpdateAvailable(booking, startTime, endTime)) {
            Room room = booking.getRoom();
            Slot updatedSlot = Slot.of(startTime, endTime);
            room.clearSlot(booking.getSlot());
            room.bookSlot(updatedSlot);
            booking.updateSlot(updatedSlot);

            System.out.println("Booking Updated# "+booking);
        }
        return booking;
    }
}
