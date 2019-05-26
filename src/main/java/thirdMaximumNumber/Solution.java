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
        if (nums == null || nums.length == 0) {
            return 0;
        }

        long max = Long.MIN_VALUE, secondMax = Long.MIN_VALUE , thirdMax = Long.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i]) {
                thirdMax = secondMax;
                secondMax = max;
                max = nums[i];
                count++;
            } else if (max > nums[i]) {
                if (secondMax < nums[i]) {
                    thirdMax = secondMax;
                    secondMax = nums[i];
                    count++;
                } else if (secondMax > nums[i]) {

                    if (thirdMax < nums[i]) {
                        thirdMax = nums[i];
                        count++;
                    }
                }
            }
        }

        return (int) (count < 3 ? max : thirdMax);
    }

}
