package fixedPoint;

/**
 * created by huang 6/5/19
 */
public class Solution {

    public int fixedPoint(int[] A) {
        int i = 0;
        while(i < A.length ) {
            if(A[i] == i) {
                return i;
            }else {
                i ++;
            }
        }
        return -1;
    }

}
