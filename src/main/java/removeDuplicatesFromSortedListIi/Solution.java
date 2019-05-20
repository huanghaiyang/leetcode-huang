package removeDuplicatesFromSortedListIi;

/**
 * created by huang 5/17/19
 */
public class Solution {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);
        new Solution().deleteDuplicates(head);
    }

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) {
            return head;
        }
        ListNode dummyNode = new ListNode(9999999);
        ListNode slow = dummyNode;
        ListNode pre = head;
        ListNode curr = head.next;
        while(curr != null) {
            if(pre.val == curr.val) {
                while(curr != null && pre.val == curr.val) {
                    curr = curr.next;
                }
                if(curr != null) {
                    pre = curr;
                    curr = curr.next;
                }
                continue;
            }else {
                slow.next = pre;
                slow = slow.next;
                pre = curr;
                curr = curr.next;
            }
        }
        if(pre.next != null) {
            if(pre.next.val == pre.val) {
                slow.next = null;
            }
        }else {
            slow.next = pre;
        }
        pre.next = null;
        return dummyNode.next;
    }

}
