package longestUnivaluePath;

/**
 * created by huang 5/23/19
 */
public class Solution {

    int max = 0;

    public int longestUnivaluePath(TreeNode root) {
        increase(root, root.val);
        return max;
    }

    public int increase(TreeNode node, int val) {
        if(node == null)  return 0;
        int leftLength = increase(node.left, node.val);
        int rightLength = increase(node.right, node.val);
        max = Math.max(max, leftLength + rightLength);
        if(node.val == val) {
            return Math.max(leftLength, rightLength) + 1;
        }
        return 0;
    }

}
