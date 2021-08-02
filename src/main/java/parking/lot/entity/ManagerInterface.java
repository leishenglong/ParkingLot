package parking.lot.entity;

public interface ManagerInterface {
    int parkingCar(Car car);

    int pickUpCar(Car car, int i, String name);
}
