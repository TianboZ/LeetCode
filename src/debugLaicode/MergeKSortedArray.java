package debugLaicode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedArray {
    private static class Cell {
        int i;
        int j;
        int val;
        Cell(int _i, int _j, int _val) {
            i = _i;
            j = _j;
            val = _val;
        }
    }
    public int[] merge(int[][] arrayOfArrays) {
        // length of each array is different
        List<Integer> res = new ArrayList<>();
        Queue<Cell> minHeap = new PriorityQueue<>((c1, c2) -> c1.val - c2.val);

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

            int ii = curr.i;
            int jj = curr.j;

            // generate
            if (jj + 1 < arrayOfArrays[ii].length) {
                minHeap.offer(new Cell(ii, jj + 1, arrayOfArrays[ii][jj + 1]));
            }
        }

        // post process
        int[] sol = new int[res.size()];
        for (int i = 0; i < sol.length; i++) {
            sol[i] = res.get(i);
        }
        return sol;
    }

    public static void main(String[] strings) {
        MergeKSortedArray sol = new MergeKSortedArray();
        int[][] arrs = {
                {1,2,3},
                {4,5,10},
                {-10, 100},
                {}
        };

        int[] res = sol.merge(arrs);
        System.out.println(res);
    }
}
