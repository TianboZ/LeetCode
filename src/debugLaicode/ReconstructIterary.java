package debugLaicode;

import java.util.*;

public class ReconstructIterary {
    boolean found = false;
    List<String> res = null;

    public List<String> findItinerary(String[][] tickets) {
        // build graph, key: start airport  value: set of destination
        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < tickets.length; i++) {
            if (!map.containsKey(tickets[i][0])) {
                map.put(tickets[i][0], new ArrayList<>());
            }
            map.get(tickets[i][0]).add(tickets[i][1]);
        }

        for (List<String> list : map.values()) {
            Collections.sort(list);
        }

        List<String> path = new ArrayList<>();
        path.add("JFK");
        dfs(path, map, "JFK", tickets.length + 1);
        return res;
    }

    private void dfs(List<String> path, Map<String, List<String>> map, String start, int size) {
        // base-case
        if (found) return;

        if (path.size() == size) {
            found = true;
            res = new ArrayList<>(path);
            return;
        }
        // recursive rule
        if (map.containsKey(start)) {
            List<String> next = map.get(start);
            for (int i = 0; i < next.size(); i++) {
                String dest = next.get(i);
                path.add(dest);
                next.remove(i);
                dfs(path, map, dest, size);
                path.remove(path.size() - 1);
                next.add(i, dest);
            }
        }
    }
}
