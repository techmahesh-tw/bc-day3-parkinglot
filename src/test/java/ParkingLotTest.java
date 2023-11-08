import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

class ParkingLotTest {

    @Test
    void shouldParkMyCar() {
        Car car = new Car(1);
        Assertions.assertTrue(new ParkingLot(1).park(car));
    }

    @Test
    void shouldNotParkMyCarDueToUnavailability() {
        Car secondCar = new Car(0);
        Assertions.assertFalse(new ParkingLot(0).park(secondCar));
    }
}
