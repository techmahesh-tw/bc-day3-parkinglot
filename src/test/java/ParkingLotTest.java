import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class ParkingLotTest {

    @Test
    void shouldParkMyCar() {
        Car car = new Car();
        Assertions.assertTrue(new ParkingLot(new ArrayList<>()).park(car));
    }

    @Test
    void shouldNotParkMyCarDueToUnavailability() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car());
        Car secondCar = new Car();
        Assertions.assertFalse(new ParkingLot(cars).park(secondCar));
    }
}
