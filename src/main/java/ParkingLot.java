import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

    private final static int MAX_CAPACITY = 1;

    private static final List<Car> parkedCars = new ArrayList<>();
    private int currentAvailableCapacity;


    public boolean park(Car car) {
        if(checkSlotAvailability()) {
            parkedCars.add(car);
            System.out.println("parked");
            return true;
        }
        return false;
    }

    private boolean checkSlotAvailability() {
        return parkedCars.size() < MAX_CAPACITY;
    }
}
