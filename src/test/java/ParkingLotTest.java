import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ParkingLotTest {

    @Test
    void shouldParkMyCar() throws ParkingFullException {
        Car car = new Car("123");
        Assertions.assertTrue(new ParkingLot().park(car));
    }

    @Test
    void shouldNotParkMyCarDueToUnavailability() throws ParkingFullException {
        ParkingLot parkingLot = new ParkingLot();
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
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car("123");
        Assertions.assertTrue(parkingLot.park(car));

        Assertions.assertTrue(parkingLot.unpark(car));
    }

    @Test
    void shouldThrowExceptionIfTheCarIsNotParked() {
        Car car = new Car("123");
        assertThrows(CarNotFoundException.class,
                () -> {
                    new ParkingLot().unpark(car);
                });
    }

    @Test
    void shouldNotifyOwnerAndSecurityIfParkingFull() throws ParkingFullException {
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.addObserver(new Owner());
        parkingLot.addObserver(new Security());
        Car car = new Car("123");
        Assertions.assertTrue(new ParkingLot().park(car));
    }
}
