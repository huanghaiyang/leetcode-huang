package minimumNumberOfRefuelingStops;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * created by huang 6/12/19
 */
public class Solution {

    Comparator<Integer> comparator = new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    };

    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        Queue<Integer> queue = new PriorityQueue<>(comparator);

    }

}
