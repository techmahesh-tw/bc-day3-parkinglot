public class Security implements Notification {

    @Override
    public void notify(String message) {
        System.out.println(" Security : " + message);
    }
}
