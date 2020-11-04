package MianJing.thumbtack;

import java.util.*;

class RateLimitter {
    // fields
    private Queue<Long> queue;
    private long TIME; // millis second
    private long k;

    // constructor
    RateLimitter (int k, int second) {
        queue = new LinkedList<>();
        this.k = k;
        this.TIME = second * 1000;
    }

    // API
    public boolean canCall() {
        long currMilli = System.currentTimeMillis();

        while (!queue.isEmpty() && queue.peek() < currMilli - TIME) {
            queue.poll();
        }

        if (queue.size() >= k) {
            //System.out.println("queue size > k and queue size is " + queue.size());
            return false;
        }

        queue.offer(currMilli);
        return true;
    }
}

public class RateAPI {

    RateLimitter rateLimitter = new RateLimitter(5, 1);

    public void call() {
        if (rateLimitter.canCall()) api();
    }

    private void api() {
        System.out.println("api is running");
    }

    public static void main(String[] args) {

        RateAPI rate = new RateAPI();
        for (int i = 0; i < 100000000; i++) {
            rate.call();
        }
    }
}