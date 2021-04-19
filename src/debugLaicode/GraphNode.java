package debugLaicode;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {
    // no access modifier, default access modifier
    int key;
    List<GraphNode> neighbors;

    public GraphNode(int _key) {
        key = _key;
        neighbors = new ArrayList<>();
    }
}
