package leetcode;

import java.util.Stack;

public class MaxDepth {
    public static void main(String[] args) {

    }

    class Solution {
        public int maxDepth(String s) {
            if (s == null || s.isEmpty()) {
                return 0;
            }
            int res = 0;
            int max = 0;
            for (int i = 0, len = s.length(); i < len; i++) {
                char c = s.charAt(i);
                if (c == '(') {
                    res++;
                    max = Math.max(max, res);
                }
                if (c == ')') {
                    res--;
                }
            }
            return max;
        }
    }
}
