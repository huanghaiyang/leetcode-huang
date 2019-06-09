package longestConsecutiveSequence;

import java.util.HashSet;
import java.util.Set;

/**
 * created by huang 6/9/19
 */
public class Solution {

    public static void main(String[] args) {
        new Solution().longestConsecutive(new int[]{100, 4, 200, 1, 3, 2});
    }

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num: nums) {
            set.add(num);
        }
        int result = 0;
        for(int num: set) {
            if(!set.contains(num - 1)) {
                int longest = 1;
                int preNum = num;
                while(set.contains(preNum + 1)) {
                    preNum ++;
                    longest ++;
                }
                result = Math.max(result, longest);
            }
        }
        return result;
    }

}
