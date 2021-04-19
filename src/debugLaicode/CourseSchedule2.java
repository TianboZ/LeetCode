package debugLaicode;

import java.util.*;

public class CourseSchedule2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        buildGraph(graph, prerequisites, numCourses);

        Map<Integer, Integer> state = new HashMap<>();  // 1: visiting 0: visited
        Deque<Integer> stack = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (dfs(graph, state, i, stack)) {
                return new int[]{};
            }
        }

        int[] res = new int[stack.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = stack.pollFirst();
        }
        return res;
    }

    // return true is has cycle
    private boolean dfs(
            Map<Integer, List<Integer>> graph,
            Map<Integer, Integer> state,
            int node,
            Deque<Integer> stack

    ) {
        // base case
        Integer i = state.get(node);
        if (i != null) {
            if (i == 1) return true;
            if (i == 0) return false;
        }

        // recursive rule
        state.put(node, 1);
        List<Integer> neis = graph.get(node);
        for (Integer nei : neis) {
            if (dfs(graph, state, nei, stack)) {
                return true;
            }
        }
        state.put(node, 0);
        stack.offerFirst(node);
        return false;
    }
    private void buildGraph(Map<Integer, List<Integer>> graph, int[][] m, int n) {
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] arr : m) {
            graph.get(arr[1]).add(arr[0]);
        }
    }
}
