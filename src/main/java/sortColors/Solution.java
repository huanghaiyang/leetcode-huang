package sortColors;

/**
 * created by huang 5/11/19
 */
public class Solution {

    public static void main(String[] args) {
        sortColors(new int[]{1, 0, 2});
    }

    public static int[] sortColors(int[] nums) {
        int begin = 0;
        int end = nums.length - 1;
        for(int i = 0 ; i < nums.length ; i ++) {
            if(i > end) {
                break;
            }
            if(nums[i] == 0) {
                nums[i] = nums[begin];
                nums[begin] = 0;
                begin ++;
            }else if(nums[i] == 2) {
                nums[i] = nums[end];
                nums[end] = 2;
                end --;
                i --;
            }
        }
        return nums;
    }

}
