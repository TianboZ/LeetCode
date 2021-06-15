package debugLaicode;

/*
solution:
- for each element in arr, find Map<num, list of index>  e.g. <1, [0, 1, 3...]>
- find the least steps ==> find the shortest path, apply BFS algo,


complexity:
time o(n)
space o(n)   BFS use queue

*/

import java.util.*;

public class JumpGame4 {
    private class Node {
        int i;
        int val;
        Node(int i, int val) {
            this.i = i;
            this.val = val;
        }
    }

    public int minJumps(int[] arr) {
        int len = arr.length;
        if (len == 1) return 0;

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            List<Integer> list = map.get(arr[i]);
            if (list == null) {
                list = new ArrayList<>();
                map.put(arr[i], list);
            }
            list.add(i);
        }

        // BFS
        boolean[] visit = new boolean[len];
        Queue<Node> q = new LinkedList<>();


        // initial
        q.offer(new Node(0, arr[0]));
        visit[0] = true;
        int level = 0;

        // terminate
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                // expand
                Node curr = q.poll();
                int curri = curr.i;

                // generate
                if (curri - 1 >= 0 && !visit[curri - 1]) {
                    q.offer(new Node(curri - 1, arr[curri - 1]));
                    visit[curri - 1] = true;

                }

                if (curri + 1 < arr.length && !visit[curri + 1]) {
                    q.offer(new Node(curri + 1, arr[curri + 1]));
                    visit[curri + 1] = true;

                    // jump to end
                    if (curri + 1 == len - 1) {
                        return level + 1;
                    }
                }

                List<Integer> neis = map.get(curr.val);
                for (Integer nei : neis) {
                    if (nei == curr.i) continue;
                    if (nei >= 0 && nei < arr.length && !visit[nei]) {
                        q.offer(new Node(nei, arr[nei]));
                        visit[nei] = true;

                        // jump to end
                        if (nei == len - 1) {
                            return level + 1;
                        }
                    }
                }
            }
            level++;
        }

        return -1; // cant jump to end

    }
}