package debugLaicode;

import java.util.*;

public class NumberOfConnectedComponentsInAnUndirectedGraph {
    Map<Integer, Set<Integer>> map = new HashMap<>();
    Set<Integer> visit = new HashSet<>();

    public int countComponents(int n, int[][] edges) {
        // Write your solution here
        buildGraph(edges, n);
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!visit.contains(i)) {
                count++;
                dfs(i);
                visit.add(i);
            }
        }
        return count;
    }

    // traverse graph
    private void dfs(int n) {
        if (visit.contains(n))
            return;

        visit.add(n);

        for (Integer nei : map.get(n)) {
            dfs(nei);
        }

    }

    private void buildGraph(int[][] edges, int n) {
        for (int i = 0; i < n; i++) {
            map.put(i, new HashSet<>());
        }
        for (int[] e : edges) {
            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);
        }
    }
}
