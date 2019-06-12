package longestContinuousIncreasingSubsequence;

/**
 * created by huang 6/12/19
 */
public class Solution {

    public static void main(String[] args) {
        new Solution().findLengthOfLCIS(new int[]{1,3,5,4,7});
    }

    public int findLengthOfLCIS(int[] nums) {
        int maxLength = 0;
        int currLength = 0;
        for(int i = 0 ; i < nums.length ; i ++) {
            if(i == 0) {
                maxLength ++;
                currLength ++;
            }else {
                if(nums[i] > nums[i - 1]) {
                    currLength ++;
                    maxLength = Math.max(maxLength, currLength);
                }else {
                    currLength = 1;
                }
            }
        }
        return maxLength;
    }

}
