package debugLaicode;

import java.util.*;

public class CheapestFlightsWithinKStops {
    Map<Integer, List<int[]>> map = new HashMap<>();
    Set<Integer> visit = new HashSet<>();
    int min = Integer.MAX_VALUE;

    public int findCheapestPrice2(int n, int[][] flights, int src, int dst, int k) {
        buildGraph(flights);
        //System.out.println(map);
        dfs(src, dst, k + 1, 0, 0);
        return min == Integer.MAX_VALUE ? - 1 : min;
    }

    private void buildGraph(int[][] flights) {
        for (int[] f: flights) {
            List<int[]> list = map.get(f[0]);
            if (list == null) {
                list = new ArrayList<>();
                map.put(f[0], list);
            }
            list.add(new int[] {f[1], f[2]});
        }
    }

    private void dfs (int src, int end, int k, int cnt, int sum) {
        // base case
        if (sum > min) return; // pruning

        if (visit.contains(src)) return;

        if (cnt == k || src == end) {
            if (src == end) {
                min = Math.min(min, sum);
            }
            return;
        }

        // recursive rule
        visit.add(src);
        List<int[]> neis = map.get(src);
        if (neis != null) {
            for (int[] nei : neis) {
                dfs(nei[0], end, k, cnt + 1, sum + nei[1]);
            }
        }

        visit.remove(src);
    }

    // 2018
    // DFS + cache
    //private int min = Integer.MAX_VALUE;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        // build graph      key = start   value = list of next stop
        Map<Integer, List<Node>> map = new HashMap<>();
        for (int[] flight : flights) {
            if (map.containsKey(flight[0])) {
                map.get(flight[0]).add(new Node(flight[1], flight[2]));
            } else {
                List<Node> list = new ArrayList<>();
                list.add(new Node(flight[1], flight[2]));
                map.put(flight[0], list);
            }
        }


        boolean[] visited = new boolean[n];
        int[] cache = new int[n];
        dfs(map, src, dst, K, -1, 0, visited);
        return min == Integer.MAX_VALUE ? -1 : min;
    }
    // traverse all paths from start
    private void dfs(Map<Integer, List<Node>> map, int start, int end, int k, int stops, int price, boolean[] visited) {
        // base-case
        if (start == end) {
            min = Math.min(min, price);
            return;
        }
        if (stops >= k) {
            return;
        }
        if (visited[start]) {
            return;
        }
        // recursive rule
        visited[start] = true;
        List<Node> nodes = map.get(start);
        if (nodes != null) {
            for (Node node : nodes) {
                dfs(map, node.next, end, k, stops + 1, price + node.price, visited);
            }
        }
        // backing tracking
        visited[start] = false;
    }
    private class Node {
        // fields
        private int next;
        private int price;
        // constructor
        private Node(int next, int price) {
            this.next = next;
            this.price = price;
        }
    }

    public static void main(String[] args) {
        int[][] flighs = {{0,1,100},{1,2,100},{0,2,500}};
        CheapestFlightsWithinKStops cheapestFlightsWithinKStops = new CheapestFlightsWithinKStops();
        int res = cheapestFlightsWithinKStops.findCheapestPrice(3, flighs, 0, 2, 1);
        System.out.println(res);
    }
}