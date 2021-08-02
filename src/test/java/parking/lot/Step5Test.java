package parking.lot;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import parking.lot.entity.Car;
import parking.lot.entity.Park;
import parking.lot.entity.ParkManager;

import java.util.ArrayList;
import java.util.List;


public class Step5Test {

    private static ParkManager parkManager;

    /**
     * step5 又又又有一个经理级停车管理员，他管理停车场的同时，又管理其他的停车场管理员，能把车停在自己的停车场，也能把车交给其他停车场管理员停车
     */
    @BeforeAll
    static void init() {
        parkManager = new ParkManager("经理级停车管理员");
        ParkManager parkManager1 = new ParkManager("停车场管理员1");
        List<ParkManager> parkManagerList = new ArrayList<>();
        parkManagerList.add(parkManager1);
        parkManager.setParkManager(parkManagerList);
    }

    @Test
    void test() {
        Car car = new Car("111111");
        Park park = parkManager.getParks().get(0);
        park.setName("环普停车场");
        int i1 = park.parkingCar(car);
        Assertions.assertNotEquals(i1, -1);
        Car car1 = new Car("222222");
        int i = parkManager.getParkManager().get(0).getParks().get(0).parkingCar(car1);
        Assertions.assertNotEquals(i, -1);
        /**
         * Step 6
         * 经理级停车场管理员，打印出下属停车场管理员、其所管理的停车场，以及他自己直接管理的停车场, 信息包括名字, 总车位数，空位数 和 使用率
         */
        System.out.println(parkManager.getParkManager());
        System.out.println(parkManager.getParks());

    }
}
