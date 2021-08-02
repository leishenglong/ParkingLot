package parking.lot;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import parking.lot.entity.*;

import java.util.ArrayList;
import java.util.List;


public class Step5Test {

    private  ManagerParkingLotKeeper parkManager;

    /**
     * step5 又又又有一个经理级停车管理员，他管理停车场的同时，又管理其他的停车场管理员，能把车停在自己的停车场，也能把车交给其他停车场管理员停车
     */
    @BeforeEach
     void init() {
        parkManager = new ManagerParkingLotKeeper();
        List<Park> parkList = new ArrayList<>();
        Park park = new Park(1, "park1");
        park.parkingCar(new Car("001"));
        Park park1 = new Park(1, "park2");
        parkList.add(park);
        parkList.add(park1);
        parkManager.setParks(parkList);
        parkManager.setName("Manager Parking");

         parkList = new ArrayList<>();
         park = new Park(2, "park1");
         parkList.add(park);
        ParkingLotKeeper parkingLotKeeper = new ParkingLotKeeper("p1",parkList);
        parkManager.setManager(parkingLotKeeper);

    }

    @Test
    void given_ManagerParkingHasParksAndManageOthersParkingManagers_when_parkingCar_then_parkingCarInHisOwnPark() {
        Car car = new Car("111111");
        parkManager.parkingCar(car);
        List<Park> parks = parkManager.getParks();
        Park park = parks.get(0);
        Assertions.assertEquals(park.size(),park.getParkingSize());
    }

    @Test
    void given_ManagerParkingHasParksAndManageOthersParkingManagers_when_HisParkFull_then_parkingotherPersonPark() {
        Car car = new Car("111111");
        Car car1 = new Car("111112");
        parkManager.parkingCar(car);
        parkManager.parkingCar(car1);


        AbstractManager manager = parkManager.getManager();
        List<Park> parks = manager.getParks();
        Park park = parks.get(0);
        Assertions.assertEquals(park.getName(),"park1");
        Assertions.assertEquals(park.getParkingSize(),1);
        Car[] slot = park.getSlot();
        Assertions.assertEquals(slot[0].getCarNum(),car1.getCarNum());

        System.out.println(parkManager);

    }
}
