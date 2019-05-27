package pascalsTriangleII;

import java.util.ArrayList;
import java.util.List;

/**
 * created by huang 5/27/19
 */
public class Solution {

    public static void main(String[] args) {
        new Solution().getRow(4);
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for(int i = 1 ; i <= rowIndex ; i ++) {
            if(i == 1) {
                list.add(1);
            }else {
                int size = list.size();
                int step = 0;
                for(int j = 1 ; j < size ; j ++) {
                    list.add(j , list.get(j + step) + list.get(j + step - 1));
                    step ++;
                }
                for(int k = 1 ; k < step ; k ++) {
                    list.remove(list.size() - 2);
                }
            }
        }
        return list;
    }

}
