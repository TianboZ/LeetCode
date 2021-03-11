package debugLaicode;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {
    // no access modifier, default access modifier
    int key;
    List<GraphNode> neighbors;

    public GraphNode(int k) {
        key = k;
        neighbors = new ArrayList<>();
    }
}
