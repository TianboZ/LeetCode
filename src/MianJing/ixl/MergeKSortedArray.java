package MianJing.ixl;

import java.util.*;

public class MergeKSortedArray {
    private static class Cell {
        int i;
        int j;
        int val;
        Cell(int _i, int _j, int v) {
            i = _i;
            j = _j;
            val = v;
        }
    }
    public int[] merge(int[][] arrayOfArrays) {
        // Write your solution here
        Queue<Cell> pq = new PriorityQueue<>(new Comparator<Cell>() {
            @Override
            public int compare(Cell c1, Cell c2) {
                return c1.val == c2.val ? 0 : (c1.val < c2.val ? -1 : 1);
            }
        });
        List<Integer> list = new ArrayList<>();

        // initial
        for (int i = 0; i < arrayOfArrays.length; i++) {
            int[] arr = arrayOfArrays[i];
            if (arr != null && arr.length > 0) {
                pq.offer(new Cell(i, 0, arr[0]));
            }
        }

        // terminate
        while (!pq.isEmpty()) {
            Cell curr = pq.poll();
            list.add(curr.val);

            int i = curr.i;
            int j = curr.j + 1;
            if (j < arrayOfArrays[i].length) {
                pq.offer(new Cell(i, j, arrayOfArrays[i][j]));
            }
        }

        // build result
        int[] ans = new int[list.size()];
        int i = 0;
        while (i < list.size()) {
            ans[i] = list.get(i);
            i++;
        }
        return ans;
    }
}
