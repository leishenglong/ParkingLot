package parking.lot.entity;


import java.util.List;

public class ParkingLotKeeper extends AbstractManager  {


    public ParkingLotKeeper(String p1, List<Park> parkList) {
        super.name = p1;
        super.parks = parkList;
    }

    @Override
    public int parkingCar(Car car) {
        return super.parkingCar(car);
    }

    @Override
    public int pickUpCar(Car car, int i, String name) {
        return super.pickUpCar(car, i, name);
    }


}
