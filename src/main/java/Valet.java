import java.util.Optional;
import java.util.Set;

public class Valet {

    private Set<ParkingLot> parkingLots;

    public Valet(Set<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public boolean park(Car car) throws ParkingFullException {
        Optional<ParkingLot> parkinglot = parkingLots.stream().filter(ParkingLot::isSlotAvailable).findFirst();
        if (parkinglot.isEmpty()) {
            throw new ParkingFullException("Parking full");
        }
        return parkinglot.get().park(car);
    }

    //TODO unpark

}
