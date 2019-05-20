package removeLinkedListElements;

/**
 * created by huang 5/10/19
 */
public class Solution {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        removeElements(head, 1);
    }

    public static ListNode removeElements(ListNode head, int val) {
        ListNode curr = head;
        ListNode dymmyNode = new ListNode(-1);
        ListNode pre = dymmyNode;
        while(curr != null) {
            ListNode temp = curr.next;
            if(curr.val == val) {
                pre.next = temp;
                curr = temp;
            }else {
                pre.next = curr;
                pre = pre.next;
                curr = curr.next;
            }
        }
        return dymmyNode.next;
    }

}
