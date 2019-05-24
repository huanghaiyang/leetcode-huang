package searchInABinarySearchTree;

/**
 * created by huang 5/24/19
 */
public class Solution {

//    public TreeNode searchBST(TreeNode root, int val) {
//        if(root == null) return root;
//        if(root.val == val) return root;
//        TreeNode left = searchBST(root.left, val);
//        if(left != null) return left;
//        TreeNode right = searchBST(root.right, val);
//        if(right != null) return right;
//        return null;
//    }

    public TreeNode searchBST(TreeNode root, int val) {
        if(root==null)
            return null;
        else
        {
            if(root.val==val)
                return root;
            else
            if(root.val>val)
                return searchBST(root.left,val);
            else
                return searchBST(root.right,val);
        }
    }

}
