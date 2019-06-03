package permutationInString;

/**
 * created by huang 6/3/19
 */
public class Solution {

    public static void main(String[] args) {
        new Solution().checkInclusion("ab", "eidbaooo");
        new Solution().checkInclusion("ab", "eidboaoo");
    }

    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        if(n1 > n2) return false;
        int[] arr1 = toArr(s1);
        Boolean flag = false;
        for(int i = 0 ; i <= n2 - n1 ; i ++) {
            String s2_sub = s2.substring(i , i + n1);
            int[] arr2 = toArr(s2_sub);
            flag = checkArrEqual(arr1, arr2);
            if(flag) break;
        }
        return flag;
    }

    public int[] toArr(String str) {
        int[] arr = new int[26];
        for(int i = 0 ; i < str.length() ; i ++) {
            arr[str.charAt(i) - 'a'] += 1;
        }
        return arr;
    }

    public Boolean checkArrEqual(int[] arr1, int[] arr2) {
        for(int i = 0 ; i < arr1.length ; i ++) {
            if(arr1[i] != arr2[i]) return false;
        }
        return true;
    }

}
