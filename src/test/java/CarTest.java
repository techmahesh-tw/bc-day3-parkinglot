import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void shouldParkMyCar() {
        Assertions.assertTrue(new Car().park());
    }
}
