import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

    private static final int MAX_CAPACITY = 1;

    private final List<Car> parkedCars = new ArrayList<>();

    public boolean park(Car car) {
        if (checkSlotAvailability()) {
            parkedCars.add(car);
            return true;
        }
        return false;
    }

    public boolean unpark(Car car) throws CarNotFoundException {
        if(!parkedCars.contains(car)) {
            throw new CarNotFoundException("Car not parked in the parking area");
        }
        parkedCars.remove(car);
        return true;
    }

    private boolean checkSlotAvailability() {
        return parkedCars.size() < MAX_CAPACITY;
    }
}
