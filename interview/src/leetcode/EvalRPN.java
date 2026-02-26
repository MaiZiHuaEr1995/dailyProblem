package leetcode;

import java.util.Stack;

public class EvalRPN {
    public static void main(String[] args) {

    }

    public int evalRP(String[] tokens) {
        Stack<String> stack = new Stack<>();
        int res ;
        int num1 = 0,num2 = 0;
        for (String token : tokens) {
            if (token.equals("+")) {
                num1 = Integer.parseInt(stack.pop());
                num2 = Integer.parseInt(stack.pop());
                res = num1 + num2;
            } else if (token.equals("-")) {
                num1 = Integer.parseInt(stack.pop());
                num2 = Integer.parseInt(stack.pop());
                res = num2 - num1;
            } else if (token.equals("*")) {
                num1 = Integer.parseInt(stack.pop());
                num2 = Integer.parseInt(stack.pop());
                res = num1 * num2;
            } else if (token.equals("/")) {
                num1 = Integer.parseInt(stack.pop());
                num2 = Integer.parseInt(stack.pop());
                res = num2 / num1;
            }  else {
               res = Integer.parseInt(token);
            }
            stack.push(String.valueOf(res));
        }
        return Integer.parseInt(stack.pop());
    }
}
