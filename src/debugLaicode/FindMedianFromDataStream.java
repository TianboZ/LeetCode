package debugLaicode;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;



/*

smaller half     larger half
xxxxxxxxxxxxxx   xxxxxxxxxxxxxxxx
             |   |
           max   min (min > max)

    if smaller half size == larger half size
    then the median is (max + min)/2  or max(depend on array length is odd or even)

    so use maxHeap to store elements in smaller half, use minHeap to store elements in larger half

*/
public class FindMedianFromDataStream {

    Queue<Integer> minHeap;
    Queue<Integer> maxHeap;
    /** initialize your data structure here. */
    public FindMedianFromDataStream() {
        this.minHeap = new PriorityQueue<>();
        this.maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll()); // make sure the min element in minHeap is larger then the max element in maxHeap
        if (maxHeap.size() < minHeap.size()) { // make sure maxHeap.size >= minHeap.size
            maxHeap.offer(minHeap.poll());
        }
    }

    // time o(1)
    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) return (maxHeap.peek() + minHeap.peek())  /2.0;
        return maxHeap.peek();
    }

    public static void main(String[] args) {
        FindMedianFromDataStream findMedianFromDataStream = new FindMedianFromDataStream();
        findMedianFromDataStream.addNum(1);
        findMedianFromDataStream.addNum(11);
        findMedianFromDataStream.addNum(-1);
        findMedianFromDataStream.addNum(49);
        double res = findMedianFromDataStream.findMedian();
        System.out.println(res);
    }
}

//space o(n)

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */