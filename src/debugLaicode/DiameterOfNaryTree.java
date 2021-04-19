package debugLaicode;

import java.util.*;

public class DiameterOfNaryTree {
    class Node {
        public int val;
        public List<Node> children;


        public Node() {
            children = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            children = new ArrayList<Node>();
        }

        public Node(int _val,ArrayList<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    int max;
    public int diameter(Node root) {
        // Write your solution here
        getHeight(root);
        return max;
    }
    private int getHeight(Node root) {
        if (root == null) return 0;

        // find two longest path among n subtrees
        int max1 = 0;
        int max2 = 0;  // max1 >= max2
        for (Node child : root.children) {
            int tmp = getHeight(child);
            if (tmp > max1) {
                max2 = max1;
                max1 = tmp;
            } else if (tmp > max2) {
                max2 = tmp;
            }
        }

        max = Math.max(max, max1 + max2);
        return max1 + 1;
    }
}
