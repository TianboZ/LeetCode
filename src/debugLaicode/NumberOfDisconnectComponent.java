package debugLaicode;


import java.util.*;

class NumberOfDisconnectComponent {

    public static void main(String[] args) {
        NumberOfDisconnectComponent numberOfDisconnectComponent = new NumberOfDisconnectComponent();
        int[][] edges = {{2, 3}, {1, 2}, {1, 3}};
        //System.out.println(path);
        numberOfDisconnectComponent.countComponents(4, edges);
    }

    public int countComponents(int n, int[][] edges) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(i);
        }

        Map<Integer, Set<Integer>> map = buildGraph(edges);

        int count = 0;
        while (set.size() > 0) {
            int startPoint = -1;
            for (Integer i : set) {
                startPoint = i;
                break;
            }

            Set<Integer> visited = new HashSet<>();
            dfs(map, startPoint, visited);
            //set.remove(startPoint);
            System.out.println(visited);
            for (Integer i : visited) {
                set.remove(i);
            }
            System.out.println("aaaa");
            count++;
        }
        System.out.println(count);
        return count;
    }

    // dfs the connected graph, while deleted used vectors
    public void dfs(Map<Integer, Set<Integer>> map, int startPoint, Set<Integer> visited) {
        // base-case
        if (visited.contains(startPoint)) {
            return;
        }
        if (map.get(startPoint) == null) {
            return;
        }
        // recursive rule
        visited.add(startPoint);
        Set<Integer> nei = map.get(startPoint);
        System.out.println(startPoint);
        System.out.println(nei);

        for (Integer i : nei) {
            dfs(map, i, visited);
        }
    }
    // build graph
    public Map<Integer, Set<Integer>> buildGraph(int[][] edges) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            if (!map.containsKey(edges[i][0])) {
                Set<Integer> set = new HashSet<>();
                map.put(edges[i][0], set);
            }
            map.get(edges[i][0]).add(edges[i][1]);

            if (!map.containsKey(edges[i][1])) {
                Set<Integer> set = new HashSet<>();
                map.put(edges[i][1], set);
            }
            map.get(edges[i][1]).add(edges[i][0]);
        }
        System.out.println(map);
        return map;
    }
}