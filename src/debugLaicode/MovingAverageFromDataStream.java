package debugLaicode;


import java.util.LinkedList;
import java.util.Queue;

/*
        1         2         3           4           5

queue                       <3         4           5>
sum     6-->   5+4 --> 7+5
*/
public class MovingAverageFromDataStream {
    Queue<Integer> queue;
    int size;
    int sum; // window sum
    /** Initialize your data structure here. */
    public MovingAverageFromDataStream(int size) {
        this.size = size;
        this.queue = new LinkedList<>(); // keep window size
    }

    // time o(1)
    // space o(1)
    public double next(int val) {
        if (queue.size() < size) {
            queue.offer(val);
            sum = sum + val;
        } else {
            sum = sum - queue.poll();
            sum = sum + val;
            queue.offer(val);
        }
        return sum * 1.0 / queue.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */