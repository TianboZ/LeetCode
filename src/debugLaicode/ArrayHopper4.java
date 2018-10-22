package debugLaicode;

import java.util.LinkedList;
import java.util.Queue;

public class ArrayHopper4 {
    public int minJump(int[] array, int index) {
        // Write your solution here
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[array.length];
        int level = 0;

        // initial
        q.offer(index);
        visited[index] = true;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                // expand
                int curr = q.poll();
                if (curr == array.length - 1) return level;

                // generate
                for (int j = -array[curr]; j <= array[curr]; j++) {
                    int next = curr + j;
                    if (next < array.length && next>= 0) {
                        if (!visited[next] ) {
                            q.offer(next);
                            visited[next] = true;
                        }
                    }
                }
            }
            level++;
        }
        return -1; // if can not jump to last index
    }
}
