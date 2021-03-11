package debugLaicode;

import java.util.*;

public class KthSmallestInSortedMatrix {
    public static void main(String[] args) {
        KthSmallestInSortedMatrix kthSmallestInSortedMatrix = new KthSmallestInSortedMatrix();
        int[][] matrix = {  {1,  2,   5,  7},

                            {2,  4,   8,  9},

                            {3,  5,   11, 15},

                            {6,  8,   13, 18} };
        int k = 8;
        int res = kthSmallestInSortedMatrix.kthSmallest(matrix, k);
        System.out.println(res);

        Test test = new Test(1);
        Test test1 = new Test(2);
        Test test2 = new Test(1);

        System.out.println(test.equals(test2));
        Set<Test> set = new HashSet<>(Arrays.asList(test, test1, test2));
        System.out.println(set);
        System.out.println(set.contains(test));
    }

    public int kthSmallest(int[][] matrix, int k) {
        if (k <= 1) {
            return matrix[0][0];
        }

        // best first first search
        Queue<Cell2> qp = new PriorityQueue<>(
            (Cell2 c1, Cell2 c2) -> {
                return  c1.val == c2.val ? 0 : (c1.val < c2.val ? -1 : 1);
            }
//             // laicode doe not support lambda expression
//            new Comparator<Cell>() {
//                @Override
//                public int compare(Cell c1, Cell c2) {
//                    return c1.val == c2.val ? 0 : (c1.val < c2.val ? -1 : 1);
//                }
//            }
        );

        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        // initial state
        qp.offer(new Cell2(0, 0, matrix[0][0]));
        visited[0][0] = true;

        // terminate: iterate k - 1 rounds
        for (int i = 0; i < k - 1; i++) {
            // expand
            Cell2 curr = qp.poll();
            int x = curr.x;
            int y = curr.y;

            // generate
            if (x + 1 < matrix.length && !visited[x + 1][y]) {
                qp.offer(new Cell2(x + 1, y, matrix[x + 1][y]));
                visited[x + 1][y] = true;
            }
            if (y + 1 < matrix[0].length && !visited[x][y + 1]) {
                qp.offer(new Cell2(x, y + 1, matrix[x][y + 1]));
                visited[x][y + 1] = true;
            }
        }

        return qp.peek().val;
    }

    // 2020: static nested class
    private static class Cell2 {
        int val;
        int x;
        int y;
        public Cell2(int _x, int _y, int v) {
            val = v;
            x = _x;
            y = _y;
        }
    }

    class Cell implements Comparable<Cell>{
        int x;
        int y;
        int val;
        public Cell (int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Cell cell = (Cell) o;
            return x == cell.x &&
                    y == cell.y &&
                    val == cell.val;
        }

        @Override
        public int hashCode() {
            return 31 * 31 * this.x + 31 * this.y + this.val;
        }

        @Override
        public int compareTo(Cell another) {
            if (this.val == another.val) {
                return 0;
            }
            return this.val < another.val ? -1 : 1;

        }


    }

    // if E already implements Comparable<E> class, but still I provide a Comparator, PQ will chose the order
    // that specified in Comparator
    class MyComparator implements Comparator<Cell> {
        @Override
        public int compare(Cell c1, Cell c2) {
            if (c1.val == c2.val) {
                return 0;
            }
            return c1.val < c2.val ? -1 : 1;
        }
    }
    private  static class Test{
        int val;
        Test(int v) {
            val = v;
        }
    }
}
