import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
}
