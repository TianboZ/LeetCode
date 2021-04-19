package debugLaicode;

import java.util.*;

public class CloneNaryTree {
    private static class Node {
        public int val;
        public List<Node> children;


        public Node() {
            children = new ArrayList<>();
        }

        public Node(int _val) {
            val = _val;
            children = new ArrayList<>();
        }

        public Node(int _val,ArrayList<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    public Node cloneTree(Node root) {

        Map<Node, Node> visit = new HashMap<>();
        return dfs(visit, root);
    }

    private Node dfs(Map<Node, Node> visit, Node node) {
        // base case
        if (node == null) return null;
        if (visit.containsKey(node)) return visit.get(node);

        // recursive rule
        Node copy = new Node(node.val);
        visit.put(node, copy);

        for (Node nei : node.children) {
            copy.children.add(dfs(visit, nei));
        }

        return copy;
    }
}
