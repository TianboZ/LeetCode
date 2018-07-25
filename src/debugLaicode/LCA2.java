package debugLaicode;

import java.util.HashSet;
import java.util.Set;

public class LCA2 {
    public TreeNodeP lowestCommonAncestor(TreeNodeP one, TreeNodeP two) {
        // Write your solution here.
        Set<TreeNodeP> parents = new HashSet<>();
        getAllParent(one, parents);
        return lca(parents, two);
    }
    private void getAllParent(TreeNodeP root, Set<TreeNodeP> parents) {
        while (root != null) {
            parents.add(root);
            root = root.parent;
        }
    }
    private TreeNodeP lca(Set<TreeNodeP> parents, TreeNodeP root) {
        while (root != null) {
            if (parents.contains(root)) {
                return root;
            }
            root = root.parent;
        }
        return null;
    }

    private class TreeNodeP {
        // fields
        public int key;
        public TreeNodeP left;
        public TreeNodeP right;
        public TreeNodeP parent;

        // constructor
        public TreeNodeP(int key, TreeNodeP parent) {
            this.key = key;
            this.parent = parent;
        }
    }
}
