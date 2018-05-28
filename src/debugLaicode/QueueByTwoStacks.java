package debugLaicode;

import java.util.Stack;

public class QueueByTwoStacks {
    Stack<Integer> in;
    Stack<Integer> out;
    public QueueByTwoStacks() {
        // Write your solution here.
        this.in = new Stack<>();
        this.out = new Stack<>();
    }

    public Integer poll() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        return out.isEmpty() ? null : out.pop();
    }

    public void offer(int element) {
        in.push(element);
    }

    public Integer peek() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        return out.isEmpty() ? null : out.peek();
    }

    public int size() {
        return in.size() + out.size();
    }

    public boolean isEmpty() {
        return in.isEmpty() && out.isEmpty();
    }

    public static void main(String[] args) {
        QueueByTwoStacks queueByTwoStacks = new QueueByTwoStacks();
        queueByTwoStacks.offer(1);
        queueByTwoStacks.offer(2);
        queueByTwoStacks.offer(3);
        int a = queueByTwoStacks.peek();
        System.out.println(a);
        queueByTwoStacks.poll();
        queueByTwoStacks.poll();
        queueByTwoStacks.poll();
        queueByTwoStacks.poll();
        System.out.println(queueByTwoStacks.peek());
    }
}