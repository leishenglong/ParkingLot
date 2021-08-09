/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package parking.lot;

import parking.lot.entity.Car;
import parking.lot.entity.Park;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class App {
    public String getGreeting() {
        return "Hello world.";
    }


    public static void main(String[] args) throws Exception {
////        System.out.println1(new App().getGreeting());
//        int[] ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//        /**
//         * left right middle
//         * 0    10      5
//         *
//         */
//        System.out.println("index:" + new App1().binarySearch(ints, 6));
        System.out.println(1699/12);
    }

    public int binarySearch(int[] source, int target) {
        if (source == null) {
            return -1;
        }
        int rigth = source.length - 1;
        int left = 0;
        int middle = 0;
        while (left <= rigth) {
            middle = (rigth + left) / 2;
            if (target == source[middle]) {
                return middle;
            }
            if (source[middle] > target) {
                rigth = middle - 1;
            } else {

                left = middle + 1;
            }
        }
        return middle;
    }
}
