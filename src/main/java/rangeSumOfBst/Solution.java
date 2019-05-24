package rangeSumOfBst;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * created by huang 5/24/19
 */
public class Solution {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(18);
        new Solution().rangeSumBST(root, 7, 15);
    }

    public int rangeSumBST(TreeNode root, int L, int R) {
        Stack<TreeNode> stack = new Stack();
        List<Integer> list = new ArrayList<>();
        while(root != null || !stack.isEmpty()) {
            if(root == null) {
                root = stack.pop();
                list.add(root.val);
                if(root.val == R) {
                    break;
                }
                root = root.right;
            }
            if(root != null) {
                stack.push(root);
                root = root.left;
            }
        }
        System.out.println(list.size());
        int LIndex = list.indexOf(L);
        int sum = 0;
        for(int i = LIndex ; i < list.size() ; i ++) {
            sum += list.get(i);
        }
        return sum;
    }

//    public int rangeSumBST(TreeNode root, int L, int R) {
//        if (root == null) {
//            return 0;
//        }
//        if (root.val < L) {
//            return rangeSumBST(root.right, L, R);
//        }
//        if (root.val > R) {
//            return rangeSumBST(root.left, L, R);
//        }
//        return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
//    }

}
