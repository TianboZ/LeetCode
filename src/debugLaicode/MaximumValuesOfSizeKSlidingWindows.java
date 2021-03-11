package debugLaicode;

import java.util.*;

public class MaximumValuesOfSizeKSlidingWindows {
    public List<Integer> maxWindows(int[] array, int k) {
        Queue<Cell> pq  = new PriorityQueue<>(new Comparator<Cell>() {
            @Override
            public int compare(Cell o1, Cell o2) {
                if (o1.val == o2.val) return 0;
                return o1.val < o2.val ? 1 : -1;
            }
        }); // max heap

        List<Integer> res = new ArrayList<>();
        // intial
        for (int i = 0; i < k; i++) {
            pq.offer(new Cell(array[i], i));
        }
        res.add(pq.peek().val);

        for (int i = k; i < array.length; i++) {
            while (!pq.isEmpty() && pq.peek().idx <= i - k) {
                pq.poll();
            }
            pq.offer(new Cell(array[i], i));
            res.add(pq.peek().val);
        }
        return res;
    }
    private static class Cell {
        int val;
        int idx;
        Cell(int v, int i) {
            val = v;
            idx = i;
        }
    }
}
