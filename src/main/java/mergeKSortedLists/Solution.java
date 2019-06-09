package mergeKSortedLists;

/**
 * created by huang 6/9/19
 */
public class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        if(lists.length == 1) return lists[0];
        if(lists.length == 2) return merge(lists[0], lists[1]);
        int middleIndex = lists.length / 2;
        ListNode[] l = new ListNode[middleIndex];
        for(int i = 0 ; i < middleIndex; i ++) {
            l[i] = lists[i];
        }
        ListNode[] r = new ListNode[lists.length - middleIndex];
        for(int i = middleIndex, j = 0 ; i < lists.length; i++,j++){
            r[j] = lists[i];
        }
        return merge(mergeKLists(l), mergeKLists(r));

    }

    public ListNode merge(ListNode l, ListNode r) {
        ListNode dummyNode = new ListNode(0);
        ListNode current = dummyNode;
        while(l != null && r != null) {
            if(l.val <= r.val) {
                current.next = l;
                current = current.next;
                l = l.next;
            }else {
                current.next = r;
                current = current.next;
                r = r.next;
            }
        }
        if(l != null) {
            current.next = l;
        }
        if(r != null) {
            current.next = r;
        }
        return dummyNode.next;
    }

}
