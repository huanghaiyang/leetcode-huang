package findTheTownJudge;

/**
 * created by huang 5/24/19
 */
public class Solution {

    public int findJudge(int N, int[][] trust) {

        int[] a = new int[N];
        int[] b = new int[N];
        for(int i = 0 ; i < N ; i ++) {
            a[i] = 0;
            b[i] = 0;
        }
        for(int i = 0 ; i < trust.length ; i ++) {
            int t = trust[i][0];
            int k = trust[i][1];
            a[t + 1] = a[t + 1] + 1;
            b[k + 1] = b[k + 1] + 1;
        }

        int n = 0;
        for(int i = 0 ; i < a.length ; i ++) {
            if(a[i] == 0 && b[i] == N) {
                n = i + 1;
                break;
            }
        }
        return n;
    }

}
