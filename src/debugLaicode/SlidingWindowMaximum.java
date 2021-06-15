package debugLaicode;

import java.util.*;

/*

solution1:

use a maxheap to represent the sliding window
    - get max value
    - add new element into window
    - remove element out of window

    [1  3  -1] -3  5  3  6  7       3
     s          f

time O(n * logk) !!!!!wrong


sol2:
AVL tree


sliding window
map<num, frequency>




*/
public class SlidingWindowMaximum {
    class Cell {
        int val;
        int i; // index
        Cell(int v, int _i) {
            val = v;
            i = _i;
        }
    }
    public int[] maxSlidingWindow1(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[] {};

        Queue<Cell> pq = new PriorityQueue<>((c1, c2) -> c2.val - c1.val);  // max heap, sorted by Cell.val

        List<Integer> res =new ArrayList<>();

        // initial pq
        for (int i = 0; i< k; i++) {
            pq.offer(new Cell(nums[i], i));
        }
        res.add(pq.peek().val);

        int fast = k;
        while (fast < nums.length) {
            // handle right most
            pq.offer(new Cell(nums[fast], fast));

            // remove element before left bound of window
            int slow = fast - k;
            while (!pq.isEmpty() && pq.peek().i <= slow) {
                pq.poll();
            }

            res.add(pq.peek().val);

            fast++;
        }


        // build result
        int[] ans = new int[res.size()];
        int i = 0;
        for (Integer e : res) {
            ans[i] = e;
            i++;
        }
        return ans;
        //return res;

    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();

        TreeMap<Integer, Integer> map  = new TreeMap<>();
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            // right most elment
            int n = nums[i];
            map.put(n, map.getOrDefault(n, 0) + 1);

            // remove element before window
            int j = i - k;
            if (j >= 0) {
                n = nums[j];
                if (map.containsKey(n) ) {
                    map.put(n, map.get(n) - 1);
                    if(map.get(n) == 0) map.remove(n);
                }
            }

            // update global max
            if (i >= k - 1) {
                res.add(map.lastKey());
            }
        }

        // build result
        int[] ans = new int[res.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
}
