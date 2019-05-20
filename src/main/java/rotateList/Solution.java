package rotateList;

/**
 * created by huang 5/12/19
 */
public class Solution {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        rotateRight(head, 1);
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if(k == 0) return head;
        if(head == null) {
            return null;
        }
        if(head.next == null) {
            return head;
        }
        ListNode tail = head;
        ListNode tailPre = null;
        while(tail != null) {
            tailPre = tail;
            tail = tail.next;
        }
        tailPre.next = head;
        ListNode curr = head.next;
        ListNode pre = head;
        for(int i = 0 ; i < k ; i ++) {
            pre = curr;
            curr = curr.next;
        }
        pre.next = null;
        return curr;
    }

}
