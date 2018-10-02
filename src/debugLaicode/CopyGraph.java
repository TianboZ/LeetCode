package debugLaicode;

import java.util.*;

public class CopyGraph {
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
}
