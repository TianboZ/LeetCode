package MianJing.ixl;

import java.util.PriorityQueue;
import java.util.Queue;

public class FindMedianInDataStream {
    Queue<Integer> min;
    Queue<Integer> max;

    /** initialize your data structure here. */
    public FindMedianInDataStream() {
        min = new PriorityQueue<>((a, b) -> a - b);
        max = new PriorityQueue<>((a, b) -> b - a);
    }

    public void addNum(int num) {
        max.offer(num);
        min.offer(max.poll()); // min heap smallest element is larger than max element in max heap

        // balance, make sure max is at most larger than min by 1
        if (min.size() > max.size()) {
            max.offer(min.poll());
        }
    }

    public Double findMedian() {
        // sanity check
        if (max.size() == 0) return null;
        if (min.size() == max.size()) {
            return (double)(max.peek() + min.peek()) / 2;
        }
        return new Double(max.peek());
    }
}

/*

max heap size - min heap size <= 1
space o(n)
API time o(logn)

*/


/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */