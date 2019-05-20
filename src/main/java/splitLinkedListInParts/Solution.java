package splitLinkedListInParts;

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
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next.next.next.next.next = new ListNode(10);
        splitListToParts(head, 3);
    }

    public static ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] arr = new ListNode[k];
        int length = 0;
        ListNode curr = root;
        while(curr != null) {
            if(length < k) {
                arr[length] = new ListNode(curr.val);
            }
            curr = curr.next;
            length ++;
        }
        if(k == length) {
            return arr;
        }else if(k > length) {
            for(int i = 0 ; i < k - length ; i ++) {
                arr[length + i] = null;
            }
            return arr;
        }else {
            int partSize = length / k;
            int moLength = length % k;
            curr = root;
            int count = 0;
            int index = 0;
            ListNode pre = null;
            Boolean initial = true;
            Boolean countPlus = true;
            while(curr != null) {
                if(initial) {
                    arr[index] = curr;
                    pre = null;
                    countPlus = true;
                }
                if((count == partSize && moLength > 0)) {
                    moLength --;
                    count = 0 ;
                    countPlus = false;
                    index ++;
                    initial = true;
                    pre = curr;
                    curr = curr.next;
                    pre.next = null;
                }else if(count == partSize - 1 && moLength == 0) {
                    count = 0;
                    countPlus = false;
                    index ++;
                    initial = true;
                    pre = curr;
                    curr = curr.next;
                    pre.next = null;
                }else {
                    initial = false;
                    countPlus = true;
                    pre = curr;
                    curr = curr.next;
                }
                if(countPlus) {
                    count ++;
                }
            }
        }
        return arr;
    }

}
