package debugLaicode;

import java.util.*;

public class CopyGraph {
    public List<GraphNode> copy(List<GraphNode> graph) {
        Map<GraphNode, GraphNode> lookup = new HashMap<>();
        for (GraphNode node : graph) {
            dfs(node, lookup);
        }
        return new ArrayList<>(lookup.values());
    }
    // given a original node reference, copy it, return copied node's reference
    private GraphNode dfs(GraphNode node, Map<GraphNode, GraphNode> lookup) {
        // base-case
        if (node == null) {
            return null;
        }
        if (lookup.containsKey(node)) {
            return lookup.get(node);
        }
        // recursive rule
        GraphNode copy = new GraphNode(node.key);
        lookup.put(node, copy);
        for (GraphNode nei : node.neighbors) {
            copy.neighbors.add(dfs(nei, lookup));
        }
        return copy;
    }
}
