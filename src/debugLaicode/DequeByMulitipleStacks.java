package debugLaicode;

import java.util.Stack;

public class DequeByMulitipleStacks {
    Stack<Integer> left;
    Stack<Integer> right;

    public DequeByMulitipleStacks() {
        this.left = new Stack<>();
        this.right = new Stack<>();
    }

    public void leftPush(int element) {
        left.push(element);
    }
    public void rightPush(int element) {
        right.push(element);
    }
    public Integer leftPop() {
        if (!left.isEmpty()) {
            return left.pop();
        } else if (left.isEmpty() && right.isEmpty()){
            return null;
        } else {
            while (!right.isEmpty()) {
                left.push(right.pop());
            }
            return left.pop();
        }
    }
    public Integer rightPop() {
        if (!right.isEmpty()) {
            return right.pop();
        } else if (left.isEmpty() && right.isEmpty()){
            return null;
        } else {
            while (!left.isEmpty()) {
                right.push(left.pop());
            }
            return right.pop();
        }
    }
}
