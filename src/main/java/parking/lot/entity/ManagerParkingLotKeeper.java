package parking.lot.entity;

import java.util.List;

public class ManagerParkingLotKeeper extends AbstractManager {

    private AbstractManager manager;

    public ManagerParkingLotKeeper(AbstractManager manager) {
        this.manager = manager;
    }

    public ManagerParkingLotKeeper() {
    }

    public ManagerParkingLotKeeper(String p1, List<Park> parkList) {
        super.name = p1;
        super.parks = parkList;
    }

    @Override
    public int parkingCar(Car car) {
        int i = manager.parkingCar(car);
        if (i != -1) {
            return i;
        }
        return super.parkingCar(car);
    }

    @Override
    public int pickUpCar(Car car, int i, String name) {
        return super.pickUpCar(car, i, name);
    }

    @Override
    public String toString() {
        return "ParkManager{" +
                "name='" + name + '\'' +
                ", parks=" + parks +
                ", parkManager=" + manager +
                '}';
    }
}
