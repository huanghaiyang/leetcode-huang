package simplifyPath;

import java.util.LinkedList;
import java.util.Queue;

/**
 * created by huang 6/9/19
 */
public class Solution {

    public static void main(String[] args) {
        new Solution().simplifyPath("/a/../../b/../c//.//");
        new Solution().simplifyPath("/a//b////c/d//././/..");
        new Solution().simplifyPath("/.../");
    }

    public String simplifyPath(String path) {
        path = path.replaceAll("/+", "/");
        Queue<String> queue = new LinkedList<>();
        String[] arr = path.split("/");
        for(int i = 0 ; i < arr.length ; i ++) {
            String item = arr[i];
            if(!item.isEmpty()) {
                if(!".".equals(item) && !"..".equals(item)) {
                    queue.offer(item);
                }else {
                    if(item.length() >=2) {
                        if(!queue.isEmpty()) {
                            ((LinkedList<String>) queue).removeLast();
                        }
                    }
                }
            }
        }
        if(queue.isEmpty()) {
            return "/";
        }else {
            StringBuilder sb = new StringBuilder();
            while(!queue.isEmpty()) {
                sb.append("/" + queue.poll());
            }
            return sb.toString();
        }
    }

}
