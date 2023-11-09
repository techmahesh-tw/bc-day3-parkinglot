import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ParkingLotTest {

    @Test
    void shouldParkMyCar() throws ParkingFullException {
        Car car = new Car("123");
        Assertions.assertTrue(new ParkingLot(1, 5).park(car));
    }

    @Test
    void shouldNotParkMyCarDueToUnavailability() throws ParkingFullException {
        ParkingLot parkingLot = new ParkingLot(1, 1);
        Car car = new Car("1234");
        Assertions.assertTrue(parkingLot.park(car));

        Car secondCar = new Car("12345");
        assertThrows(ParkingFullException.class,
                () -> {
                    parkingLot.park(secondCar);
                });
    }

    @Test
    void shouldUnparkCar() throws CarNotFoundException, ParkingFullException {
        ParkingLot parkingLot = new ParkingLot(1, 1);
        Car car = new Car("123");
        Assertions.assertTrue(parkingLot.park(car));

        Assertions.assertTrue(parkingLot.unpark(car));
    }

    @Test
    void shouldThrowExceptionIfTheCarIsNotParked() {
        Car car = new Car("123");
        assertThrows(CarNotFoundException.class,
                () -> {
                    new ParkingLot(1, 0).unpark(car);
                });
    }

    @Test
    void shouldNotifyOwnerAndSecurityIfParkingFull() throws ParkingFullException {
        ParkingLot parkingLot = new ParkingLot(1, 1);
        parkingLot.addObserver(new Owner());
        parkingLot.addObserver(new Security());
        Car car = new Car("123");
        Assertions.assertTrue(parkingLot.park(car));
    }

    @Test
    void shouldNotifyOwnerAndSecurityIfParkingIsAvailable() throws CarNotFoundException, ParkingFullException {
        ParkingLot parkingLot = new ParkingLot(1, 1);
        parkingLot.addObserver(new Owner());
        parkingLot.addObserver(new Security());
        Car car = new Car("123");

        Assertions.assertTrue(parkingLot.park(car));
        Assertions.assertTrue(parkingLot.unpark(car));
    }

    @Test
    void shouldParkCarInMultipleParkingLotsViaValet() throws ParkingFullException {
        ParkingLot parkingLot1 = new ParkingLot(1, 1);
        ParkingLot parkingLot2 = new ParkingLot(2, 3);
        Set<ParkingLot> parkinglots = new HashSet<>();
        parkinglots.add(parkingLot1);
        parkinglots.add(parkingLot2);

        Valet valet = new Valet(parkinglots);
        Car car = new Car("123");
        Assertions.assertTrue(valet.park(car));
    }

    @Test
    void shouldUnParkCarInMultipleParkingLotsViaValet() throws ParkingFullException, CarNotFoundException {
        //TODO
    }
}
