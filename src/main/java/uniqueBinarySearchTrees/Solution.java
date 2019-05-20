package uniqueBinarySearchTrees;

/**
 * created by huang 5/12/19
 */
public class Solution {

    public static void main(String[] args) {
        numTrees(4);
    }

    public static int numTrees(int n) {
        if(n == 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for(int i = 1 ; i <= n ; i ++) {
            for(int j = 0 ; j < i ; j ++) {
                dp[i] += dp[i - j - 1] * dp[j];
            }
        }
        return dp[n];
    }

}
