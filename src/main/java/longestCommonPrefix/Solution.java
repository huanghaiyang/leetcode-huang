package longestCommonPrefix;

/**
 * created by huang 6/3/19
 */
public class Solution {

    public static void main(String[] args) {
        new Solution().longestCommonPrefix(new String[]{"flower","flow","flight"});
    }

    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        if(strs.length == 1) return strs[0];
        int end = 0;
        String first = strs[0];
        while(end < first.length()) {
            end ++;
            if(allMath(strs, end)) {
                continue;
            }else {
                end --;
                break;
            }
        }
        String c = first.substring(0, end);
        return c;
    }

    public Boolean allMath(String[] strs, int end) {
        String prefixer = strs[0].substring(0, end);
        Boolean flag = true;
        for(int i = 1 ; i < strs.length ; i ++) {
            if(strs[i].length() < end) {
                flag = false;
                break;
            }
            if(!strs[i].substring(0, end).equals(prefixer)) {
                flag = false;
                break;
            }
        }
        return flag;
    }

}
