package binaryTreeZigzagLevelOrderTraversal;

import java.util.ArrayList;
import java.util.List;

/**
 * created by huang 5/17/19
 */
public class Solution {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        new Solution().zigzagLevelOrder(root);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        list(root, 0, lists);
        return lists;
    }

    public void list(TreeNode root, int level, List<List<Integer>> lists) {
        if(root == null) return;
        if(lists.size() == level) {
            List<Integer> list = new ArrayList<>();
            list.add(root.val);
            lists.add(list);
        }else {
            List<Integer> list = lists.get(level);
            if(level % 2 == 1) {
                list.add(root.val);
            }else {
                List<Integer> temp = new ArrayList<>();
                temp.add(root.val);
                list.addAll(0, temp);
            }
        }
        list(root.left, level + 1, lists);
        list(root.right, level + 1, lists);
    }

}
