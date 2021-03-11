package 面试常见算法.栈实现队列;

import java.util.Stack;

public class MyQueue {
    private Stack<Integer> stackPush;
    private Stack<Integer> stackPop;

    public MyQueue() {
        stackPush = new Stack<>();
        stackPop = new Stack<>();
    }

    // push栈向pop栈压入方法：摊还时间复杂度
    private void pushToPop() {
        // 原则:pop栈为空，必须将push栈全部压入
        while (stackPop.isEmpty()) {
            while (!stackPush.isEmpty()) {
                stackPop.push(stackPush.pop());
            }
        }
    }

    public void push(int x) {
        pushToPop();
        stackPush.push(x);
        pushToPop();
    }


    public int pop() {
        if (empty()) {
            throw new IllegalArgumentException("Stack is Empty");
        }
        pushToPop();
        return stackPop.pop();
    }


    public int peek() {
        if (empty()) {
            throw new IllegalArgumentException("Stack is Empty");
        }
        pushToPop();
        return stackPop.peek();
    }


    public boolean empty() {
        // 两个栈都空才是队列空
        return stackPush.isEmpty() && stackPop.isEmpty();
    }
}
