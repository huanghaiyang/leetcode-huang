package friendCircles;

/**
 * created by huang 6/10/19
 */
public class Solution {

    public static void main(String[] args) {
        new Solution().findCircleNum(new int[][]{
            {1,1,0},
            {1,1,0},
            {0,0,1}
        });

        new Solution().findCircleNum(new int[][]{
            {1,1,0},
            {1,1,1},
            {0,1,1}
        });
    }

    public int findCircleNum(int[][] M) {
        boolean[] visited = new boolean[M.length];
        int count = 0;
        for(int i = 0 ; i < M.length ; i ++) {
            if(!visited[i]) {
                dfs(M, i, visited);
                count ++;
            }
        }
        return count;
    }

    public void dfs(int[][] M, int i, boolean[] visited) {
        for(int j = 0 ; j < M.length ; j ++) {
            if(M[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(M, j , visited);
            }
        }
    }

}
