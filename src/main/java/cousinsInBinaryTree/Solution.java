package cousinsInBinaryTree;

import java.util.HashMap;
import java.util.Map;

/**
 * created by huang 5/15/19
 */
public class Solution {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        isCousins(root, 2, 3);
    }

    public static boolean isCousins(TreeNode root, int x, int y) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> parentMap = new HashMap<>();
        find(root, x, 0, map, parentMap, null);
        find(root, y, 0, map, parentMap, null);
        if(map.get(x) != map.get(y)) return false;
        if(parentMap.get(x) == parentMap.get(y)) return false;
        return true;
    }

    public static void find(TreeNode node, int num, int level, Map<Integer, Integer> map, Map<Integer, Integer> parentMap, TreeNode parentNode) {
        if(node == null) return;
        if(node.val == num)  {
            map.put(num, level);
            if(parentNode != null) {
                parentMap.put(num, parentNode.val);
            }else {
                parentMap.put(num, 0);
            }
            return;
        }
        find(node.left, num, level + 1, map, parentMap, node);
        if(!map.containsKey(num)) {
            find(node.right, num, level + 1, map, parentMap, node);
        }
    }

}
