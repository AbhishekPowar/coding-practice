package design.usecase.reservation;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) throws InterruptedException {

        List<Room> rooms = Arrays.asList(
                new Room("Kaveri", 4),
                new Room("Yamuna", 6),
                new Room("Ganges", 8),
                new Room("Indus", 5)
            );

        BookingSystem bookingSystem = new BookingSystem(rooms);

        LocalDateTime startTime = LocalDateTime.of(2020, 8, 21, 21, 30);
        LocalDateTime endTime = LocalDateTime.of(2020, 8, 21, 22, 30);

        int capacity = 3;
        List<Room> availability = bookingSystem.findAvailability(startTime, endTime, capacity);
        if(availability != null && !availability.isEmpty())
            bookingSystem.book(availability.get(0), startTime, endTime);

        startTime = LocalDateTime.of(2020, 8, 21, 22, 31);
        endTime = LocalDateTime.of(2020, 8, 21, 22, 45);

        availability = bookingSystem.findAvailability(startTime, endTime, null);
        if(availability != null && !availability.isEmpty())
            bookingSystem.book(availability.get(0), startTime, endTime);

        availability = bookingSystem.findAvailability(startTime, endTime, 5);
        Booking booking = bookingSystem.book(availability.get(0), startTime, endTime);
        Thread.sleep(2000);
        boolean updateAvailable = bookingSystem.isUpdateAvailable(booking, startTime, endTime);
        System.out.println("Update Available: " +updateAvailable);

        if (updateAvailable)
            bookingSystem.update(booking, startTime, endTime);
//        System.out.println(availability1);

        bookingSystem.cancel(booking);
    }
}
