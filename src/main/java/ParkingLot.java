import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ParkingLot {

    private int id;
    private int maxCapacity;

    private Set<Car> parkedCars;

    public ParkingLot() {
    }

    public ParkingLot(int id, int maxCapacity) {
        this.id = id;
        this.maxCapacity = maxCapacity;
        parkedCars = new HashSet<>();
    }

    private final List<Notification> notifications = new ArrayList<>();

    public boolean park(Car car) throws ParkingFullException {
        if (!isSlotAvailable()) {
            throw new ParkingFullException("Parking Lot full already");
        }
        parkedCars.add(car);

        // Notify the owner if parking is full
        if (parkedCars.size() == maxCapacity) {
            for (Notification observer : notifications) {
                observer.notify("Parking Lot full");
            }
        }
        return true;
    }

    public boolean unpark(Car car) throws CarNotFoundException {
        if (!parkedCars.contains(car)) {
            throw new CarNotFoundException("Car not parked in the parking area");
        }
        parkedCars.remove(car);

        // Notify the owner if the parking area is available
        if (parkedCars.size() == (maxCapacity - 1)) {
            for (Notification observer : notifications) {
                observer.notify("Parking Lot is Available");
            }
        }
        return true;
    }

    public boolean isSlotAvailable() {
        return parkedCars.size() < maxCapacity;
    }

    public void addObserver(Notification observer) {
        notifications.add(observer);
    }
}
