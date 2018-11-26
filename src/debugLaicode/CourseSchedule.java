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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // sanity check
        // TODO: 11/13/18

        // key: node, value: list of next nodes
        Map<Integer, List<Integer>> graph = new HashMap<>();

        // key: node  value: state
        // 0: visiting
        // 1: visited
        Map<Integer, Integer> visited = new HashMap<>();
        buildGraph(graph, prerequisites);

        for (int i = 0; i < numCourses; i++) {
            if (hasCycle(i, graph, visited)) return false;
        }
        return true;
    }

    // if has cycle, return true
    private boolean hasCycle(int node, Map<Integer, List<Integer>> graph, Map<Integer, Integer> visited) {
        // base-case
        Integer state = visited.get(node);
        if (state != null && state == 0) return true;
        if (state != null && state == 1) return false;

        // recursive rule
        visited.put(node, 0);
        if (graph.containsKey(node)) {
            for (Integer nei : graph.get(node)) {
                if (hasCycle(nei, graph, visited)) return true;
            }
        }
        visited.put(node, 1);
        return false;
    }

    // build graph
    private void buildGraph(Map<Integer, List<Integer>> graph, int[][] arr) {
        // [0, 1]    1 --> 0
        for (int[] i : arr) {
            List<Integer> list = graph.get(i[1]);
            if (list == null) {
                list = new ArrayList<>();
                graph.put(i[1], list);
            }
            list.add(i[0]);
        }
    }
}
