package convertSortedArrayToBinarySearchTree;

/**
 * created by huang 5/19/19
 */
public class Solution {

    public static void main(String[] args) {
        new Solution().sortedArrayToBST(new int[]{-10 ,-3, 0, 5, 9});
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = getNode(nums, 0 , nums.length - 1);
        return root;
    }

    public TreeNode getNode(int[] nums, int start, int end) {
        if(start == end) {
            return new TreeNode(nums[start]);
        }
        if(start < end) {
            int mid = (end + start) / 2;
            TreeNode node = new TreeNode(nums[mid]);
            node.left = getNode(nums, start, mid - 1);
            if(mid < end) {
                node.right = getNode(nums, mid + 1, end);
            }
            return node;
        }
        return null;
    }

}
