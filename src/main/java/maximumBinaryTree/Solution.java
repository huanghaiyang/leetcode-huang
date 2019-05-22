package maximumBinaryTree;

/**
 * created by huang 5/22/19
 */
public class Solution {

    public static void main(String[] args) {

    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums, 0, nums.length - 1);
    }

    public TreeNode constructMaximumBinaryTree(int[] nums, int start, int end) {
        int max = 0;
        int maxIndex = start;
        for(int i = start ; i <= end; i ++) {
            if(max <= nums[i]) {
                max = nums[i];
                maxIndex = i;
            }
        }
        TreeNode node = new TreeNode(max);
        if(maxIndex > start) {
            node.left = constructMaximumBinaryTree(nums, start, maxIndex - 1);
        }
        if(maxIndex < end) {
            node.right = constructMaximumBinaryTree(nums, maxIndex + 1, end);
        }
        return node;
    }

}
