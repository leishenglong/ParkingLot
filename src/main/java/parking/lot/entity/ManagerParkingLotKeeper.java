package parking.lot.entity;

import java.util.List;

public class ManagerParkingLotKeeper extends AbstractManager {

    private AbstractManager manager;

    public AbstractManager getManager() {
        return manager;
    }

    public ManagerParkingLotKeeper() {
    }

    public void setManager(AbstractManager manager) {
        this.manager = manager;
    }

    @Override
    public int parkingCar(Car car) {
        int i = super.parkingCar(car);

        if (i != -1) {
            return i;
        }
        return manager.parkingCar(car);
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
