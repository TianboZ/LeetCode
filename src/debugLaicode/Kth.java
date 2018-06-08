package debugLaicode;

import java.util.*;

public class Kth {
    public List<Integer> closest(int[] a, int[] b, int[] c, int k) {
        // Write your solution here.
        CP1 cp = new CP1();
        PriorityQueue<Cor> minHeap = new PriorityQueue<>(11, cp);

        Set<Cor> set = new HashSet<>();

        minHeap.offer(new Cor(0,0,0,a[0] ^ 2 + b[0] ^ 2 + c[0] ^ 2));
        set.add(new Cor(0,0,0,a[0] ^ 2 + b[0] ^ 2 + c[0] ^ 2));

        while(k > 1) {
            // expend
            Cor cur = minHeap.poll();
            System.out.println("result: " + a[cur.i] + ", " + b[cur.j] + ", " + c[cur.m]);
            // generate rule
            // case1
            if (cur.i + 1 < a.length) {
                if (set.add(new Cor(cur.i + 1, cur.j, cur.m, distance(a[cur.i + 1], b[cur.j], c[cur.m])))) {
                    minHeap.offer(new Cor(cur.i + 1, cur.j, cur.m, distance(a[cur.i + 1], b[cur.j], c[cur.m])));
                }
            }
            // case2
            if (cur.j + 1 < b.length) {
                if (set.add(new Cor(cur.i, cur.j + 1, cur.m, distance(a[cur.i], b[cur.j + 1], c[cur.m])))) {
                    minHeap.offer(new Cor(cur.i, cur.j + 1, cur.m, distance(a[cur.i], b[cur.j + 1], c[cur.m])));
                }
            }
            // case3
            if (cur.m + 1 < c.length) {
                if (set.add(new Cor(cur.i, cur.j, cur.m + 1, distance(a[cur.i], b[cur.j], c[cur.m + 1])))) {
                    minHeap.offer(new Cor(cur.i, cur.j, cur.m + 1, distance(a[cur.i], b[cur.j], c[cur.m + 1])));
                }
            }

            k--;
        }

        Cor temp = minHeap.poll();
        System.out.println("result: " + a[temp.i] + ", " + b[temp.j] + ", " + c[temp.m]);
        List<Integer> list = new ArrayList<>();

        list.add(a[temp.i]);
        list.add(b[temp.j]);
        list.add(c[temp.m]);

        return list;
    }
    public int distance(int a, int b, int c) {
        return a * a + b * b + c * c;
    }

}

class Cor {
    int i;
    int j;
    int m;
    int dis;

    public Cor(int i, int j, int m, int dis) {
        this.i = i;
        this.j = j;
        this.m = m;
        this.dis = dis;
    }

}

class CP1 implements Comparator<Cor> {
    @Override
    public int compare(Cor m, Cor n) {
        return m.dis - n.dis;
    }
}