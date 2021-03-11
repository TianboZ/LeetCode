package debugLaicode;

import java.util.*;

public class DeepCopyUndirectedGraph {
    public List<GraphNode> copy(List<GraphNode> graph) {
        // Write your solution here.
        Map<GraphNode, GraphNode> map = new HashMap<>();
        List<GraphNode> res = new ArrayList<>();

        for (GraphNode node : graph) {
            res.add(copy(node, map));
        }

        return res;
    }

    // input original node, return the copied node, e.g. n1 --> n1',
    // and use Map<Node, Node> key: original node  value: copied node
    // to avoid copy original node multiple times
    private GraphNode copy(GraphNode node, Map<GraphNode, GraphNode> map) {
        // basecase
        if (node == null) {
            return null;
        }
        if (map.containsKey(node)) {
            return map.get(node);

        }

        // recursive rule
        GraphNode copiedNode = new GraphNode(node.key);
        map.put(node, copiedNode);
        for (GraphNode child : node.neighbors) {
            copiedNode.neighbors.add(copy(child, map));
        }
        return copiedNode;
    }
}
