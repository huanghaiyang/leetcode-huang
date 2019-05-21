package intersectionOfTwoLinkedLists;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * created by huang 5/20/19
 */
public class Solution {

    public static void main(String[] args) {

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> ASet = new HashSet<>();
        Set<ListNode> BSet = new HashSet<>();
        ListNode ACurr = headA;
        ListNode BCurr = headB;
        ASet.add(ACurr);
        BSet.add(BCurr);
        if(ASet.contains(BCurr)) return BCurr;
        while(ACurr != null || BCurr != null) {
            if(ACurr != null) {
                ListNode ANext = ACurr.next;
                if(ANext != null) {
                    if(BSet.contains(ANext)) {
                        return ANext;
                    }
                    ASet.add(ANext);
                }
                ACurr = ANext;
            }

            if(BCurr != null) {
                ListNode BNext = BCurr.next;
                if(BNext != null) {
                    if(ASet.contains(BNext)) {
                        return BNext;
                    }
                    BSet.add(BNext);
                }
                BCurr = BNext;
            }
        }
        return null;
    }

}
