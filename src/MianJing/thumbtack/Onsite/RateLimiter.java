package MianJing.thumbtack.Onsite;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class RateLimiter {
    // fields
    private Queue<Long> q;
    private long time; // any consecutive time(milli seconds), at most k request
    private int k;

    // constructor
    public RateLimiter(long time, int k) {
        q = new LinkedList<>();
        this.time = time;
        this.k = k;
    }

    // API
    boolean canCall() {
        long curr = System.currentTimeMillis();
        if (!q.isEmpty() && q.peek() + time < curr) {
            q.poll();
        }
        if (q.size() < k) {
            q.offer(curr);
            return true;
        } else {
            return false;
        }

    }
}
class RateLimiter2 {
    private int[] arr;
    private final int WINDOW = 1000;
    int total;
    int k;
    long prev; // previous timestamp   prev % WINDOW == tail position

    RateLimiter2(int k) {
        arr = new int[WINDOW];
        this.k = k;
        prev = System.currentTimeMillis();
        total = 0;
    }

    public boolean canCall() {
        long curr = System.currentTimeMillis();
        evict(curr);

        if (total >= k) return false;

        int tail = (int) curr % WINDOW;
        arr[tail]++;
        total++;
        prev = curr;

        return true;
    }

    private void evict(long curr) {
        if (prev + WINDOW <= curr) {
            total = 0;
            Arrays.fill(arr, 0);
            return;
        }

        for (long time = prev + 1; time <= curr; time++) {
            int tail = (int) time % WINDOW;
            total = total - arr[tail];
            arr[tail] = 0;
        }
    }
}
class Solution {
    // fields
    RateLimiter2 rateLimiter = new RateLimiter2( 10); // any consecutive 1 second, at most 10 calls

    // constructor
    public Solution() {

    }

    // API
    public void call() {
        if (rateLimiter.canCall()) {
            api();
        }
    }

    private void api() {
        System.out.println(" api is running");
    }

    // driver function
    public static void main(String[] args) {
        Solution solution = new Solution();
        try {
            for (int i = 0; i < 1000000; i++) {
                solution.call();
            }
            Thread.sleep(1000);
        } catch (InterruptedException e) {

        }
        System.out.println("after sleeping 1 seconds");


        try {
            for (int i = 0; i < 100000; i++) {
                solution.call();
            }
            Thread.sleep(3000);
        } catch (InterruptedException e) {

        }

    }
}