public class Car implements ParkingArea {

    @Override
    public boolean park() {
        System.out.println("Car is parked");
        return true;
    }
}
