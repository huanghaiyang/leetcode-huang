package palindromeLinkedList;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * created by huang 5/17/19
 */
public class Solution {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(0);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(1);
        new Solution().isPalindrome(head);
    }

    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return false;
        Stack<ListNode> stack = new Stack<>();
        ListNode slow = head;
        ListNode fast = head;
        stack.push(slow);
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            stack.push(slow);
            fast = fast.next.next;
        }
        if(fast.next != null) {
            slow = slow.next;
        }else {
            slow = slow.next;
            stack.pop();
        }
        while(!stack.isEmpty()) {
            if(slow.val != stack.pop().val) {
                return false;
            }
            slow = slow.next;
        }
        return true;
    }

}
