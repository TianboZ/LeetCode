package debugLaicode;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class FindMedianFromDataStream {
    /** initialize your data structure here. */
//        smaller half       larger half
//     xxxxxxxxxxxxxxxxx xxxxxxxxxxxxxxxxxx
//                     | |
//               largest smallest

//         maxheap             minheap

//         keep maxheap size >= minheap size
    private Queue<Integer> minHeap;
    private Queue<Integer> maxHeap;

    public FindMedianFromDataStream() {
        this.minHeap = new PriorityQueue<>();
        this.maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    }


    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        if (maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }

    }

    public double findMedian() {
        if (minHeap.size() == maxHeap.size()) return (maxHeap.peek() + minHeap.peek()) /  2.0;
        return maxHeap.peek();
    }
}
