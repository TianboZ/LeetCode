package debugLaicode;

import java.util.*;

/*

start from nums1[0] and nums2[0], run best first search

    1   3   4
    2   3

total 3 * 2 = 6 pairs

*/


public class FindKPairswithSmallestsUMS {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new ArrayList<int[]>();
        // sanity check
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0 || k == 0) {
            return res;
        }

        Queue<Cell> minHeap = new PriorityQueue<>(new CP());
        boolean[][] visited = new boolean[nums1.length][nums2.length];
        int count = 0;
        // initial
        minHeap.offer(new Cell(0, 0, nums1[0] + nums2[0]));
        visited[0][0] = true;

        while (!minHeap.isEmpty()) {
            // expand
            Cell curr = minHeap.poll();
            int x = curr.x;
            int y = curr.y;
            res.add(new int[] {nums1[x], nums2[y]});
            count++;
            if (count == k) break;

            // generate
            if (x + 1 < nums1.length && !visited[x + 1][y]) {
                visited[x + 1][y] = true;
                minHeap.offer(new Cell(x + 1, y, nums1[x + 1] + nums2[y]));
            }
            if (y + 1 < nums2.length && !visited[x][y + 1]) {
                visited[x][y + 1] = true;
                minHeap.offer(new Cell(x, y + 1, nums1[x] + nums2[y + 1]));
            }

        }
        return res;
    }
    class Cell {
        int x;
        int y;
        int sum;
        Cell(int x, int y, int sum) {
            this.x = x;
            this.y = y;
            this.sum = sum;
        }
    }
    class CP implements Comparator<Cell> {
        @Override
        public int compare(Cell c1, Cell c2) {
            if (c1.sum == c2.sum) return 0;
            return c1.sum < c2.sum ? -1 : 1;  // decreasing order
        }
    }
}