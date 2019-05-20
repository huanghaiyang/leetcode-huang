package reverseLinkedListII;

/**
 * created by huang 5/10/19
 */
public class Solution {

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(5);
        reverseBetween(head, 1, 2);
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode dummyNode = new ListNode(-1);
        ListNode dummyCurr = dummyNode;
        int index = 1;
        ListNode curr = head;
        ListNode prev = null;
        ListNode firstReverse = null;
        while(curr != null) {
            if(index < m) {
                dummyCurr.next = curr;
                dummyCurr = dummyCurr.next;
                curr = curr.next;
                index ++;
            }else if(index > n) {
                break;
            }else {
                if(firstReverse == null) {
                    firstReverse = curr;
                }
                ListNode nextTemp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextTemp;
                index ++;
            }
        }
        if(prev != null) {
            dummyCurr.next = prev;
        }
        if(firstReverse != null) {
            firstReverse.next = curr;
        }
        return dummyNode.next;
    }
}