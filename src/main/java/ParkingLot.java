import java.util.HashSet;
import java.util.Set;

public class ParkingLot {

    private static final int MAX_CAPACITY = 1;

    private final Set<Car> parkedCars = new HashSet<>();

    public boolean park(Car car) throws ParkingFullException {
        if (!checkSlotAvailability()) {
            throw new ParkingFullException("Parking Lot full already");
        }
        parkedCars.add(car);

        // Notify the owner if parking is full
        if (parkedCars.size() == MAX_CAPACITY) {
            new Owner().notify("Parking Lot full");
        }
        return true;
    }

    public boolean unpark(Car car) throws CarNotFoundException {
        if (!parkedCars.contains(car)) {
            throw new CarNotFoundException("Car not parked in the parking area");
        }
        parkedCars.remove(car);
        return true;
    }

    private boolean checkSlotAvailability() {
        return parkedCars.size() < MAX_CAPACITY;
    }
}
