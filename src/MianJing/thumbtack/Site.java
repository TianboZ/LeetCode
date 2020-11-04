package MianJing.thumbtack;


import java.util.*;

public class Site {
    // n is number of nodes, from 0 to n-1
    public void markGraph(int[][] input, int[] deadSites, int n) {
        // sanity check
        // TODO: 11/16/18

        // key: node  value: list of parent nodes
        Map<Integer, List<Integer>> map = new HashMap<>();
        buildGraph(map, input);
        System.out.println(map);


        Set<Integer> visited = new HashSet<>();
        for (int i : deadSites) {
            traverse(i, map, visited);
        }

        System.out.println(visited);
    }

    private void traverse(int node, Map<Integer, List<Integer>> map, Set<Integer> visited) {
        // base-case
        if (visited.contains(node)) return;


        // recursive rule
        visited.add(node);
        if (map.containsKey(node)) {
            for (Integer parent : map.get(node)) {
                traverse(parent, map, visited);
            }
        }
    }
    private void buildGraph(Map<Integer, List<Integer>> map, int[][] input) {
        for (int i = 0; i < input.length; i++) {
            if (input[i].length == 0) continue;

            int parent = i;
            for (int j = 0; j < input[i].length; j++) {
                int node = input[i][j];
                List<Integer> parents = map.get(node);
                if (parents == null) {
                    parents = new ArrayList<>();
                    map.put(node, parents);
                }
                parents.add(parent);
            }
        }

    }

    public static void main(String[] args) {
        int[][] arr = {{1,2}, {3, 4}, {4,5}, {}, {5}};
        Site site = new Site();
        site.markGraph(arr, new int[] {4,5}, 6);
    }
}