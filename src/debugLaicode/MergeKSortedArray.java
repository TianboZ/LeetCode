package debugLaicode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedArray {
    public int[] merge(int[][] arrayOfArrays) {
        // length of each array is different
        List<Integer> res = new ArrayList<>();
        Queue<Cell> minHeap = new PriorityQueue<>();
        // initial
        for (int i = 0; i < arrayOfArrays.length; i++) {
            if (arrayOfArrays[i].length != 0) {
                minHeap.offer(new Cell(i, 0, arrayOfArrays[i][0]));
            }
        }

        while (!minHeap.isEmpty()) {
            // expand
            Cell curr = minHeap.poll();
            res.add(curr.val);

            int x = curr.x;
            int y = curr.y;

            // generate
            if (y + 1 < arrayOfArrays[x].length) {
                minHeap.offer(new Cell(x, y + 1, arrayOfArrays[x][y + 1]));
            }
        }

        // post process
        int[] sol = new int[res.size()];
        for (int i = 0; i < sol.length; i++) {
            sol[i] = res.get(i);
        }
        return sol;
    }

    class Cell implements Comparable<Cell> {
        int x;
        int y;
        int val;
        Cell(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
        @Override
        public int compareTo(Cell another) {
            if (this.val == another.val) {
                return 0;
            }
            return this.val < another.val ? -1 : 1;
        }
    }
}
