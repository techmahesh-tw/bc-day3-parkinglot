import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

    private final int capacity;

    private static final List<Car> parkedCars = new ArrayList<>();

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public boolean park(Car car) {
        if (checkSlotAvailability()) {
            parkedCars.add(car);
            return true;
        }
        return false;
    }

    private boolean checkSlotAvailability() {
        return parkedCars.size() < capacity;
    }
}
