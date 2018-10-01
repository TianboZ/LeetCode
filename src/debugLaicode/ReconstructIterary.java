package debugLaicode;

import java.util.*;

public class ReconstructIterary {
    boolean found = false;
    List<String> res = null;
    String START = "JFK";

    public List<String> findItinerary(String[][] tickets) {
        // build graph, key: start airport  value: set of next stop
        Map<String, List<Node>> map = new HashMap<>();
        buildGraph(tickets, map);
        List<String> path = new ArrayList<>();
        path.add(START);
        dfs(path, map, START, tickets.length + 1);
        return res;
    }

    class Node{
        String airport;
        boolean used;
        Node (String airport, boolean used) {
            this.airport = airport;
            this.used = used;
        }
    }

    private void dfs(List<String> path, Map<String, List<Node>> map, String start, int size) {
        // base-case
        if (found) return;

        if (path.size() == size) {
            found = true;
            res = new ArrayList<>(path);
            return;
        }
        // recursive rule
        List<Node> nexts = map.get(start);
        if (nexts != null) {
            for (Node next : nexts) {
                if (next.used) continue;

                path.add(next.airport);
                next.used = true;
                dfs(path, map, next.airport, size);
                path.remove(path.size() - 1);
                next.used = false;
            }
        }

    }

    private void buildGraph(String[][] tickets, Map<String, List<Node>> map) {
        for (int i = 0; i < tickets.length; i++) {

            if (!map.containsKey(tickets[i][0])) {
                map.put(tickets[i][0], new ArrayList<>());
            }
            map.get(tickets[i][0]).add(new Node(tickets[i][1], false));
        }
        for (Map.Entry<String, List<Node>> entry : map.entrySet()) {
            Collections.sort(entry.getValue(), new MyCp());
        }
    }

    class MyCp implements Comparator<Node> {
        @Override
        public int compare(Node n1, Node n2) {
            return n1.airport.compareTo(n2.airport);
        }
    }

    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<>();
        set.add(2);
        set.add(3);
        set.add(0);
        set.add(100);

        for (Integer i : set) {
            int a = i;
            System.out.println(a);
        }

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
    }

}
