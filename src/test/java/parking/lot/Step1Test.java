package parking.lot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import parking.lot.entity.Car;
import parking.lot.entity.Park;

public class Step1Test {

    //    step1 要有车, 要有停车场, 能停车, 能取车
    @Test
    void given_carandplot_when_parkingCar_then_pickupCar() throws Exception {
        Park park = new Park(10, "park1");
//        Park park1 = new Park(-1,"park1");
        Assertions.assertNotNull(park);
        Car car = new Car("111");
        Assertions.assertNotNull(car);
        int i = park.parkingCar(car);
        Assertions.assertNotEquals(i, -1);
        int i1 = park.movingCar(car, i);
        Assertions.assertNotEquals(i1, -1);

    }
}
