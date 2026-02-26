package leetcode;

import java.util.Objects;
import java.util.Stack;

public class MinStack {
    public static void main(String[] args) {

    }

    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (!minStack.isEmpty()) {
            if (minStack.peek() >= val) {
                minStack.push(val);
            }
        } else {
            minStack.push(val);
        }
    }

    public void pop() {
        int pop = stack.pop();
        if (Objects.equals(pop, minStack.peek())) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
