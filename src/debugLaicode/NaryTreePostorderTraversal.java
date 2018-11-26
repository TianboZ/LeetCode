package debugLaicode;

import java.util.ArrayList;
import java.util.List;

public class NaryTreePostorderTraversal {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        postorder(root, res);
        return res;
    }
    private void postorder(Node root, List<Integer> res) {
        if (root == null) {
            return;
        }
        for (Node child : root.children) {
            postorder(child, res);
        }
        res.add(root.val);
    }
}
