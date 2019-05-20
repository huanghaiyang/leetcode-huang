package partitionList;

/**
 * created by huang 5/17/19
 */
public class Solution {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);
        new Solution().partition(head, 3);
    }

    public ListNode partition(ListNode head, int x) {
        ListNode dummyNode = new ListNode(-1);
        ListNode slow = dummyNode;
        ListNode pendingNode = new ListNode(-1);
        ListNode pending = pendingNode;
        ListNode curr = head;
        while(curr != null) {
            if(curr.val >= x) {
                pending.next = curr;
                pending = pending.next;
            }
            if(curr.val < x) {
                slow.next = curr;
                slow = slow.next;
            }
            curr = curr.next;
        }
        pending.next = null;
        slow.next = pendingNode.next;
        return dummyNode.next;
    }

}
