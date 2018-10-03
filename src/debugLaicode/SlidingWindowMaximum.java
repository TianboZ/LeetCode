package debugLaicode;

import java.util.*;

public class SlidingWindowMaximum {
    public List<Integer> maxSlidingWindow(int[] nums, int k) {
        // Write your solution here
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;

        Queue<Cell> q = new PriorityQueue<>(new CP());
        // initial
        for (int i = 0; i < k; i++) {
            q.offer(new Cell(i, nums[i]));
        }
        res.add(q.peek().val);

        // terminate condition
        for (int right = k; right < nums.length; right++) {
            int left = right - k; // (left, right] is new window range
            q.offer(new Cell(right, nums[right]));
            while (!q.isEmpty() && q.peek().index <= left) {
                q.poll();
            }
            res.add(q.peek().val); // largest value in current window
        }
        return res;
    }

    class Cell {
        int index;
        int val;
        Cell (int index, int val) {
            this.val = val;
            this.index = index;
        }
    }

    class CP implements Comparator<Cell> {
        @Override
        public int compare(Cell c1, Cell c2) {
            if (c1.val == c2.val) return 0;
            return c1.val < c2.val ? 1 : -1; // decrease order
        }
    }

    // time O(nlogk)
    // space O(k)

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // sol2:
    // use deque
    public List<Integer> maxWindows(int[] array, int k) {
        List<Integer> max = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < array.length; i++) {
            while (!deque.isEmpty() && array[deque.peekLast()] <= array[i]) {
                deque.pollLast();
            }

            if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            deque.offerLast(i);

            if (i - k + 1 >= 0) {
                max.add(array[deque.peekFirst()]);
            }
        }
        return max;
    }
}
