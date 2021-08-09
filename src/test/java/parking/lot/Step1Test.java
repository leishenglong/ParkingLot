package parking.lot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import parking.lot.entity.Car;
import parking.lot.entity.Park;

public class Step1Test {

    //    step1 要有车, 要有停车场, 能停车, 能取车
    @Test
    void given_carandplot_when_parkingCar_then_return_position() throws Exception {
        Park park = new Park(10, "park1");
        Car car = new Car("111");
        int position = park.parkingCar(car);
        Assertions.assertEquals(0,position);
    }

    @Test
    void given_carandplot_when_movingCar_then_return_parkedCar() throws Exception {
        Park park = new Park(10, "park1");
        Car car = new Car("111");

        int position = park.parkingCar(car);

        Car car1 = park.movingCar(position);

        Assertions.assertEquals(car,car1);

    }

    @Test
    void given_carandplot_when_movingNotExistedCar_then_return_Null() throws Exception {
        Park park = new Park(10, "park1");
        Car car = new Car("111");

        park.parkingCar(car);

        Car car1 = park.movingCar(-1);

        Assertions.assertNull(car1);

    }


}
