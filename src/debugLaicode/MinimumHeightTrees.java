package debugLaicode;


import java.util.*;

public class MinimumHeightTrees {
    // sol1:
    // build graph using HashMap<Integer, Set<Integer>>, key: node   value: set of neighbors
    // for each node, use it as root, traverse the graph from this node, find the depth
    // store all the result in the HashMap<Integer, Integer>, key: node  value: depth
    // iterate the HashMap to find roots that they have max depth
    // time O(n *(V+E))
    int min = Integer.MAX_VALUE;

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            if (map.containsKey(edges[i][0])) {
                map.get(edges[i][0]).add(edges[i][1]);
            } else {
                List<Integer> neis = new ArrayList<>();
                neis.add(edges[i][1]);
                map.put(edges[i][0], neis);
            }

            if (map.containsKey(edges[i][1])) {
                map.get(edges[i][1]).add(edges[i][0]);
            } else {
                List<Integer> neis = new ArrayList<>();
                neis.add(edges[i][0]);
                map.put(edges[i][1], neis);
            }
        }
        //System.out.println(map);
        // key: node  value: depth
        Map<Integer, Integer> record = new HashMap<>();
        for (int i = 0; i < n; i++) {
            bfs(map, i, record);
        }
        //System.out.println(record);


        List<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : record.entrySet()) {
            if (entry.getValue() == min) {
                res.add(entry.getKey());
            }
        }
        return res;

    }

    private void bfs(Map<Integer, List<Integer>> map, int node, Map<Integer, Integer> record) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        visited.add(node);
        int depth = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                // expand
                int newNode = queue.poll();

                // generate rule
                if (map.containsKey(newNode)) {
                    for (Integer nei : map.get(newNode)) {
                        if (!visited.contains(nei)) {
                            queue.offer(nei);
                            visited.add(nei);
                        }
                    }
                }

            }
            depth++;
            if (depth > min) return; // prunning
        }
        min = Math.min(min, depth);
        record.put(node, depth);
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////
    // sol2:
    //iteratively delete the leaves, until there are <= 2 nodes remains in the graph, then they are solution
    public List<Integer> findMinHeightTrees1(int n, int[][] edges) {
        List<Integer> res= new ArrayList<>();

        // build graph
        Map<Integer, Set<Integer>> map = new HashMap<>();
        buildGraph(edges, map);

        // if a node is leaf, then its neighbor should has only one
        Set<Integer> leaves = new HashSet<>();
        while (map.size() > 2) {
            leaves.clear();
            for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
                if (entry.getValue().size() == 1) leaves.add(entry.getKey());
            }
            for (Integer leaf : leaves) {
                map.remove(leaf);
            }
            for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
                for (Integer leaf : leaves) {
                    entry.getValue().remove(leaf);
                }
            }
        }

        // the remains entry in the map will be the solutuion

        for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
            res.add(entry.getKey());
        }
        if (res.size() == 0) res.add(0);
        return res;
    }
    private void buildGraph(int[][] edges, Map<Integer, Set<Integer>> map) {
        for (int[] edge : edges) {
            Set<Integer> neighbor = map.get(edge[0]);
            if (neighbor == null) {
                map.put(edge[0], new HashSet<>());
            }
            map.get(edge[0]).add(edge[1]);

            neighbor = map.get(edge[1]);
            if (neighbor == null) {
                map.put(edge[1], new HashSet<>());
            }
            map.get(edge[1]).add(edge[0]);
        }
    }
}

