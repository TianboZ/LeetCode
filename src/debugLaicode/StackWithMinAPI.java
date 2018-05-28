package debugLaicode;

import java.util.Stack;

public class StackWithMinAPI {
    Stack<Integer> stack;
    Stack<Integer> minStack;

    public StackWithMinAPI() {
        // write your solution here
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
    }

    public int pop() {
        if (!minStack.isEmpty()) {
            minStack.pop();
        }
        return stack.isEmpty() ? -1 : stack.pop();
    }

    public void push(int element) {
        stack.push(element);
        if (minStack.isEmpty()) {
            minStack.push(element);
        } else if (stack.peek() < minStack.peek()) {
            minStack.push(stack.peek());
        } else {
            minStack.push(minStack.peek());
        }
    }

    public int top() {
        return stack.isEmpty() ? -1 : stack.peek();
    }

    public int min() {
        if (!minStack.isEmpty()) {
            return minStack.peek();
        } else {
            return -1;
        }
    }
}