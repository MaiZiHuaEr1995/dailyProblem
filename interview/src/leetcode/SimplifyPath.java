package leetcode;

import java.util.Stack;

// leetcode 71 ：简化路径
public class SimplifyPath {
    public static void main(String[] args) {
        String a = "/home/";
        SimplifyPath ss = new SimplifyPath();
        String s = ss.simplifyPath(a);
        System.out.println(s);
    }

    public String simplifyPath(String path) {
        // 0.保证路径不为空
        if (path == null || path.isEmpty()) {
            return path;
        }
        Stack<String> stack = new Stack<>();
        for (String s : path.split("/")) {
            if (!s.equals("..") && !s.equals(".") && !s.isEmpty()) {
                stack.push(s);
            }
            if (!stack.isEmpty() && s.equals("..")) {
                stack.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            String pop = stack.pop();
            sb.insert(0, pop);
            sb.insert(0, '/');
        }
        if (sb.length() == 0) {
            sb.append('/');
        }
        return sb.toString();
    }
}
