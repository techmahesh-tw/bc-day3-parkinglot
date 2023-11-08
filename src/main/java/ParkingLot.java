import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

    private final static int MAX_CAPACITY = 1;

    private List<Car> parkedCars;

    public ParkingLot() {

    }
    public ParkingLot(List<Car> parkedCars) {
        this.parkedCars = parkedCars;
    }

    public boolean park(Car car) {
        if (checkSlotAvailability()) {
            parkedCars.add(car);
            return true;
        }
        return false;
    }

    private boolean checkSlotAvailability() {
        return parkedCars.size() < MAX_CAPACITY;
    }
}
