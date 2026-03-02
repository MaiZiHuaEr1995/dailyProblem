package leetcode;

import java.util.Stack;

public class MyQueue {
    // stack1 用来表示入栈
    Stack<Integer> stack1;
    // stack2 用来表示进栈
    Stack<Integer> stack2;


    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        if (stack2.isEmpty()) {
            // 通过while循环把stack1中的元素全部都取出来
            while (!stack1.isEmpty()) {
                // stack1不断添加stack1中的栈顶元素
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public int peek() {
        // peek 和 pop 的元素区别在于不删除，只是查看
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    public boolean empty() {
        return stack2.isEmpty() && stack1.isEmpty();
    }
}
