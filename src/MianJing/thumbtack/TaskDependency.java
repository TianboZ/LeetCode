package MianJing.thumbtack;

import java.util.*;

public class TaskDependency {
    public boolean canFinish(int numTasks, Map<Integer, List<Integer>> graph) {
        // sanity check
        // TODO: 11/13/18

        // key: node  value: state
        // 0: visiting
        // 1: visited
        Map<Integer, Integer> visited = new HashMap<>();

        for (int i = 0; i < numTasks; i++) {
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


    public static void main(String[] args) {
        TaskDependency taskDependency = new TaskDependency();
        /*
         *  0: 1, 2, 3
         *  1: 3
         *  2: 3
         *  3: 0 // cycle
         *
         *
         * */

        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(1, 2, 3));
        graph.put(1, Arrays.asList(3));
        graph.put(2, Arrays.asList(3));
        //graph.put(3, Arrays.asList(0));

        boolean res = taskDependency.canFinish(4, graph);
        System.out.println(res);
    }
}
