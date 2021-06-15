package debugLaicode;

import java.util.*;


/*
topological sort

[a, b]

a --> b    a depends on b


solution:
- build dependency graph
- run topologicial sort

*/


public class CourseSchedule2 {
    Map<Integer, Set<Integer>> map = new HashMap<>();
    Map<Integer, Integer> state = new HashMap<>(); // key: node  value: 1, visited   0: visiting

    boolean isCycle;
    List<Integer> res = new ArrayList<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        buildGraph(prerequisites, numCourses);

        for (int i = 0; i < numCourses; i++) {
            dfs(i);
        }

        // build ans
        int[] ans = new int[res.size()];

        if (isCycle) return new int[]{};
        for (int i = 0; i < ans.length; i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }

    // DFS2
    private void dfs(int n) {
        // base case
        Integer i = state.get(n);
        if (i != null) {
            if (i == 0) {
                // cycle
                isCycle = true;
                return;
            }
            return;
        }

        // recursive rule
        state.put(n, 0);
        for(Integer nei: map.get(n)) {
            dfs(nei);
        }
        state.put(n, 1);
        res.add(n);

    }
    private void buildGraph(int[][] pre, int n) {
        for (int i = 0; i < n; i++) {
            map.put(i, new HashSet<>());
        }
        for (int[] course: pre) {
            map.get(course[0]).add(course[1]);
        }
    }
}
