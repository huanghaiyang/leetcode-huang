package lexicographicalNumbers;

import java.util.ArrayList;
import java.util.List;

/**
 * created by huang 5/24/19
 */
public class Solution {

    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>();
        for(int i = 1 ; i <= 9 ; i ++) {
            dfs(n, i, list);
        }
        return list;
    }

    public void dfs(int n, int curr, List<Integer> list) {
        if(curr > n) return;
        list.add(curr);
        for(int i = 0 ; i < 10 ; i ++) {
            dfs(n, curr * 10 + i , list);
        }
    }

}
