package flattenAMultilevelDoublyLinkedList;

import java.util.Stack;

/**
 * created by huang 5/14/19
 */
public class Solution {

    public Node flatten(Node head) {
        Stack<Node> stack = new Stack<>();
        Node curr = head;
        Node tail = curr;
        while(curr != null) {
            if(curr.child != null) {
                if(curr.next != null) {
                    stack.push(curr.next);
                }
                curr.next = curr.child;
                curr.next.prev = curr;
                curr.child = null;
                tail = curr;
                curr = curr.next;
            }else {
                tail = curr;
                curr = curr.next;
            }
        }
        while(!stack.isEmpty()) {
            tail.next = stack.pop();
            tail.next.prev = tail;
            Node node = tail.next;
            while(node != null) {
                if(node.child != null) {
                    if(node.next != null) {
                        stack.push(node.next);
                    }
                    node.next = node.child;
                    node.next.prev = node;
                    node.child = null;
                    tail = node;
                    node = node.next;
                }else {
                    tail = node;
                    node = node.next;
                }
            }
        }
        return head;
    }

}
