package design.usecase.parkinglot;

import design.usecase.parkinglot.exception.ParkingFullException;
import design.usecase.parkinglot.spot.LargeParkingSpot;
import design.usecase.parkinglot.spot.SmallParkingSpot;
import design.usecase.parkinglot.spot.XLargeParkingSpot;
import design.usecase.parkinglot.vehicle.Car;
import design.usecase.parkinglot.vehicle.Vehicle;

public class ParkingSystem {
    public static void main(String[] args) throws ParkingFullException {
        ParkingLot parkingLot = ParkingLot.getInstance();

        Admin admin = new Admin();

        ParkingFloor floor1 = admin.addParkingFloor(1);
        ParkingFloor floor2 = admin.addParkingFloor(2);

        admin.addParkingSpot(floor1.getId(), new SmallParkingSpot());
        admin.addParkingSpot(floor1.getId(), new LargeParkingSpot());
        admin.addParkingSpot(floor1.getId(), new XLargeParkingSpot());
        admin.addParkingSpot(floor2.getId(), new SmallParkingSpot());
        admin.addParkingSpot(floor2.getId(), new LargeParkingSpot());
        admin.addParkingSpot(floor2.getId(), new XLargeParkingSpot());

        Vehicle vehicle = new Car("DL123");
        Customer customer = new Customer(vehicle);

        Ticket parkingSpot = parkingLot.issueNewTicket(vehicle);

        parkingLot.removeVehicle(vehicle);
        System.out.println(parkingSpot);
    }
}
