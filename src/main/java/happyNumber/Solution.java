package happyNumber;

import java.util.ArrayList;
import java.util.List;

class Solution {
    boolean isHappy(int n) {
        return isHappy(n, new ArrayList<>());
    }

    private boolean isHappy(int n, List<Integer> history) {
        if (history.contains(n)) return false;
        int[] arr = getNumbers((n));
        int result = 0;
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            result += arr[i] * arr[i];
        }
        if (result == 1) {
            return true;
        }
        history.add(n);
        return isHappy(result, history);
    }

    private int[] getNumbers(int n) {
        String str = String.valueOf(n);
        String[] arr = str.split("");
        int length = arr.length;
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = Integer.parseInt(arr[i]);
        }
        return result;
    }
}

class SoluteTest {
    public static void main(String[] args) {
        System.out.println(new Solution().isHappy(19));
    }
}