package debugLaicode;

import java.util.*;

/*
 check:
* 1. no cycle
* 2. connected
*
* */
class GraphValidTree {

    Map<Integer, Set<Integer>> g = new HashMap<>();
    Map<Integer, Integer> state = new HashMap<>();
    // key: node       value: node state,  1 : visiting   0 : visited

    public boolean validTree2(int n, int[][] edges) {
        buildGraph(n, edges);
        //System.out.println(g);
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            //System.out.println(state);
            if (!state.containsKey(i)) {
                if(dfs(i, null)) return false;
                cnt++;
                if (cnt >= 2) return false;
            }
        }
        return true;
    }

    // return true if has cycle
    private boolean dfs(int node, Integer prevNode) {
        //System.out.println(node);
        Integer i = state.get(node);

        if (i != null) {
            if (i == 1) return true;
            if (i == 0) return false;
        }

        state.put(node, 1);
        for (Integer nei : g.get(node)) {
            //System.out.println(nei);
            if (prevNode != null && nei == prevNode) continue;
            if (dfs(nei, node)) return true;
        }
        state.put(node, 0);
        return false;
    }
    private void buildGraph(int n, int[][] edges) {
        for (int i = 0; i < n; i++) {
            g.put(i, new HashSet<>());
        }
        for (int[] e: edges) {
            g.get(e[0]).add(e[1]);
            g.get(e[1]).add(e[0]);
        }
    }



    // -------------------------------------------------
    public boolean validTree(int n, int[][] edges) {
        // build graph
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new HashSet<>());
        }
        for (int[] e : edges) {
            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);
        }

        Set<Integer> visit = new HashSet<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visit.contains(i)) {
                if (hasCycle(map, i, -1, visit)) return false;
                count++;
                if (count > 1) return false;
            }
        }
        return true;
    }
    private boolean hasCycle(Map<Integer, Set<Integer>> map, int curr, int prev, Set<Integer> visit) {
        // base case
        if (visit.contains(curr)) return true;

        // recursive rule
        visit.add(curr);
        Set<Integer> neis = map.get(curr);
        if (neis != null) {
            for (Integer nei : neis) {
                if (nei != prev) {
                    if (hasCycle(map, nei, curr, visit)) return true;
                }
            }
        }

        return false;
    }
}

// time o(V + E)   V == n
// space O(V)