package leetcode;

import java.util.Stack;

public class LargestRectangleArea {
    public static void main(String[] args) {

    }

    public int largestRectangleArea(int[] heights) {
        int res = 0;
        int len = heights.length;
        int[] newHeights = new int[len + 2];
        newHeights[0] = 0;
        newHeights[len + 1] = 0;
        Stack<Integer> stack = new Stack<>();
        System.arraycopy(heights, 0, newHeights, 1, len + 1 - 1);
        for (int i = 0; i < newHeights.length; i++) {
            while (!stack.isEmpty() && newHeights[stack.peek()] >= newHeights[i]) {
                int cur = stack.pop();
                int curHeight = newHeights[cur];
                int left = stack.isEmpty() ? -1 : stack.peek();
                int right = i;
                int curWidth = right - left - 1;
                res = Math.max(res, curHeight * curWidth);
            }
            stack.push(i);
        }
        return res;
    }
}
