package isSubsequence;

/**
 * created by huang 5/27/19
 */
public class Solution {

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
