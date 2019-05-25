package allNodesDistanceKInBinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * created by huang 5/25/19
 */
public class Solution {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(2);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(3);
        new Solution().distanceK(root, root.right.left, 3);
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> list = new ArrayList<>();
        deepFind(target, K, list, 2);

        List<TreeNode> parentList = new ArrayList<>();
        findParent(root, target, new ArrayList<>(), parentList);

        for(int i = 0 ; i < parentList.size() ; i ++) {
            TreeNode parent = parentList.get(i);
            int flag = 2;
            TreeNode preNode = null;
            if(i == 0) {
                preNode = target;
            }else {
                preNode = parentList.get(i - 1);
            }
            if(preNode == parent.left) {
                flag = 1;
            }else {
                flag = 0;
            }
            deepFind(parentList.get(i), K - i - 1, list, flag);
        }
        return list;
    }

    // 深度遍历子节点
    public void deepFind(TreeNode node, int K, List<Integer> list, int direction) {
        if(K < 0) return;
        if(node != null) {
            if(K == 0) {
                list.add(node.val);
            }else {
                Boolean isLeft = direction == 2 || direction == 0;
                Boolean isRight = direction == 2 || direction == 1;
                if(isLeft) {
                    deepFind(node.left, K -1, list, 2);
                }
                if(isRight) {
                    deepFind(node.right, K - 1, list, 2);
                }
            }
        }
    }

    // 查找parent链
    public void findParent(TreeNode node, TreeNode target, List<TreeNode> currParentList, List<TreeNode> parentList) {
        if(node == null) return;
        if(!parentList.isEmpty()) {
            return;
        }
        if(node == target) {
            parentList.addAll(currParentList);
        }
        List<TreeNode> list = new ArrayList<>();
        list.add(node);
        list.addAll(currParentList);
        findParent(node.left, target, list, parentList);
        findParent(node.right, target, list, parentList);
    }

}
