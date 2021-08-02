package parking.lot.entity;

import java.util.Comparator;
import java.util.List;

public class MiddleParkingLotKeeper extends AbstractManager {
    public MiddleParkingLotKeeper(String p1, List<Park> parkList) {
        super.name = p1;
        super.parks = parkList;
    }

    @Override
    public int parkingCar(Car car) {
        List<Park> parks = super.getParks();
        Park resut = parks.stream().max(Comparator.comparing(park -> park.getSlot().length - park.getParkingSize())).get();
        return resut.parkingCar(car);

    }

    @Override
    public int pickUpCar(Car car, int i, String name) {
        return super.pickUpCar(car, i, name);
    }
}
