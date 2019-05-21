package verticalOrderTraversalOfABinaryTree;

import java.util.*;

/**
 * created by huang 5/21/19
 *
 * 垂序遍历的特点是x坐标相同
 */
public class Solution {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        new Solution().verticalTraversal(root);
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Stack<Coord> stack = new Stack<>();
        List<Coord> list = new ArrayList<>();
        Coord CoordRoot = new Coord(root.val, 0, 0, root.left, root.right);
        while(CoordRoot != null || !stack.isEmpty()) {
            if(CoordRoot == null) {
                CoordRoot = stack.pop();
            }
            if(CoordRoot.right != null) {
                Coord coordRight = new Coord(CoordRoot.right.val, CoordRoot.x + 1, CoordRoot.y - 1, CoordRoot.right.left, CoordRoot.right.right);
                stack.push(coordRight);
            }
            list.add(CoordRoot);
            Coord coordLeft = null;
            if(CoordRoot.left != null) {
                coordLeft = new Coord(CoordRoot.left.val, CoordRoot.x - 1, CoordRoot.y - 1, CoordRoot.left.left, CoordRoot.left.right);
            }
            CoordRoot = coordLeft;
        }
        Comparator coordComparator = new Comparator<Coord>() {
            @Override
            public int compare(Coord o1, Coord o2) {
                if (o1.y != o2.y)
                    return Integer.compare(o2.y, o1.y);
                else
                    return Integer.compare(o1.val, o2.val);
            }
        };
        Map<Integer, List<Coord>> map = new TreeMap<>();
        for(Coord coord: list) {
            if(map.containsKey(coord.x)) {
                map.get(coord.x).add(coord);
                map.get(coord.x).sort(coordComparator);
            }else {
                List<Coord> v = new ArrayList<>();
                v.add(coord);
                map.put(coord.x, v);
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        for(List<Coord> val: map.values()) {
            List<Integer> l = new ArrayList<>(val.size());
            for(Coord c: val) {
                l.add(c.val);
            }
            result.add(l);
        }
        return result;
    }

}
