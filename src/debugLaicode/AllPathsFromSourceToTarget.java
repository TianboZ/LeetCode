package debugLaicode;

import java.util.*;

public class AllPathsFromSourceToTarget {
    Set<Integer> visit = new HashSet<>();
    List<Integer> path = new ArrayList<>();
    Map<Integer, Set<Integer>> graph = new HashMap<>();
    List<List<Integer>> res = new ArrayList<>();
    int target = 0;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        buildGraph(graph);
        target = graph.length - 1;
        dfs(0);
        return res;
    }

    private void dfs(int root) {
        // base case
        if (visit.contains(root)) return;

        // recursive rule
        //visit.add(root);
        path.add(root);
        if (root == target) {
            res.add(new ArrayList<>(path));
        }
        for (Integer nei: graph.get(root)) {
            dfs(nei);
        }
        //visit.remove(root);
        path.remove(path.size() - 1);
    }

    private void buildGraph(int[][] g) {
        for (int i = 0; i < g.length; i++) {
            graph.put(i, new HashSet<>());
            for (int nei : g[i]) {
                graph.get(i).add(nei);
            }
        }
    }
}
