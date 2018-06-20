package debugLaicode;

import java.util.*;

public class KthClosestPointTo000 {
    public List<Integer> closest(int[] a, int[] b, int[] c, int k) {
        // Write your solution here.
        // create a min heap
        PriorityQueue<Cor> pq = new PriorityQueue<>();
        boolean[][][] visited = new boolean[a.length][b.length][c.length];
        // initial
        pq.offer(new Cor(0, 0, 0, distance(a[0], b[0], c[0])));
        visited[0][0][0] = true;

        // terminate
        for (int count = 0; count < k - 1; count++) {
            // expend
            Cor cur = pq.poll();
            int i = cur.i;
            int j = cur.j;
            int m = cur.m;

            //System.out.println("result: " + a[i] + ", " + b[j] + ", " + c[m]);
            // generate rule
            // case1
            if (i + 1 < a.length && !visited[i + 1][j][m]) {
                pq.offer(new Cor(i + 1, j, m, distance(a[i + 1], b[j], c[m])));
                visited[i + 1][j][m] = true;
            }
            // case2
            if (j + 1 < b.length && !visited[i][j + 1][m]) {
                pq.offer(new Cor(i, j + 1, m, distance(a[i], b[j + 1], c[m])));
                visited[i][j + 1][m] = true;
            }
            // case3
            if (m + 1 < c.length && !visited[i][j][m + 1]) {
                pq.offer(new Cor(i, j, m + 1, distance(a[i], b[j], c[m + 1])));
                visited[i][j][m + 1] = true;
            }
        }

        Cor temp = pq.poll();
        //System.out.println("result: " + a[temp.i] + ", " + b[temp.j] + ", " + c[temp.m]);
        List<Integer> list = new ArrayList<>();

        list.add(a[temp.i]);
        list.add(b[temp.j]);
        list.add(c[temp.m]);

        return list;
    }
    private int distance(int a, int b, int c) {
        return a * a + b * b + c * c;
    }

    class Cor implements Comparable<Cor>{
        // fields
        int i;
        int j;
        int m;
        int dis;

        // constructor
        public Cor(int i, int j, int m, int dis) {
            this.i = i;
            this.j = j;
            this.m = m;
            this.dis = dis;
        }

        // API
        @Override
        public int compareTo(Cor another) {
            if (this.dis == another.dis) {
                return 0;
            }
            return this.dis < another.dis ? -1 : 1;
        }
    }
}

