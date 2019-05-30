package kClosestPointsToOrigin;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * created by huang 5/29/19
 */
public class Solution {

    public static void main(String[] args) {
        new Solution().kClosest(new int[][]{{-5, 4}, {-6, -5}, {4, 6}}, 2);
    }

    public int[][] kClosest(int[][] points, int K) {
        if(K >= points.length) {
            return points;
        }
        Comparator<Point> comparator = new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return (o2.x * o2.x + o2.y * o2.y) - (o1.x * o1.x + o1.y * o1.y);
            }
        };
        PriorityQueue<Point> pointPriorityQueue = new PriorityQueue<>(comparator);
        for(int i = 0 ; i < points.length ; i ++) {
            pointPriorityQueue.add(new Point(points[i][0], points[i][1]));
            if(pointPriorityQueue.size() > K) {
                pointPriorityQueue.poll();
            }
        }
        int[][] result = new int[K][2];
        for(int i=0;i<K;i++)
        {
            Point point=pointPriorityQueue.poll();
            result[i][0]=point.x;
            result[i][1]=point.y;
        }
        return result;
    }

    class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
