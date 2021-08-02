package parking.lot.entity;

import java.util.List;

public abstract class AbstractManager implements ManagerInterface {


    protected String name;
    protected List<Park> parks;//管理的停车场

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Park> getParks() {
        return parks;
    }

    public void setParks(List<Park> parks) {
        this.parks = parks;
    }

    @Override
    public int parkingCar(Car car) {
        List<Park> parks = getParks();

        if (parks == null || parks.size() == 0) {
            return -1;
        }
        for (Park park : parks) {
            if (park.getParkingSize() < park.getSlot().length) {
                return park.parkingCar(car);
            }
        }
        return -1;
    }

    @Override
    public int pickUpCar(Car car, int index, String name) {
        List<Park> parks = getParks();

        Park result = null;
        for (Park park : parks) {
            if (!park.getName().equals(name)) {
                continue;
            }
            result = park;
        }
        Car[] slot = result.getSlot();
        if (index < 0) {
            return -1;
        }
        for (int i = 0; i < slot.length; i++) {
            if (index == i) {
                slot[i] = null;
                int parkingSize = result.getParkingSize();
                result.setParkingSize(parkingSize--);
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        return "ParkManager{" +
                "name='" + name + '\'' +
                ", parks=" + parks +
                '}';
    }


}
