package EvaluateReversePolishNotation;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * created by huang 5/27/19
 */
public class Solution {

    public static void main(String[] args) {
        new Solution().evalRPN(new String[] {"18"});
        new Solution().evalRPN(new String[] {"4", "13", "5", "/", "+"});
        new Solution().evalRPN(new String[] {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"});
        new Solution().evalRPN(new String[] {"-78","-33","196","+","-19","-","115","+","-","-99","/","-18","8","*","-86","-","-","16","/","26","-14","-","-","47","-","101","-","163","*","143","-","0","-","171","+","120","*","-60","+","156","/","173","/","-24","11","+","21","/","*","44","*","180","70","-40","-","*","86","132","-84","+","*","-","38","/","/","21","28","/","+","83","/","-31","156","-","+","28","/","95","-","120","+","8","*","90","-","-94","*","-73","/","-62","/","93","*","196","-","-59","+","187","-","143","/","-79","-89","+","-"});
    }

    static Set<String> operators = new HashSet<>();

    static {
        operators.add("+");
        operators.add("-");
        operators.add("*");
        operators.add("/");
    }

    public int eval(int n1, int n2, String operator) {
        switch (operator) {
            case "+":
                return n1 + n2;
            case "-":
                return n1 - n2;
            case "*":
                return n1 * n2;
            case "/":
                return n1 / n2;
            default:
                return n1;
        }
    }

    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for(String token : tokens) {
            if(operators.contains(token)) {
                int n2 = Integer.valueOf(stack.pop());
                int n1 = Integer.valueOf(stack.pop());
                stack.push(String.valueOf(eval(n1, n2, token)));
            }else {
                stack.push(token);
            }
        }
        return Integer.valueOf(stack.pop());
    }

}
