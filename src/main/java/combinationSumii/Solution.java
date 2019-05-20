package combinationSumii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * created by huang 5/12/19
 */
public class Solution {

    public static void main(String[] args) {
        combinationSum2(new int[]{10,1,2,7,6,1,5}, 8);
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(candidates);
        forwardTrack(candidates, target, lists, 0, new ArrayList<>());
        return lists;
    }

    public static void forwardTrack(int[] candidates, int target, List<List<Integer>> lists, int start, List<Integer> tempList) {
        if(target < 0) {
            return;
        }
        if(target == 0) {
            lists.add(new ArrayList<>(tempList));
            return;
        }
        for(int i = start ; i < candidates.length ; i ++) {
            if(target < 0) {
                break;
            }
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            tempList.add(candidates[i]);
            forwardTrack(candidates, target - candidates[i], lists, i + 1, tempList);
            tempList.remove(tempList.size() - 1);
        }
    }
}
