package subsets;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * created by huang 5/10/19
 *
 * 错误解法
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = new int[]{ 9, 0, 3, 5, 7 };
        subsets(nums);
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(new ArrayList<>());
        for(int i = 0 ; i < nums.length ; i ++) {
            List<Integer> item = new ArrayList<>();
            item.add(nums[i]);
            lists.add(item);
        }
        int currentIndex = 0;
        while(currentIndex < nums.length) {
            List<List<Integer>> newLists = new ArrayList<>();
            List<Integer> firstList = new ArrayList<>();
            firstList.add(nums[currentIndex]);
            newLists.add(firstList);
            int outerIndex = currentIndex + 1;
            while(newLists.size() >= 1) {
                if(outerIndex == nums.length) {
                    break;
                }
                int innerIndex = outerIndex;
                List<List<Integer>> list = new ArrayList<>();
                for(int i = 0 ; i < newLists.size() ; i ++) {
                    for(int j = innerIndex > nums.length? nums.length - 1: innerIndex ; j < nums.length ; j ++) {
                        List<Integer> item = new ArrayList();
                        item.addAll(newLists.get(i));
                        if(!item.contains(nums[j])) {
                            item.add(nums[j]);
                            list.add(item);
                        }
                    }
                    innerIndex ++;
                }
                outerIndex ++;
                lists.addAll(list);
                newLists = list;
            }
            currentIndex ++;
        }
        return lists;
    }

}
