package zigZagConversion;

/**
 * created by huang 5/11/19
 */
public class Solution {

    public static void main(String[] args) {
        convert("PAYPALISHIRING", 3);
    }

    public static String convert(String s, int numRows) {
        int length = s.length();
        String result = "";
        String[] arr = new String[numRows];
        int index = 0;
        int maxPartLength = numRows * 2 - 2;
        int times = Math.round(length / maxPartLength);
        if(length % maxPartLength != 0) {
            times ++;
        }
        for(int i = 0 ; i< times ; i ++) {
            for(int r = 0 ; r < numRows ; r ++) {
                if(arr[r] == null) {
                    arr[r] = "";
                }
                int start = maxPartLength * index;
                int rowIndex = start + r;
                if(rowIndex < length) {
                    arr[r] += s.charAt(rowIndex);
                }
                Boolean needNext = false;
                if(r != 0 && r != numRows - 1) {
                    needNext = true;
                }
                if(needNext) {
                    int step = ((numRows - 1) - (r + 1)) * 2 + 1;
                    if(step >= 0) {
                        int nextIndex = rowIndex + step + 1;
                        if(nextIndex < length) {
                            arr[r] += s.charAt(nextIndex);
                        }
                    }
                }
            }
            index ++;
        }
        for(int i = 0 ; i < numRows; i ++) {
            result += arr[i];
        }
        return result;
    }

}
