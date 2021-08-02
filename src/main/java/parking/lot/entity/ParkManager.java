package parking.lot.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 停车场管理员
 */
public class ParkManager {

    private String name;
    private List<Park> parks;//管理的停车场

    private List<ParkManager> parkManager;//这个管理者管理的停车场管理员

    public ParkManager(String name) {
        this.name = name;
        parks = new ArrayList<>();
        parks.add(new Park(10));
    }

    public ParkManager(String name, List<Park> parks) {
        this.name = name;
        this.parks = parks;

    }

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

    public List<ParkManager> getParkManager() {
        return parkManager;
    }

    public void setParkManager(List<ParkManager> parkManager) {
        this.parkManager = parkManager;
    }

    @Override
    public String toString() {
        return "ParkManager{" +
                "name='" + name + '\'' +
                ", parks=" + parks +
                ", parkManager=" + parkManager +
                '}';
    }

    public void addSubManager(ParkManager parkManager) {
        if (parkManager == null) {
            System.out.println("parkManager has not been initialized！");
            return;
        }
        parkManager.addSubManager(parkManager);
    }

    public void addPark(Park park) {
        if (park == null) {
            System.out.println("park has not been initialized！");
            return;
        }
        parks.add(park);

    }


}
