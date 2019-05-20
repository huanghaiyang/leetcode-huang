package removeNthNodeFromEndOfList;

/**
 * created by huang 5/11/19
 */
public class Solution {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        removeNthFromEnd(head, 2);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode dummyNode = new ListNode(-1);
        ListNode pre = dummyNode;
        int count = 0;
        while(fast != null && count < n - 1) {
            fast = fast.next;
            count ++;
        }
        if(fast == null) {
            return head.next;
        }
        while(fast.next != null) {
            pre.next = slow;
            pre = pre.next;
            slow = slow.next;
            fast = fast.next;
        }
        pre.next = slow.next;
        return dummyNode.next;
    }

}
