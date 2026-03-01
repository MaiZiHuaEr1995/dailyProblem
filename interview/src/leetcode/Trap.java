package leetcode;

import java.util.Stack;

public class Trap {
    public static void main(String[] args) {

    }

    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            if (stack.isEmpty() || height[stack.peek()] > height[i]) {
                stack.push(i);
            } else if (height[i] == height[stack.peek()]) {
                stack.push(i);
            } else {
                int top = 0;
                while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                    top = stack.peek();
                    stack.pop();
                    if (!stack.isEmpty()) {
                        int high = Math.min(height[stack.peek()], height[i]) - height[top];
                        int low = i - stack.peek() - 1;
                        res += high * low;
                    }
                }
                stack.push(i);
            }
        }
        return res;
    }
}
