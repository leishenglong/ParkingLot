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
        int i;
        return (i = super.parkingCar(car)) == -1 ? manager.parkingCar(car) : i;
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
