package maximumSubarray;

/**
 * created by huang 5/25/19
 */
public class Solution {

    public static void main(String[] args) {
        new Solution().maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
    }

    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0)
                sum += num;
            else
                sum = num;
            res = Math.max(res, sum);
        }
        return res;
    }

//    public int maxSubArray(int[] nums) {
//        if(nums.length == 1) return nums[0];
//        int max = nums[0];
//        for(int i = 0 ; i < nums.length ; i ++) {
//            max = Math.max(max, max(nums, i));
//        }
//        return max;
//    }
//
//    public int max(int[] nums, int start) {
//        int max = nums[start];
//        int result = nums[start];
//        for(int i = start + 1 ; i < nums.length ; i ++) {
//            result = result + nums[i];
//            max = Math.max(max, result);
//        }
//        return max;
//    }

}
