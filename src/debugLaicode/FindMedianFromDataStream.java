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
    Queue<Integer> min;
    Queue<Integer> max;

    /** initialize your data structure here. */
    public FindMedianFromDataStream() {
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

    public double findMedian() {
        if (min.size() == max.size()) {
            return (double)(max.peek() + min.peek()) / 2;
        }
        return max.peek();
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