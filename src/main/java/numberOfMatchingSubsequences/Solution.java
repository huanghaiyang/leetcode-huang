package numberOfMatchingSubsequences;

import java.util.HashSet;
import java.util.Set;

/**
 * created by huang 5/27/19
 */
public class Solution {

    public int numMatchingSubseq(String S, String[] words) {
        int count = 0;
        Set<String> set = new HashSet<>();
        for(int i = 0 ; i < words.length ; i ++) {
            if(set.contains(words[i])) {
                count ++;
            }else {
                if(isSubsequence(words[i], S)) {
                    set.add(words[i]);
                    count ++;
                }
            }
        }
        return count;
    }

    public boolean isSubsequence(String s, String t) {
        if(s.isEmpty()) return true;
        int sI = 0;
        for(int i = 0 ; i < t.length() ; i ++) {
            if(t.charAt(i) == s.charAt(sI)) {
                sI ++;
                if(sI == s.length()) {
                    break;
                }
            }
        }
        return sI == s.length();
    }

}
