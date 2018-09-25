package debugLaicode;

import java.util.*;

public class CourseSchedule2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // build graph,  key: course number   value: courses that depend on 'key'
        Map<Integer, List<Integer>> map = new HashMap<>();
        buildGraph(prerequisites, map);

        // each course state    key: course  value: state    0 is visited   1 is visiting
        Map<Integer, Integer> state = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(map, state, stack, i)) {
                int[] arr = new int[0];
                return arr;
            }
        }

        int[] res = new int[numCourses];
        int i = 0;
        while (!stack.isEmpty()) {
            res[i] = stack.pop();
            i++;
        }
        return res;
    }
    private void buildGraph(int[][] pre, Map<Integer, List<Integer>> map) {
        // build graph
        for (int i = 0; i < pre.length; i++) {
            if (map.containsKey(pre[i][1])) {
                map.get(pre[i][1]).add(pre[i][0]);
            } else {
                List<Integer> nei = new ArrayList<>();
                nei.add(pre[i][0]);
                map.put(pre[i][1], nei);
            }
        }
    }
    // topoloty sort, if find the cycle, then return false;
    public boolean dfs(Map<Integer, List<Integer>> map, Map<Integer, Integer> state, Stack<Integer> stack, int node) {
        // base-case
        // 0: visited
        // 1: visiting, means detect cycle!
        if (state.containsKey(node)) {
            if (state.get(node) == 0) {
                return true;
            }
            if (state.get(node) == 1) {
                return false;
            }
        }

        // recursive rule
        state.put(node, 1);
        if (map.containsKey(node)) {
            for (Integer nei: map.get(node)) {
                if (!dfs(map, state, stack, nei)) {
                    return false;
                }
            }
        }

        stack.push(node);
        state.put(node, 0);
        return true;
    }
}
