package debugLaicode;

/*
solution:

    Map<key: node, value: list of next nodes> to represent graph

    using Depth first search algorithm to detect cycle
    each node has 3 states: visited, visiting, unvisited

    detect cycle in the graph

    0: 1, 2, 3
    1: 3
    2: 3
    //3: 0

    0  visiting -  visited
    /                           \                               \
   1 visiting - visited         2 - visiting - visited          3 visited
   /                            \
   3 visiting - visited         3 - visited

    time O(v + e)
    space O(v)  callstack space


*/

import java.util.*;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        Map<Integer, Integer> visit = new HashMap<>();
        // key: node  value: status, 0: visiting  1: visited

        Map<Integer, Set<Integer>> graph = new HashMap<>();
        buildGrpah(prerequisites, graph, numCourses);

        for (int i = 0; i < numCourses; i++) {
            if (hasCycle(visit, graph, i)) {
                return false;
            }
        }
        return true;
    }

    private void buildGrpah(int[][] pre,  Map<Integer, Set<Integer>> graph, int n) {
        for (int i = 0; i < n; i++) {
            graph.put(i, new HashSet<>());
        }
        // todo
        for (int[] arr : pre) {
            graph.get(arr[1]).add(arr[0]);
        }
    }

    private boolean hasCycle(Map<Integer, Integer> visit,
                             Map<Integer, Set<Integer>> graph, int node) {
        // base case
        if (visit.get(node) == Integer.valueOf(1)) return false;
        if (visit.get(node) == Integer.valueOf(0)) return true;

        // recursive rule
        visit.put(node, 0);
        Set<Integer> neis = graph.get(node);

        for (Integer nei : neis) {
            if (hasCycle(visit, graph, nei)) return true;
        }

        visit.put(node, 1);
        return false;
    }
}
