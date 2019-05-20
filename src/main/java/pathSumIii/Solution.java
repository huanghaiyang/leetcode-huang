package pathSumIii;

/**
 * created by huang 5/14/19
 */
public class Solution {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.right.right = new TreeNode(11);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);
        pathSum(root, 8);

//            TreeNode root = new TreeNode(1);
//            root.right = new TreeNode(2);
//            root.right.right = new TreeNode(3);
//            root.right.right.right = new TreeNode(4);
//            root.right.right.right.right = new TreeNode(5);
//            pathSum(root, 3);
    }

    public static int pathSum(TreeNode root, int sum) {
        if(root == null) {
            return 0;
        }
        int count = 0;
        count += pathSum(root, 0, count, sum);
        return count;
    }

    public static int pathSum(TreeNode root, int sum, int count, int asum) {
        if(root != null) {
            TreeNode left = root.left;
            TreeNode right = root.right;
            sum = sum + root.val;
            if(sum == asum) {
                count ++;
            }else {
                count = pathSum(left, sum, count, asum);
                count = pathSum(right, sum, count, asum);
            }
        }
        return count;
    }

}
