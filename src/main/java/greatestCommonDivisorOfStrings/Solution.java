package greatestCommonDivisorOfStrings;

import java.util.*;

/**
 * created by huang 6/2/19
 */
public class Solution {

    public static void main(String[] args) {
        new Solution().gcdOfStrings("ABCABC", "ABC");
        new Solution().gcdOfStrings("ABABAB", "ABAB");
        new Solution().gcdOfStrings("LEET", "CODE");
        new Solution().gcdOfStrings("AAAAAA", "AAA");
    }

    public String gcdOfStrings(String str1, String str2) {
        Queue<String> queue1 = gcdOfStrings(str1);
        Queue<String> queue2 = gcdOfStrings(str2);
        Boolean found = false;
        String str = "";
        while(!queue2.isEmpty() && !found) {
            str = queue2.poll();
            if(queue1.contains(str)) {
                found = true;
                break;
            }
        }
        return found? str: "";
    }

    public Queue<String> gcdOfStrings(String str2) {
        int index = str2.length();
        Queue<String> queue = new LinkedList<>();
        while(index > 0) {
            String str3 = str2.substring(0, index);
            if(check(str2, str3)) {
                queue.add(str3);
            }
            index --;
        }
        return queue;
    }

    public Boolean check(String str1, String str2) {
        Boolean flag = true;
        int lastiIndex = 0;
        for(int i = 0 ; i < str1.length() ;) {
            if(i + str2.length() <= str1.length()) {
                if(!str1.substring(i, i + str2.length()).equals(str2)) {
                    flag = false;
                    break;
                }
            }
            lastiIndex = i + str2.length();
            i = lastiIndex;
        }
        return flag && lastiIndex == str1.length();
    }

}
