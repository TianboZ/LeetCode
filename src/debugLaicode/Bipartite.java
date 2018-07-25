package debugLaicode;

import java.util.*;

public class Bipartite {

    public boolean isBipartite(List<GraphNode> graph) {
        if (graph == null || graph.size() == 0) {
            return true;
        }

        // use -1 and 1 to different each node
        Map<GraphNode, Integer> visited = new HashMap<>();


        // the graph can ge represented as a path of GraphNode, no matter if it is connected or not
        // bfs to traverse the graph from each node
        for (GraphNode node : graph) {
//            if (!bfs(node, visited)) {
//                return false;
//            }

            if (!dfs(visited, node, 1)) {
                return false;
            }
        }

        return true;
    }

    // bfs from node, if it is not bipartite, return false
    private boolean bfs(GraphNode node, Map<GraphNode, Integer> visited) {
        Queue<GraphNode> q = new LinkedList();
        // initial
        q.offer(node);
        // start bfs from this node, since this node has not been visited, we can assign it to any of the
        // groups, like group -1
        visited.put(node, -1);

        while (!q.isEmpty()) {
            // expand
            GraphNode curr = q.poll();
            // the group of curr node
            int val = visited.get(curr);

            // generate rule
            for (GraphNode nei : curr.neighbors) {
                if (!visited.containsKey(nei)) { // case1
                    visited.put(nei, (-1) * val);
                    q.offer(nei);
                } else if (visited.containsKey(nei) && visited.get(nei) == val) { // case2
                    return false;
                } else {
                    continue; // case3
                }
            }
        }

        return true;
    }

    private boolean dfs(Map<GraphNode, Integer> visited, GraphNode node, int flag) {
        // base-case
        if (visited.containsKey(node)) {
            return true;
        }
        // recursive rule
        visited.put(node, flag);
        for (GraphNode nei : node.neighbors) {
            Integer num = visited.get(nei);
            if (num == null) {
                if (!dfs(visited, nei, -1 * flag)) {
                    return false;
                }
            } else if (num == flag) {
                return false;
            } else if (num == flag * -1) {
                continue;
            }
        }
        return true;
    }

    public boolean bfs(Map<GraphNode, Integer> visited, GraphNode node) {
        if (visited.containsKey(node)) {
            return true;
        }
        Queue<GraphNode> queue = new LinkedList<>();
        // initial
        queue.offer(node);
        visited.put(node, 1);

        while (!queue.isEmpty()) {
            // expand
            GraphNode cur = queue.poll();
            int curVal = visited.get(cur);

            // generate
            for (GraphNode nei : cur.neighbors) {
                if (visited.containsKey(nei)) {
                    if (visited.get(nei) == curVal) {
                        return false;
                    } else {
                        continue;
                    }
                } else {
                    queue.offer(nei);
                    visited.put(nei, curVal * (-1));
                }
            }
        }
        return true;
    }



    public static void main(String[] args) {
        GraphNode node1 = new GraphNode(1);
        GraphNode node2 = new GraphNode(2);
        GraphNode node3 = new GraphNode(3);
        GraphNode node4 = new GraphNode(4);


//        1----2
//         \
//          \
//           \
//            \
//        4----3


        node1.neighbors.add(node2);
        node1.neighbors.add(node3);
        node2.neighbors.add(node1);
        node3.neighbors.add(node1);
        node3.neighbors.add(node4);
        node4.neighbors.add(node3);

        List<GraphNode> list = new ArrayList<>();
        list.add(node1);
        list.add(node2);
        list.add(node3);
        list.add(node4);

        Bipartite bipartite = new Bipartite();
        boolean res = bipartite.isBipartite(list);
        System.out.println(res);
    }
}
