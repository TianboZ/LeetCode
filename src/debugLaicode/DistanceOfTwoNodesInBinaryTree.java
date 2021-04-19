package debugLaicode;

/*
* solution
* - find LCA of two nodes
* - from LCA, traverse tree, count path length when find two nodes
*
* */
public class DistanceOfTwoNodesInBinaryTree {
    int dis;

    public int distance(TreeNode root, int k1, int k2) {
        // Write your solution here
        TreeNode lca = lca(root, k1, k2);
        dfs(lca, k1, k2, 0);
        return dis;
    }

    private void dfs(TreeNode root, int a, int b, int len) {
        if (root == null) return;

        if (root.key == a || root.key == b) {
            dis = dis + len;
        }

        dfs(root.left, a, b, len + 1);
        dfs(root.right, a, b, len + 1);
    }

    // return null when no LCA
    private TreeNode lca(TreeNode root, int a, int b) {
        if (root == null) return null;
        if (root.key == a || root.key == b) return root;

        TreeNode left  = lca(root.left, a, b);
        TreeNode right  = lca(root.right, a, b);
        if (left == null && right == null) return null;
        if (left != null && right != null) return root;
        return left == null ? right : left;
    }
}
