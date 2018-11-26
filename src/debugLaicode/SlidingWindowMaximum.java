package debugLaicode;

import java.util.*;

/*

solution1:
for each sliding window, find the max value in it

time O(n * klogk)   n is nums.length
space O(n - k)

solution2:
use a maxheap to represent the sliding window
    - get max value
    - add new element into window
    - remove element out of window

    [1  3  -1] -3  5  3  6  7       3
     s          f

time O(n * logk)

*/
public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[] {};

        Queue<Cell> maxheap = new PriorityQueue<>(new CP());

        int[] res = new int[nums.length - k + 1];
        int i = 0;

        // inital maxheap
        for (int fast = 0; fast < k; fast++) {
            maxheap.offer(new Cell(nums[fast], fast));
        }
        res[i] = maxheap.peek().val;
        i++;

        // slide the window
        for (int fast = k; fast < nums.length; fast++) {
            // handle rightmost pointer
            maxheap.offer(new Cell(nums[fast], fast));

            // handle leftmost pointer
            int slow = fast - k;

            while (maxheap.peek().index <= slow) {
                maxheap.poll();
            }

            // current window
            res[i] = maxheap.peek().val;
            i++;
        }
        return res;
    }
    class CP implements Comparator<Cell> {
        @Override
        public int compare(Cell c1, Cell c2) {
            if (c1.val == c2.val) return 0;
            return c1.val < c2.val ? 1 : -1; // decreasing order
        }
    }
    class Cell {
        int val;
        int index;
        Cell(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }
}
