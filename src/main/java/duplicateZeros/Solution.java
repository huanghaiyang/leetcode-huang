package duplicateZeros;

/**
 * created by huang 6/16/19
 */
public class Solution {

    public static void main(String[] args) {
        new Solution().duplicateZeros(new int[]{1, 0, 2, 3, 0, 4, 5, 0});
        new Solution().duplicateZeros(new int[]{1, 2, 3});
    }

    public void duplicateZeros(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int item = arr[i];
            if (item == 0) {
                if (i < arr.length - 1) {
                    int preNum = arr[i + 1];
                    for (int j = i + 1; j < arr.length; j++) {
                        if (j + 1 < arr.length) {
                            int temp = arr[j + 1];
                            arr[j + 1] = preNum;
                            preNum = temp;
                        }
                    }
                    i++;
                }
                arr[i] = 0;
            }
        }
        System.out.println("done.");
    }

}
