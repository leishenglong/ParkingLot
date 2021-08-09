package parking.lot.entity;

/**
 * 停车场
 */
public class Park {

    private Car[] slot;//车位

    private String name;//停车场名字

    private int parkingSize;//已停车位数量

    public Park(int size) {
        slot = new Car[size];
    }

    /**
     * 初始化车库
     *
     * @param size
     */
    public Park(int size, String name) {
        if (size <= 0) {
            System.out.println("停车场参数size不合理！");
            return;
        }
        slot = new Car[size];
        this.name = name;
    }


    public int getParkingSize() {
        return parkingSize;
    }

    public void setParkingSize(int parkingSize) {
        this.parkingSize = parkingSize;
    }

    public Car[] getSlot() {
        return slot;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    /**
     * 车库容量
     *
     * @return
     */
    public int size() {
        if (slot == null) {
            return 0;
        }
        return slot.length;
    }

    /**
     * 停车
     *
     * @param car
     * @return
     */
    public int parkingCar(Car car) {
        if (parkingSize == slot.length) {
            System.out.println("停车场已满！");
            return -1;
        }
        for (int i = 0; i < slot.length; i++) {
            if (slot[i] == null) {
                slot[i] = car;
                parkingSize++;
                return i;
            }
        }
        return -1;
    }

    /**
     * 取车
     * @param position
     * @return
     */
    public Car movingCar(int position) {
        if (position < 0) {
            return null;
        };
        for (int i = 0; i < slot.length; i++) {
            if (position == i) {
                Car car = slot[i];
                slot[i] = null;
                parkingSize--;
                return car;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Park{" +
                ", name='" + name + '\'' +
                ", parkingSize=" + parkingSize +
                ", The number of parking Spaces left =" + (slot.length - parkingSize) +
                ", usage rate =" + (parkingSize * 100 / slot.length) + "%" +
                '}';
    }
}
