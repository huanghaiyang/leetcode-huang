package minimumIndexSumOfTwoLists;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * created by huang 5/20/19
 */
public class Solution {

    public static void main(String[] args) {
        String[] a = new Solution().findRestaurant(new String[]{"Shogun","Tapioca Express","Burger King","KFC"}, new String[]{"KFC","Burger King","Tapioca Express","Shogun"});
        System.out.print(1);
    }

    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> a_map = new HashMap<>();
        Map<String, Integer> b_map = new HashMap<>();
        int a_index = 0;
        int b_index = 0;
        Set<String> result = new HashSet<>();
        while(a_index < list1.length || b_index < list2.length) {
            if(a_index < list1.length) {
                if(b_map.containsKey(list1[a_index])) {
                    result.add(list1[a_index]);
                }
                a_map.put(list1[a_index], a_index);
                a_index ++;
            }
            if(b_index < list2.length) {
                if(a_map.containsKey(list2[b_index])) {
                    result.add(list1[b_index]);
                }
                b_map.put(list2[b_index], b_index);
                b_index ++;
            }
        }
        String[] a = new String[result.size()];
        result.toArray(a);
        return a;
    }

}
