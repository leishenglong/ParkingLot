package parking.lot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import parking.lot.entity.*;

import java.util.*;

public class Step3Test {

    private AbstractManager parkManager;

    @BeforeEach
    void init() {
        List<Park> parkList = new ArrayList<>();
        Park park = new Park(10, "park1");
        park.parkingCar(new Car("001"));
        Park park1 = new Park(10, "park2");
        parkList.add(park);
        parkList.add(park1);
        parkManager = new MiddleParkingLotKeeper("P1", parkList);
    }

    //step3 又有一个中级停车场管理员，他管理多个停车场，他总是把车停在空位数量最多的停车场
    @Test
    void given_twoParkingPlots_when_firstParkHasOneCar_then_parkingInTheFirstPark() {
        Car car = new Car("002");
        parkManager.parkingCar(car);
        List<Park> parks = parkManager.getParks();
        Park park = parks.get(1);
        Assertions.assertEquals(park.getParkingSize(), 1);

    }

    @Test
    void given_twoParkingPlots_when_firstAndSecondHaveEqualCar_then_parkingInTheFirstPark() {
        Car car = new Car("002");
        int i =parkManager.parkingCar(car);
        Car car2 = new Car("002");
        i = parkManager.parkingCar(car2);

    }
}
