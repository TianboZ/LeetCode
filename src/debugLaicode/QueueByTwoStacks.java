package debugLaicode;

import java.util.Deque;
import java.util.LinkedList;

public class QueueByTwoStacks {
    Deque<Integer> in;
    Deque<Integer> out;
    public QueueByTwoStacks() {
        // Write your solution here.
        this.in = new LinkedList<>();
        this.out = new LinkedList<>();
    }

    public Integer poll() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.offerFirst(in.pollFirst());
            }
        }
        return out.isEmpty() ? null : out.pollFirst();
    }

    public void offer(int element) {
        in.offerFirst(element);
    }

    public Integer peek() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.offerFirst(in.pollFirst());
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