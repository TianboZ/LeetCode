package debugLaicode;

public class LCA3 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode one, TreeNode two) {
        boolean[] res = new boolean[2];
        isExist(root, one, two, res);
        if (res[0] && res[1]) {
            return lca(root, one, two);
        }
        return null;
    }

    private void isExist(TreeNode root, TreeNode one, TreeNode two, boolean[] res) {
        if (root == null) {
            return;
        }
        if (root == one) {
            res[0] = true;
        }
        if (root == two) {
            res[1] = true;
        }
        isExist(root.left, one, two, res);
        isExist(root.right, one, two, res);
    }

    private TreeNode lca(TreeNode root, TreeNode a, TreeNode b) {
        // basecaes
        if (root == null) {
            return null;
        }
        if (root == a || root == b) {
            return root;
        }
        // recursive rule
        TreeNode left = lca(root.left, a, b);
        TreeNode right = lca(root.right, a, b);

        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }
}
