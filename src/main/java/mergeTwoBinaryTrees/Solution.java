package mergeTwoBinaryTrees;

/**
 * created by huang 5/24/19
 */
public class Solution {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null) return null;
        TreeNode root = new TreeNode((t1 != null ? t1.val : 0) + (t2 != null ? t2.val : 0));
        root.left = mergeTrees(t1 != null? t1.left: null, t2 != null? t2.left: null);
        root.right = mergeTrees(t1 != null? t1.right: null, t2 != null? t2.right: null);
        return root;
    }

}
