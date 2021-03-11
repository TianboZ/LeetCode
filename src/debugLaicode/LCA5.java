package debugLaicode;

import java.util.ArrayList;
import java.util.List;

public class LCA5 {
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

    public KnaryTreeNode lca(KnaryTreeNode root, KnaryTreeNode a, KnaryTreeNode b ) {
        // base-case
        if (root == null) {
            return null;
        }
        if (root == a || root == b) {
            return root;
        }

        // recursive rule
        int count = 0;
        KnaryTreeNode tmpt = null;

        for (KnaryTreeNode child : root.children) {
            KnaryTreeNode  res = lca(child, a, b);
            if (res != null) {
                count++;
                tmpt = res;
            }
        }

        if (count == 2) {
            return root;
        }

        return tmpt;
    }
}
