package debugLaicode;

import java.util.*;

public class CopyGraph {
    // sol1: 大班
    public List<GraphNode> copy(List<GraphNode> graph) {
        Map<GraphNode, GraphNode> visited = new HashMap<>();
        for (GraphNode node : graph) {
            dfs(node, visited);
        }
        return new ArrayList<>(visited.values());
    }
    // given a original node reference, copy it, return copied node's reference
    private GraphNode dfs(GraphNode node, Map<GraphNode, GraphNode> visited) {
        // base-case
        if (node == null) {
            return null;
        }
        if (visited.containsKey(node)) {
            return visited.get(node);
        }
        // recursive rule
        GraphNode copy = new GraphNode(node.key);
        visited.put(node, copy);
        for (GraphNode nei : node.neighbors) {
            copy.neighbors.add(dfs(nei, visited));
        }
        return copy;
    }

    //sol2: 小班
    public GraphNode cloneGraph(GraphNode node) {
        if (node == null) {
            return node;
        }
        // key: original node       value: clone node
        Map<GraphNode, GraphNode> visited = new HashMap<>();
        dfs1(node, visited);
        return visited.get(node);
    }
    private void dfs1(GraphNode node, Map<GraphNode, GraphNode> visited) {
        // base-case
        if (visited.containsKey(node)) return;

        // recursive rule
        GraphNode cloneNode = new GraphNode(node.key);
        visited.put(node, cloneNode);
        for (GraphNode nei : node.neighbors) {
            dfs1(nei, visited);
            visited.get(node).neighbors.add(visited.get(nei));
        }
    }
}

// time O(V + E)
// space O(V)
