package debugLaicode;

import java.util.PriorityQueue;
import java.util.Queue;

public class ArrayHopper4 {
    public int minJump(int[] array, int index) {
        // Write your solution here
        Queue<Jump> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[array.length];
        // initial
        pq.offer(new Jump(index, 0));
        visited[index] = true;

        while (!pq.isEmpty()) {
            // expand
            Jump curr = pq.poll();
            int pos = curr.index;
            int jumps = curr.jumps;

            // terminate
            if (pos == array.length - 1) {
                return jumps;
            }

            // generate rule
            int maxJumps = array[pos];
            // go left
            for (int i = 1; i <= maxJumps; i++) {
                if (pos - i >= 0 && !visited[pos - i]) {
                    pq.offer(new Jump(pos - i, jumps + 1));
                    visited[pos - i] = true;
                }
            }
            // go right
            for (int i = 1; i <= maxJumps; i++) {
                if (pos + i < array.length && !visited[pos + i]) {
                    pq.offer(new Jump(pos + i, jumps + 1));
                    visited[pos + i] = true;
                }
            }
        }
        return -1;
    }

    private class Jump implements Comparable<Jump> {
        // fields
        private int index;
        private int jumps;

        // constructor
        public Jump(int index, int jumps) {
            this.jumps = jumps;
            this.index = index;
        }

        // api
        @Override
        public int compareTo(Jump another) {
            if (this.jumps == another.jumps) {
                return 0;
            }
            return this.jumps < another.jumps ? -1 : 1;
        }
    }

    public static void main(String[] args) {
        ArrayHopper4 arrayHopper4 = new ArrayHopper4();
        int[] arr = {1,2,3,4,5,6,7};
        int res = arrayHopper4.minJump(arr, 4);
        System.out.println(res);
    }
}
