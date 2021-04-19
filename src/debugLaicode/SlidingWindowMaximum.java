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


    public int[] maxSlidingWindow2(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>(); // key: nums[i] value: i
        int[] res = new int[nums.length - k + 1];
        int index = 0;

        for (int i = 0; i < k; i++) {
            map.put(nums[i], i);
        }

        res[index] = map.lastKey();
        index++;

        for (int i = k; i< nums.length; i++) {
            //add new element into window
            map.put(nums[i], i);


            // remove left element before window boundry
            int left = nums[i - k];
            if (map.containsKey(left) && map.get(left) == i - k) {
                map.remove(left);
            }

            // get largest in current window
            res[index] = map.lastKey();
            index++;
        }
        return res;

    }
}
