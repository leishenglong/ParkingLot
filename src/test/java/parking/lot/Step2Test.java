package parking.lot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import parking.lot.entity.Car;
import parking.lot.entity.Park;
import parking.lot.entity.ParkingLotKeeper;

import java.util.ArrayList;
import java.util.List;

public class Step2Test {

    private ParkingLotKeeper parkManager;

    @BeforeEach
    private void init() {
        List<Park> parkList = new ArrayList<>();
        Park park = new Park(2, "park1");
        park.parkingCar(new Car("001"));
        Park park1 = new Park(2, "park2");
        parkList.add(park);
        parkList.add(park1);
        parkManager = new ParkingLotKeeper("P1", parkList);
    }

    //step2 有个停车场管理员，他管理多个停车场，他总是把车停到第一个有空位的停车场
    //given_carandplot_when_parkingCar_then_pickupCar
    @Test
    void given_firstParkPlotIsIdle_when_parkingCar_then_parkingInTheFirstPark() {
        Car car = new Car("002");
        int i = parkManager.parkingCar(car);
        Assertions.assertNotEquals(i, -1);

        List<Park> parks = parkManager.getParks();
        Park park = parks.get(0);
        Assertions.assertEquals(park.getParkingSize(), 2);
    }

    @Test
    void given_firstParkPlotFull_when_parkingCar_then_parkingInNextIdleParkPlot() {
        Car car = new Car("002");
        Car car2 = new Car("003");

        int i = parkManager.parkingCar(car);
        Assertions.assertNotEquals(i, -1);

        List<Park> parks = parkManager.getParks();
        Park park = parks.get(1);
        Assertions.assertEquals(park.getParkingSize(), 0);
        i = parkManager.parkingCar(car2);
        Assertions.assertNotEquals(i, -1);
        Assertions.assertEquals(park.getParkingSize(), 1);
        park = parks.get(0);
        Assertions.assertEquals(park.getParkingSize(), park.size());

    }

    @Test
    void given_ParkPlotFull_when_parkingCar_then_parkingCarFailed() {
        Car car = new Car("002");
        Car car2 = new Car("003");
        Car car3 = new Car("004");
        Car car5 = new Car("005");

        int i = parkManager.parkingCar(car);
        Assertions.assertNotEquals(i, -1);
        i = parkManager.parkingCar(car2);
        Assertions.assertNotEquals(i, -1);
        i = parkManager.parkingCar(car3);
        Assertions.assertNotEquals(i, -1);
        i = parkManager.parkingCar(car5);
        Assertions.assertEquals(i, -1);

    }
}
