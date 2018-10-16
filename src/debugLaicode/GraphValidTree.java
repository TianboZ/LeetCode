package debugLaicode;

import java.util.*;

class GraphValidTree {
    public boolean validTree(int n, int[][] edges) {
        // key: parent       value： list of neighbors
        Map<Integer, List<Integer>> graph = buildGraph(edges, n);

        // mark visited
        List<Integer> visited = new ArrayList<>();

        // count the component area
        int count = 0;

        // iterate each node
        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                count++;
                if(hasCycle(graph, visited, i, null)) {
                    return false;
                }
            }
        }
        //System.out.println(count);
        return count == 1; // if only one component area, then it is tree
    }

    private boolean hasCycle(Map<Integer, List<Integer>> graph, List<Integer> visited, Integer curr, Integer prev) {
        // base-case
        if (visited.contains(curr)) return true;

        // recursive rule
        visited.add(curr);
        for (Integer nei : graph.get(curr)) {
            if (prev != nei && hasCycle(graph, visited, nei, curr)) return true;
        }
        return false;
    }


    // build graph
    private Map<Integer, List<Integer>> buildGraph(int[][] edges, int n) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        // build grpah
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        return graph;
    }
}

// time o(V + E)   V == n
// space O(V)