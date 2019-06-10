package dynamicProgrammingOrGreedy;

import com.google.common.collect.Lists;

import java.util.Comparator;
import java.util.List;

/**
 * created by huang 6/10/19
 */
public class Solution {

    public static void main(String[] args) {
        new Solution().minimumTotal(Lists.newArrayList(
            Lists.newArrayList(2),
            Lists.newArrayList(3,4),
            Lists.newArrayList(6,5,7),
            Lists.newArrayList(4,1,8,3)
        ));

        new Solution().minimumTotal(Lists.newArrayList(
                Lists.newArrayList(-1),
                Lists.newArrayList(2,3),
                Lists.newArrayList(1,-1,-3)
        ));
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size() == 0) {
            return 0;
        }
        int temp = 0;
        for(int i = 0 ; i < triangle.size() - 1 ; i ++) {
            for(int j = 0 ; j < triangle.get(i).size() ; j ++) {
                int curr = triangle.get(i).get(j);
                if(j == 0) {
                    triangle.get(i + 1).set(j, triangle.get(i + 1).get(j) + curr);
                }else {
                    triangle.get(i + 1).set(j, Math.min(triangle.get(i + 1).get(j), (temp  + curr)));
                }
                temp = triangle.get(i + 1).get(j + 1);
                triangle.get(i + 1).set(j + 1, temp + curr);
            }
        }
        List<Integer> result = triangle.get(triangle.size() - 1);
        result.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        return result.get(0);
    }

}
