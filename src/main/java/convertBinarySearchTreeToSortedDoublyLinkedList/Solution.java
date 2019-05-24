package convertBinarySearchTreeToSortedDoublyLinkedList;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * created by huang 5/24/19
 */
public class Solution {

    public Node treeToDoublyList(Node root) {
        if(root == null) return root;
        List<Node> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        while(root != null || !stack.isEmpty()) {
            if(root == null) {
                root = stack.pop();
                list.add(root);
                root = root.right;
            }
            if(root != null) {
                stack.push(root);
                root = root.left;
            }
        }
        for(int i = 1 ; i < list.size() ; i ++) {
            Node pre = list.get(i - 1);
            Node node = list.get(i);
            node.left = pre;
            pre.right = node;
        }
        list.get(0).left = list.get(list.size() - 1);
        list.get(list.size() - 1).right = list.get(0);
        return list.get(0);
    }

}
