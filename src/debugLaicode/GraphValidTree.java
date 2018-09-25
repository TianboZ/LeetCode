package debugLaicode;

import java.util.*;

public class GraphValidTree {
    public boolean validTree(int n, int[][] edges) {
        // key: parent       value： list of neighbors
        Map<Integer, Set<Integer>> graph = buildGraph(edges, n);
        // each node has three state   unvisited     visited : 0      visiting : 1
        Map<Integer, Integer> state = new HashMap<>();
        int count = 0; // count the component area

        for (int i = 0; i < n; i++) {
            if (state.get(i) == null) {
                count++;
                if(!dfs(graph, state, i, null)) {
                    return false;
                }
            }
        }
        System.out.println(count);
        return count == 1; // if only one component area, then it is tree
    }

    // if no cycle, return true;
    private boolean dfs(Map<Integer, Set<Integer>> graph, Map<Integer, Integer> state, int curr, Integer parent) {
        // base-case
        if (state.containsKey(curr)) {
            if (state.get(curr) == 1) {
                return false;
            }
            if (state.get(curr) == 0) {
                return true;
            }
        }

        // recursive rule
        state.put(curr, 1);
        for (Integer nei : graph.get(curr)) {
            // if the neighbor is parent, then skip it
            if (parent != null && parent == nei) continue;
            if(!dfs(graph, state, nei, curr)) {
                return false;
            }
        }
        state.put(curr, 0);
        return true;
    }
    // build graph
    private Map<Integer, Set<Integer>> buildGraph(int[][] edges, int n) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new HashSet<>());
        }

        // build grpah
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        return graph;
    }
}
