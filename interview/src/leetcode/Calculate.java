package leetcode;

import java.util.Stack;

public class Calculate {
    public static void main(String[] args) {

    }

    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        // 默认都是正数
        int flag = 1;
        int res = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int num = c - '0';
                while (i + 1 < length && Character.isDigit(s.charAt(i + 1))) {
                    num = num * 10 + s.charAt(i + 1) - '0';
                }
                res += num * flag;
            } else if (c == '+') {
                flag = 1;
            } else if (c == '-') {
                flag = -1;
            } else if (c == '(') {
                stack.push(res);
                res = 0;
                flag = 1;
                stack.push(flag);
            } else if (c == ')') {
                Integer flagNum = stack.peek();
                stack.pop();
                int formRes = stack.peek();
                stack.pop();
                res = formRes  + flagNum * res;
            }
        }
        return res;
    }
}
