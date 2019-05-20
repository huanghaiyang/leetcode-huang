package removeDuplicatesFromSortedList;

/**
 * created by huang 5/17/19
 */
public class Solution {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);
        new Solution().deleteDuplicates(head);
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyNode = new ListNode(-1);
        ListNode pre = dummyNode;
        ListNode curr = head;
        pre.next = curr;
        pre = pre.next;
        while(curr != null) {
            if(pre.val != curr.val) {
                pre.next = curr;
                pre = pre.next;
            }
            curr = curr.next;
        }
        pre.next = null;
        return dummyNode.next;
    }

}
