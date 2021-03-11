package debugLaicode;

import debugLaicode.LCA5;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LCA6 {
    private static class KnaryTreeNode {
        // fields
        int key;
        List<KnaryTreeNode> children;

        // constructors
        public KnaryTreeNode(int key) {
            this.key = key;
            this.children = new ArrayList<>();
        }
    }
    public KnaryTreeNode lowestCommonAncestor(KnaryTreeNode root, List<KnaryTreeNode> nodes) {
        // Write your solution here
        Set<KnaryTreeNode> set = new HashSet<>(nodes);
        return lca(root, set);
    }
    private KnaryTreeNode lca(KnaryTreeNode root, Set<KnaryTreeNode> nodes) {
        // basecase
        if (root == null) {
            return null;

        }
        if (nodes.contains(root)) {
            return root;
        }
        // rule
        int count = 0;
        KnaryTreeNode tmpt = null;
        for (KnaryTreeNode child : root.children) {
            KnaryTreeNode node = lca(child, nodes);
            if (node != null) {
                count++;
                tmpt = node;
            }
        }

        if (count >= 2) {
            return root;
        }

        return tmpt;
    }
}
