package parking.lot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import parking.lot.entity.Car;
import parking.lot.entity.Park;
import parking.lot.entity.ParkManager;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Step4Test {

    private static ParkManager parkManager;

    @BeforeAll
    static void init() {
        List<Park> parkList = new ArrayList<>();
        Park park = new Park(10, "park1");
        park.parkingCar(new Car("001"));
        Park park1 = new Park(10, "park2");
        parkList.add(park);
        parkList.add(park1);
        parkManager = new ParkManager("P1", parkList);
    }

    //step4 又又有一个高级停车场管理员，他管理多个停车场，他总是把车停在空位率最高的停车场
    @Test
    void test() {
        Car car = new Car("002");
        List<Park> parks = parkManager.getParks();
        //count numbers of slots
        Park tmp = parks.stream().max(Comparator.comparing(park ->
                (park.getSlot().length - park.getParkingSize()) / park.getSlot().length
        )).get();
        Assertions.assertEquals(tmp.getName(), "park2");
        int i = tmp.parkingCar(car);
        Assertions.assertNotEquals(i, -1);
    }
}
