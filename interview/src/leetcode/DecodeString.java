package leetcode;

import java.util.Stack;

public class DecodeString {
    public static void main(String[] args) {

    }

    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> numStack = new Stack<>();
        Stack<String> strStack = new Stack<>();
        int digit = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                digit = digit * 10 + c - '0';
            } else if (Character.isLetter(c)) {
                sb.append(c);
            }  else if (c == '[') {
                numStack.push(digit);
                strStack.push(sb.toString());
                sb = new StringBuilder();
                digit = 0;
            }  else if (c == ']') {
                int pop = numStack.pop();
                StringBuilder popped = new StringBuilder(strStack.pop());
                for (int j = 0; j < pop; j++) {
                    popped.append(sb);
                }
                sb =  popped;
            }
        }
        return sb.toString();
    }
}
