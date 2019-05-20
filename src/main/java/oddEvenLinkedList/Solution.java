package oddEvenLinkedList;

/**
 * created by huang 5/13/19
 */
public class Solution {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        oddEvenList(head);
    }

    public static ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode odd = head;
        ListNode even = odd.next;
        while(even != null && odd != null) {
            ListNode nextOdd = even.next;
            ListNode nextEven = nextOdd.next;
            odd.next = nextOdd;
            even.next = nextEven;
            nextOdd.next = even;
            odd = nextOdd;
            even = nextEven;
        }
        return head;
    }

}
