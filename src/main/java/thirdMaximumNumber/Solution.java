package thirdMaximumNumber;

import java.util.Arrays;

/**
 * created by huang 5/25/19
 */
public class Solution {

    public static void main(String[] args) {
        new Solution().thirdMax(new int[]{2,2,3,1});
    }

    public int thirdMax(int[] nums) {
        if(nums.length < 3) {
            Arrays.sort(nums);
            return nums[nums.length - 1];
        }else {
            return findKthLargest(nums, 3);
        }
    }

}
