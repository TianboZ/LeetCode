package debugLaicode;


import MianJing.thumbtack.DesignCalendar;

import java.util.LinkedList;
import java.util.Queue;

public class DesignHitCounter {
    // fields
    private Queue<Long> hits;
    public static final long RANGE = 1 * 2 * 1000; // 2000 milli-second

    //  constructor
    public DesignHitCounter() {
        hits = new LinkedList<>();
    }

    // API
    // record a hit at current timestamp
    public void record() {
        long curr = System.currentTimeMillis();
        System.out.println(curr);
        evict(curr - RANGE);
        hits.offer(curr);
    }

    // return the # of hits happend in last 5 mins according to the time when calling this API
    public long hitsLastFiveMins() {
        long curr = System.currentTimeMillis();
        evict(curr - RANGE);
        return hits.size();
    }

    private void evict(long target) {
        while (!hits.isEmpty() && hits.peek() < target) hits.poll();
    }

    public void timeComsume() {

        for (double i = 0; i < 1000000000; i++) {

        }
    }
    public static void main(String[] args) {
        DesignHitCounter counter = new DesignHitCounter();
        counter.record();
        counter.timeComsume();

        counter.record();
        counter.timeComsume();

        counter.record();
        counter.timeComsume();

        counter.record();
        counter.timeComsume();

        counter.record();
        counter.timeComsume();

        long res = counter.hitsLastFiveMins();
        System.out.println(res);

    }
}

