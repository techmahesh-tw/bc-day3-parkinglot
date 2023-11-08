import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ParkingLotTest {

    @Test
    void shouldParkMyCar() {
        Car car = new Car("123");
        Assertions.assertTrue(new ParkingLot().park(car));
    }

    @Test
    void shouldNotParkMyCarDueToUnavailability() {
        ParkingLot parkingLot = new ParkingLot();
        Assertions.assertTrue(parkingLot.park(new Car("1234")));

        Car secondCar = new Car("12345");
        Assertions.assertFalse(parkingLot.park(secondCar));
    }

    @Test
    void shouldUnparkCar() throws CarNotFoundException {
        Car car = new Car("123");
        Assertions.assertTrue(new ParkingLot().park(car));

        Assertions.assertTrue(new ParkingLot().unpark(car));
    }

    @Test
    void shouldThrowExceptionIfTheCarIsNotParked() {
        Car car = new Car("123");
        assertThrows(CarNotFoundException.class,
                ()->{
                    new ParkingLot().unpark(car);
                });
    }
}
