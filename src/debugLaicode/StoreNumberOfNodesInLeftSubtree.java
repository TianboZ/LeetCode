package debugLaicode;

public class StoreNumberOfNodesInLeftSubtree {
    static class TreeNode {
        // fields
        int val;
        TreeNode left;
        TreeNode right;
        int nodeInLeftSubtree;

        // constructor
        public TreeNode(int val) {
            this.val = val;
        }
    }

    // get num of nodes in the tree with root
    public int store(TreeNode root) {
        // base-case
        if (root == null) {
            return 0;
        }
        // recursive rule
        int left = store(root.left);
        int right = store(root.right);
        root.nodeInLeftSubtree = left;
        return left + right + 1;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(1);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node4.right = node5;

        StoreNumberOfNodesInLeftSubtree storeNumberOfNodesInLeftSubtree = new StoreNumberOfNodesInLeftSubtree();
        storeNumberOfNodesInLeftSubtree.store(node1);

    }

}
