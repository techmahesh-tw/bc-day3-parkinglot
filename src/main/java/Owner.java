public class Owner implements Notification {

    @Override
    public void notify(String message) {
        System.out.println(" Owner : " + message);
    }
}
