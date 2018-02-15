package debugLaicode;

import java.util.*;

public class KthSmallestInSortedArray {
    public static void main(String[] args) {

        KthSmallestInSortedArray kthSmallestInSortedArray = new KthSmallestInSortedArray();
        int[][] matrix = { {1,  3,   5,  7},

                            {2,  4,   8,   9},

                            {3,  5, 11, 15},

                            {6,  8, 13, 18} };
        int k = 8;
        kthSmallestInSortedArray.kthSmallest(matrix, k);
    }
    public int kthSmallest(int[][] matrix, int k) {
        // Write your solution here
        CP cp = new CP();
        Queue<Cell> minHeap = new PriorityQueue<>(11, cp);
        Set<Cell> visited = new HashSet<>();
        // initial
        minHeap.offer(new Cell(0, 0, matrix[0][0]));
        visited.add(new Cell(0, 0, matrix[0][0]));

        int count = 0;
        while (!minHeap.isEmpty()) {
            // expand
            Cell cur = minHeap.poll();
            count++;
            if (count == k - 1) {
                break;
            }
            // generate
            if (cur.x + 1 < matrix.length && !visited.contains(new Cell(cur.x + 1, cur.y, matrix[cur.x + 1][cur.y]))) {
                minHeap.offer(new Cell(cur.x + 1, cur.y, matrix[cur.x + 1][cur.y]));
                visited.add(new Cell(cur.x + 1, cur.y, matrix[cur.x + 1][cur.y]));
            }
            if (cur.y + 1 < matrix[0].length && !visited.contains(new Cell(cur.x, cur.y + 1, matrix[cur.x][cur.y + 1]))) {
                minHeap.offer(new Cell(cur.x, cur.y + 1, matrix[cur.x][cur.y + 1]));
                visited.add(new Cell(cur.x, cur.y + 1, matrix[cur.x][cur.y + 1]));
            }
        }
        System.out.println(minHeap.peek().val);
        return minHeap.peek().val;
    }

    class Cell {
        int x;
        int y;
        int val;
        public Cell (int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        @Override
        public boolean equals(Object obj) {
            Cell cell = (Cell) obj;
            return cell.x == this.x && cell.y == this.y && cell.val == this.val;
        }
        @Override
        public int hashCode() {
            return 31 * x + y;
        }
    }

    class CP implements Comparator<Cell> {
        @Override
        public int compare(Cell cell1, Cell cell2) {
            return cell1.val - cell2.val;
        }
    }
}
