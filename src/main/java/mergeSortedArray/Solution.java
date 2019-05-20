package mergeSortedArray;

import java.util.Arrays;

/**
 * created by huang 5/19/19
 */
public class Solution {

    public static void main(String[] args) {
        new Solution().merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i = 0 ; i < m ; i ++) {
            if(nums1[i] > nums2[0]) {
                int temp = nums1[i];
                nums1[i] = nums2[0];
                nums2[0] = temp;
                Arrays.sort(nums2);
            }
        }
        for(int i = 0 ; i < n ; i ++) {
            nums1[m + i] = nums2[i];
        }
        System.out.print(1);
    }

}
