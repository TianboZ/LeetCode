package debugLaicode;

import java.util.*;

//https://app.laicode.io/app/problem/323
public class DepthOfForest {
    //so1: two passes
    // time o(n)
    // space o(n)
    public int depth(int[] forest) {
        // Write your solution here
        Map<Integer, Set<Integer>> g = new HashMap<>();
        buildGraph(g, forest);
        int max = 0;
        Map<Integer, Integer> visit = new HashMap<>();  // 1: visiting   0: visited
        Map<Integer, Integer> cache = new HashMap<>();

        // check cycle
        for (Integer node : g.keySet()) {
            if (dfs(g, node, visit)) return -1;
        }

        // get max depth
        for (Integer node : g.keySet()) {
            max = Math.max(max, getHeight(g, node, cache));
        }
        return max;
    }

    private int getHeight(Map<Integer, Set<Integer>> g, int n, Map<Integer, Integer> cache) {
        // basecase
        if (cache.containsKey(n)) return cache.get(n);

        // recursive rule
        int dis = 0;
        Set<Integer> neis  = g.get(n);
        if (neis != null) {
            for (Integer nei : neis) {
                dis = Math.max(dis, getHeight(g, nei, cache));
            }
        }
        cache.put(n, dis + 1);
        return dis + 1;
    }

    // return true if cycle
    private boolean dfs(Map<Integer, Set<Integer>> g, int n, Map<Integer, Integer> visit) {
        // base case
        Integer state = visit.get(n);
        if (state != null && state == 1) return true;
        if (state != null && state == 0) return false;

        // recusive rule
        visit.put(n, 1);
        Set<Integer> neis  = g.get(n);
        if (neis != null) {
            for (Integer nei : neis) {
                if (dfs(g, nei, visit)) return true;
            }
        }
        visit.put(n, 0);
        return false;
    }

    private void buildGraph(Map<Integer, Set<Integer>> g, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != -1) {
                g.put(arr[i], new HashSet<>());
            } else {
                g.put(i, new HashSet<>());
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                continue;
            }
            g.get(arr[i]).add(i);
        }
    }
    // sol2: one pass, pure recursion + memo, xiaoban
}
