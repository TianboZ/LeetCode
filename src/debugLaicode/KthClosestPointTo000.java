package debugLaicode;

import java.util.*;

public class KthClosestPointTo000 {
    public List<Integer> closest(int[] a, int[] b, int[] c, int k) {
        // Write your solution here.
        // create a min heap
        PriorityQueue<Cell> pq = new PriorityQueue<>(new Comparator<Cell>(){
            @Override
            public int compare(Cell c1, Cell c2) {
                return c1.dis == c2.dis ? 0 : (c1.dis < c2.dis ? - 1 : 1);
            }
        }); // min heap

        boolean[][][] visited = new boolean[a.length][b.length][c.length];
        int count = 0;
        List<Integer> res = new ArrayList<>();

        // initial
        pq.offer(new Cell(0, 0, 0, distance(a[0], b[0], c[0])));
        visited[0][0][0] = true;

        // terminate
        while (!pq.isEmpty()) {
            // expend
            Cell cur = pq.poll();
            count++;

            if (count == k) {
                res = Arrays.asList(a[cur.i], b[cur.j], c[cur.m]);
                break;
            }

            int i = cur.i;
            int j = cur.j;
            int m = cur.m;

            // generate rule
            // case1
            if (i + 1 < a.length && !visited[i + 1][j][m]) {
                pq.offer(new Cell(i + 1, j, m, distance(a[i + 1], b[j], c[m])));
                visited[i + 1][j][m] = true;
            }
            // case2
            if (j + 1 < b.length && !visited[i][j + 1][m]) {
                pq.offer(new Cell(i, j + 1, m, distance(a[i], b[j + 1], c[m])));
                visited[i][j + 1][m] = true;
            }
            // case3
            if (m + 1 < c.length && !visited[i][j][m + 1]) {
                pq.offer(new Cell(i, j, m + 1, distance(a[i], b[j], c[m + 1])));
                visited[i][j][m + 1] = true;
            }
        }

        return res;
    }
    private int distance(int a, int b, int c) {
        return a * a + b * b + c * c;
    }

    class Cell{
        // fields
        int i;
        int j;
        int m;
        int dis;

        // constructor
        public Cell(int i, int j, int m, int dis) {
            this.i = i;
            this.j = j;
            this.m = m;
            this.dis = dis;
        }
    }
}

