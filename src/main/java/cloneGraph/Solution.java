package cloneGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * created by huang 5/21/19
 */
public class Solution {

    Map<Node, Node> map = new HashMap<>();
    
    public Node cloneGraph(Node node) {
        if(map.containsKey(node)) return map.get(node);
        Node cloned = new Node(node.val, new ArrayList<>());
        map.put(node, cloned);
        for(Node neighbor: node.neighbors) {
            if(map.containsKey(neighbor)) {
                cloned.neighbors.add(map.get(neighbor));
            }else {
                cloned.neighbors.add(cloneGraph(neighbor));
            }
        }
        return cloned;
    }

}
