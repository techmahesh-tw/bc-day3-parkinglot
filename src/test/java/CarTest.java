import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class CarTest {

    @Test
    void shouldParkMyCar() {
        Car car = new Car();
        Assertions.assertTrue(new ParkingLot().park(car));
    }

    @Test
    void shouldNotParkMyCarDueToUnavailability() {
        Car car = new Car();
        Assertions.assertFalse(new ParkingLot().park(car));
    }
}
