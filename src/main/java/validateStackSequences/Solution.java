package validateStackSequences;

import java.util.Stack;

/**
 * created by huang 5/26/19
 */
public class Solution {

    public static void main(String[] args) {
        new Solution().validateStackSequences(new int[]{1,2,3,4,5}, new int[]{4,3,5,1,2});
    }

    // 判断堆栈是否为空即可
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int popIndex = 0;
        int pushIndex = 0;
        while(pushIndex < pushed.length) {
            stack.push(pushed[pushIndex]);
            pushIndex ++;
            while(!stack.isEmpty() && stack.peek() == popped[popIndex] && popIndex < popped.length) {
                popIndex ++;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

}
