package debugLaicode;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueues {
    Queue<Integer> q1; // handle stack's push operation
    Queue<Integer> q2; // helper queue when do pop and top operation

    /** Initialize your data structure here. */
    public ImplementStackUsingQueues() {
        this.q1 = new LinkedList<>();
        this.q2 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        q1.offer(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if (q1.isEmpty()) {
            return -1; // throw exception
        } else {
            while (q1.size() != 1) {
                q2.offer(q1.poll());
            }
            int res = q1.poll();

            Queue<Integer> q3 = q1;
            q1 = q2;
            q2 = q3;
            return res;
        }
    }

    /** Get the top element. */
    public int top() {
        if (q1.isEmpty()) {
            return -1; // throw exception
        } else {
            while (q1.size() != 1) {
                q2.offer(q1.poll());
            }
            int res = q1.poll();
            q2.offer(res);

            Queue<Integer> q3 = q1;
            q1 = q2;
            q2 = q3;
            return res;
        }
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty();
    }
}
