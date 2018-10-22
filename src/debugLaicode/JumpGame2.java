package debugLaicode;

import java.util.LinkedList;
import java.util.Queue;

public class JumpGame2 {
    // sol1: dp
    // time O(n ^ 2)
    // space O(n)

    // sol2: bfs, shortest path

    // time O(V + E) = O(n ^ 2)   n is nums.length
    // space O(V) = O(n)
    public int jump2(int[] nums) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[nums.length];
        int level = 0;

        // initial
        q.offer(0);
        visited[0] = true;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                // expand
                int curr = q.poll();
                if (curr == nums.length - 1) return level;

                // generate
                for (int j = 0; j <= nums[curr] && j + curr < nums.length; j++) {
                    int next = curr + j;
                    if (!visited[next] ) {
                        q.offer(next);
                        visited[next] = true;
                    }
                }

            }
            level++;
        }
        return -1; // if can not jump to last index
    }
}
