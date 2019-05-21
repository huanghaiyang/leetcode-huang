package copyListWithRandomPointer;

import java.util.HashMap;
import java.util.Map;

/**
 * created by huang 5/21/19
 */
public class Solution {

    Map<Node, Node> map = new HashMap<>();

    public Node copyRandomList(Node head) {
        if(head == null) return head;
        if(map.containsKey(head)) return map.get(head);
        Node node = new Node();
        node.val = head.val;
        map.put(head, node);
        if(head.next != null) {
            node.next = copyRandomList(head.next);
        }
        if(head.random != null) {
            node.random = copyRandomList(head.random);
        }
        return head;
    }

}
