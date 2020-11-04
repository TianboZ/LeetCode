package MianJing.thumbtack;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class MedianMeanAPI {

    public static void main(String[] args) {
        MedianMean medianMean = new MedianMean(0, 1000);
        medianMean.add(11);
        medianMean.add(10);
        medianMean.add(2);
        medianMean.add(4);
        medianMean.add(4);
        medianMean.add(1);


        // 1, 2, 4, 4, 10, 11   mean = 5.3333   median = 4
        double mean = medianMean.mean();
        double median = medianMean.median();
        System.out.println(mean + ", " + median);
    }
}

// count sort
class MedianMean {
    // field
    int lower;
    int upper;
    int[] counter;

    int sum; // sum
    int total; // total numbers

    // constructor
    MedianMean(int lower, int upper) {
        this.lower = lower;
        this.upper = upper;
        this.counter = new int[upper - lower + 1];
        this.sum = 0;
        this.total = 0;
    }

    // api
    public double median() {
        if (total % 2 == 0) {
            return (getKth(total / 2) + getKth(total / 2 + 1)) / 2.0;
        } else {
            return getKth(total / 2 + 1) * 1.0;
        }
    }

    private int getKth(int k) {
        for (int i = 0; i < counter.length; i++) {
            int count = counter[i];
            if (count >= k) {
                return i + lower;
            }
            k = k - count;
        }
        return 0;
    }
    public double mean() {
        return sum * 1.0 / total;
    }


    public void add(int num) {
        counter[num - lower]++;
        sum = sum + num;
        total++;
    }
}
/*

smaller half     larger half
xxxxxxxxxxxxxx   xxxxxxxxxxxxxxxx
             |   |
           max   min (min > max)

    if smaller half size == larger half size
    then the median is (max + min)/2  or max(depend on array length is odd or even)

    so use maxHeap to store elements in smaller half, use minHeap to store elements in larger half

*/
class FindMedianFromDataStream {

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
        debugLaicode.FindMedianFromDataStream findMedianFromDataStream = new debugLaicode.FindMedianFromDataStream();
        findMedianFromDataStream.addNum(1);
        findMedianFromDataStream.addNum(11);
        findMedianFromDataStream.addNum(-1);
        findMedianFromDataStream.addNum(49);
        double res = findMedianFromDataStream.findMedian();
        System.out.println(res);
    }
}