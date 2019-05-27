package pascalsTriangle;

import java.util.ArrayList;
import java.util.List;

/**
 * created by huang 5/27/19
 *
 * 杨辉三角
 */
public class Solution {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>();
        int item = 1;
        for(int i = 0 ; i < numRows ; i ++) {
            List<Integer> list = new ArrayList<>();
            if(i == 0) {
                list.add(item);
            }else if(i == 1) {
                list.add(item);
                list.add(item);
            }else {
                list.add(item);
                List<Integer> preList = lists.get(i - 1);
                for(int j = 1 ; j < preList.size() ; j ++) {
                    list.add(preList.get(j) + preList.get(j - 1));
                }
                list.add(item);
            }
            lists.add(list);
        }
        return lists;
    }

}
