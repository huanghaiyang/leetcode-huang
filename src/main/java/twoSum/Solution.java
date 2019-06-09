package twoSum;

import java.util.HashMap;
import java.util.Map;

/**
 * created by huang 6/9/19
 */
public class Solution {

    public int[] twoSum(int[] nums, int target) {
        int[] arr = new int[0];
        Map<Integer, Integer> map = new HashMap();
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for(int j = 0 ; j < nums.length ; j ++) {
            int y = target - nums[j];
            if(map.containsKey(y) && map.get(y) != j) {
                arr = new int[]{j, map.get(y)};
            }
        }
        return arr;
    }

}
