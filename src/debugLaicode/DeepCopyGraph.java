package debugLaicode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeepCopyGraph {
    public List<GraphNode> copy(List<GraphNode> graph) {
        System.out.println(graph);
        if (graph == null) {
            return null;
        }
        // Write your solution here.
        Map<GraphNode, GraphNode> lookup = new HashMap<>();
        List<GraphNode> result = new ArrayList<>();
        for(GraphNode node : graph) {
            //if (!lookup.containsKey(node)) {
                //lookup.put(node, new GraphNode(node.key));
                result.add(dfs(node, lookup));
            //}
        }

        print(graph);
        System.out.println("ddddddd");
        print(result);

        return result;
    }

    public void print(List<GraphNode> graph) {
        for (GraphNode node : graph) {
            System.out.println("node value: " + node.key);
            for (GraphNode nei : node.neighbors) {
                System.out.println(nei.key);
            }
        }
    }

    public GraphNode dfs(GraphNode input, Map<GraphNode, GraphNode> lookup) {
        // base-case
        if (input == null) {
            return null;
        }

        if (lookup.containsKey(input)) {
            return lookup.get(input);
        }

        // recursive rule
        GraphNode copyNode = new GraphNode(input.key);
        lookup.put(input, copyNode);
        //result.add(copyNode);
        for (GraphNode nei : input.neighbors) {
            System.out.println("nei value: " + nei.key);
            copyNode.neighbors.add(dfs(nei, lookup));
        }

        return copyNode;
    }
}
