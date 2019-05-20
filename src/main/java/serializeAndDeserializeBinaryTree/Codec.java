package serializeAndDeserializeBinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * created by huang 5/16/19
 */
public class Codec {

    public static void main(String[] args) {
        new Codec().serialize(new Codec().deserialize("[5,2,3,null,null,2,4,3,1]"));
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        List<List<TreeNode>> lists = new ArrayList<>();
        list(root, 0, lists);
        List<TreeNode> lastList = lists.get(lists.size() - 1);
        int lastLevelAllNull = 0;
        for(TreeNode node : lastList) {
            if(node == null) {
                lastLevelAllNull ++;
            }
        }
        if(lastLevelAllNull == lastList.size()) {
            lists.remove(lists.size() - 1);
        }
        for(List<TreeNode> list: lists) {
            for(TreeNode node: list) {
                append(node, sb);
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public void list(TreeNode root, int level, List<List<TreeNode>> lists) {
        if(lists.size() == level) {
            List<TreeNode> list = new ArrayList<>();
            list.add(root);
            lists.add(list);
        }else {
            List<TreeNode> list = lists.get(level);
            list.add(root);
        }
        if(root != null) {
            list(root.left, level + 1, lists);
            list(root.right, level + 1, lists);
        }
    }

    public void append(TreeNode node, StringBuilder sb) {
        if(node == null) {
            sb.append(",null");
        }else {
            sb.append(",").append(node.val);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        int level = 0;
        String[] arr = data.substring(1, data.length() - 1).split(",");
        // 处理空字符串
        if(arr[0].isEmpty()) {
            String[] rr = new String[arr.length - 1];
            for(int i = 1 ; i< arr.length ; i ++) {
                rr[i - 1] = arr[i];
            }
            arr = rr;
        }

        if(arr.length == 0) {
            return null;
        }
        int count = 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode root = null;
        TreeNode curr = null;
        for(int i = 0 ; i < arr.length ; i ++) {
            if(level == 0) {
                if(i == 0) {
                    root = new TreeNode(Integer.valueOf(arr[i]));
                    queue.add(root);
                    level ++;
                }
            }else {
                int levelSize = level * 2;
                if(curr == null && count % 2 == 0) {
                    curr = queue.poll();
                }
                if(curr != null) {
                    if(i % 2 == 0) {
                        if(!arr[i].equals("null")) {
                            TreeNode right = new TreeNode(Integer.valueOf(arr[i]));
                            curr.right = right;
                            queue.add(right);
                        }else {
                            queue.add(null);
                        }
                        curr = null;
                    }else {
                        if(!arr[i].equals("null")) {
                            TreeNode left = new TreeNode(Integer.valueOf(arr[i]));
                            curr.left = left;
                            queue.add(left);
                        }else {
                            queue.add(null);
                        }
                    }
                }
                count ++;
                if(count == levelSize) {
                    level ++;
                    count = 0;
                }
            }
        }
        return root;
    }

}
