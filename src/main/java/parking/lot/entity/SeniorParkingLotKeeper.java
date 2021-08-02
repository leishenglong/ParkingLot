package parking.lot.entity;

import java.util.Comparator;
import java.util.List;

public class SeniorParkingLotKeeper extends AbstractManager {

    public SeniorParkingLotKeeper(String name,List<Park> parks) {
        super.name = name;
        super.parks = parks;
    }


    @Override
    public int parkingCar(Car car) {
        List<Park> parks = super.getParks();
        Park resut = parks.stream().max(Comparator.comparing(park -> (park.getSlot().length - park.getParkingSize()) / park.getSlot().length)).get();
        return resut.parkingCar(car);
    }

    @Override
    public int pickUpCar(Car car, int i, String name) {
        return super.pickUpCar(car, i, name);
    }


}

