package debugLaicode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MeetingRooms2 {

    private class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public int minMeetingRooms(Interval[] intervals) {
        // sanity check
        if (intervals == null || intervals.length == 0) return 0;

        Arrays.sort(intervals, new CP1()); // sort intervals by start time
        Queue<Interval> minheap = new PriorityQueue<>(new CP2()); // use min heap to track the minimm end time of merged intervals
        minheap.offer(intervals[0]);// start with the first meeting

        for (int i = 1; i < intervals.length; i++) {
            // get interval that finish earliest
            Interval interval = minheap.poll();
            if (intervals[i].start >= interval.end) {
                // if the current meeting starts after
                // there is no need for a new room, just merge the interval
                interval.end = intervals[i].end;
                minheap.offer(interval);
            } else {
                // this meetign needs a new room
                minheap.offer(interval);
                minheap.offer(intervals[i]);
            }
        }
        return minheap.size();
    }
    class CP1 implements Comparator<Interval> {
        @Override
        public int compare(Interval i1, Interval i2) {
            return i1.start < i2.start ? -1 : 1; // sort by start, increasing order
        }
    }
    class CP2 implements Comparator<Interval>{
        @Override
        public int compare(Interval i1, Interval i2) {
            return i1.end < i2.end ? -1 : 1; // sort by end, increasing order
        }
    }
}
