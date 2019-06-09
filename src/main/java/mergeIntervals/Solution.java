package mergeIntervals;

import java.util.Comparator;
import java.util.LinkedList;

/**
 * created by huang 6/9/19
 */
public class Solution {

    public static void main(String[] args) {
        new Solution().merge(new int[][]{{1,3},{2,6},{8,10},{15,18}});
    }

    class Interval{
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    Comparator<Interval> intervalComparator = new Comparator<Interval>() {
        @Override
        public int compare(Interval o1, Interval o2) {
            if(o1.start != o2.start) {
                return o1.start - o2.start;
            }else {
                return o1.end - o2.end;
            }
        }
    };

    public int[][] merge(int[][] intervals) {
        LinkedList<Interval> arrayList = new LinkedList<>();
        for(int i = 0 ; i < intervals.length ; i ++) {
            arrayList.add(new Interval(intervals[i][0], intervals[i][1]));
        }
        arrayList.sort(intervalComparator);
        LinkedList<Interval> linkedList = new LinkedList<>();
        for(Interval interval: arrayList) {
            if(linkedList.isEmpty() || linkedList.getLast().end < interval.start) {
                linkedList.add(interval);
            }else {
                linkedList.getLast().end =  Math.max(linkedList.getLast().end, interval.end);
            }
        }
        int[][] result = new int[linkedList.size()][2];
        for(int i = 0 ; i < linkedList.size() ; i ++) {
            result[i][0] = linkedList.get(i).start;
            result[i][1] = linkedList.get(i).end;
        }
        return result;
    }

}
