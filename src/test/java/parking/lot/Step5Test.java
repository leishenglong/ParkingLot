package parking.lot;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import parking.lot.entity.*;

import java.util.ArrayList;
import java.util.List;


public class Step5Test {

    private static AbstractManager parkManager;

    /**
     * step5 又又又有一个经理级停车管理员，他管理停车场的同时，又管理其他的停车场管理员，能把车停在自己的停车场，也能把车交给其他停车场管理员停车
     */
    @BeforeAll
    static void init() {
        parkManager = new ManagerParkingLotKeeper();
    }

    @Test
    void test() {
        Car car = new Car("111111");


    }
}
