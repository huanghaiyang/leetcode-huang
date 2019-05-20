package insertSortList;

/**
 * created by huang 5/9/19
 */
public class Solution {

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        insertionSortList(head);
    }

    public static ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = new ListNode(head.val);
        ListNode current = head.next;
        while (current != null) {
            if (current.val == 3) {
                System.out.print("");
            }
            ListNode dummyCurr = dummyNode.next;
            ListNode dummyPre = dummyNode;
            while (dummyCurr != null) {
                if (dummyCurr.val < current.val) {
                    if (dummyCurr.next == null) {
                        dummyCurr.next = new ListNode(current.val);
                        break;
                    } else {
                        dummyPre = dummyCurr;
                        dummyCurr = dummyCurr.next;
                    }
                } else {
                    dummyPre.next = new ListNode(current.val);
                    dummyPre.next.next = dummyCurr;
                    break;
                }
            }
            current = current.next;
        }
        return dummyNode.next;
    }
}
