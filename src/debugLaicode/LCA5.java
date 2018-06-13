package debugLaicode;

import java.util.ArrayList;
import java.util.List;

public class LCA5 {
    static class TreeNode {
        // fields
        int key;
        List<TreeNode> children;

        // constructors
        public TreeNode(int key) {
            this.key = key;
            this.children = new ArrayList<>();
        }
    }

    public TreeNode lca(TreeNode root, List<TreeNode> nodes) {
        // base-caes
        if (root == null) {
            return root;
        }
        if (nodes.contains(root)) {
            return root;
        }
        // recursive rule
        int count = 0;
        TreeNode tmp = null;
        for (TreeNode child : root.children) {
            tmp = lca(child, nodes);
            if (tmp != null) {
                count++;
            }
        }
        if (count == 1) {
            return tmp;
        } else if (count >= 2) {
            return root;
        } else if (count == 0) {
            return null;
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode node0 = new TreeNode(1);
        TreeNode node1 = new TreeNode(100);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(1);
        TreeNode node6 = new TreeNode(1);
        TreeNode node7 = new TreeNode(1);
        TreeNode node8 = new TreeNode(1);
        TreeNode node9 = new TreeNode(1);

        node0.children.add(node1);

        node1.children.add(node2);
        node1.children.add(node6);
        node1.children.add(node7);

        node2.children.add(node3);
        node2.children.add(node4);
        node2.children.add(node5);

        node7.children.add(node8);
        node7.children.add(node9);

        LCA5 lca5 = new LCA5();
        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(node3);
        nodes.add(node4);
        nodes.add(node5);
        nodes.add(node6);

        TreeNode res = lca5.lca(node1, nodes);
        System.out.println(res.key); // 100

//                      0
//                     100
//               2           6          7
//           3   4   5                8    9
    }
}
