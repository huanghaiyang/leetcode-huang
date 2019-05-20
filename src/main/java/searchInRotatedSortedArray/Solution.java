package searchInRotatedSortedArray;

/**
 * created by huang 5/13/19
 */
public class Solution {

    public static void main(String[] args) {
        search(new int[]{3, 1, 1}, 3);
    }

    public static Boolean search(int[] nums, int target) {
        Boolean s = search(nums, 0, nums.length - 1, target);
        return s;
    }

    private static Boolean search(int[] nums, int low, int high, int target) {
        if (low > high) {
            return false;
        }
        int mid = (low + high) / 2;
        if (nums[mid] == target) {
            return true;
        }
        if(nums[mid] < target) {
            if (nums[mid] <= nums[high]) {
                if (nums[mid] < target && target <= nums[high])
                    return search(nums, mid + 1, high, target);
                else
                    return search(nums, low, mid - 1, target);
            } else {
                if (nums[low] <= target && target < nums[mid])
                    return search(nums, low, mid - 1, target);
                else
                    return search(nums, mid + 1, high, target);
            }
        }else {
            return search(nums, low , mid, target) || search(nums, mid + 1, high, target);
        }
    }

}
