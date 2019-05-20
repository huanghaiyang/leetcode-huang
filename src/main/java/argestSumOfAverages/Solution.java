package argestSumOfAverages;

/**
 * created by huang 5/18/19
 */
public class Solution {

    public static void main(String[] args) {
        new Solution().largestSumOfAverages(new int[]{4, 1, 7, 5, 6, 2, 3}, 4);
    }

    class Result<Integer, Double> {
        public Integer end;
        public Double avg;
        public Result(Integer end, Double avg) {
            this.end = end;
            this.avg = avg;
        }
    }
    public double largestSumOfAverages(int[] A, int K) {
        int curr = 0;
        double count = 0;
        while(K > 0) {
            Result<Integer, Double> result = max(A, curr, A.length - K);
            curr = result.end + 1;
            count += result.avg;
            K --;
        }
        return count;
    }

    // 给定一个数组，返回最大值的end索引
    public Result max(int[] A, int start, int end) {
        if(start == end) {
            return new Result(end, Double.valueOf(A[start]));
        }
        Double sum = 0.0;
        for(int i = start ; i <= end ; i ++) {
            sum += A[i];
        }
        Double avg = sum / (end - start + 1);
        return max(new Result(end, avg), max(A, start , end - 1));
    }

    public Result max(Result<Integer, Double> A, Result<Integer, Double> B) {
        if(A.avg <= B.avg) {
            return B;
        }else {
            return A;
        }
    }

}
