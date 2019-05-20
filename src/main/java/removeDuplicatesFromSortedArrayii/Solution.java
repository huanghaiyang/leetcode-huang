package removeDuplicatesFromSortedArrayii;

/**
 * created by huang 5/11/19
 */
public class Solution {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 1, 2, 2, 3};
        removeDuplicates(arr);
    }

    public static int removeDuplicates(int[] nums) {
        int i = 0;
        for (int n : nums)
            if (i < 2 || n > nums[i-2])
                nums[i++] = n;
        return i;
    }

}
