package debugLaicode;

public class KthSmallestInBinarySearchTree {
    int count;
    TreeNode node;
    public TreeNode kthSmallest(TreeNode root, int k) {
        count = 0;
        node = null;
        helper(root, k);
        return node;
    }
    // k starts from 1
    private void helper(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        helper(root.left, k);
        count++;
        if (count == k) {
            node = root;
        }
        helper(root.right, k);
    }

    public static void main(String[] args) {
        KthSmallestInBinarySearchTree kthSmallestInBinarySearchTree = new KthSmallestInBinarySearchTree();
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(6);

        node1.left = node2;
        node1.right = node5;
        node2.left = node3;
        node2.right = node4;

//            5
//
//        3        6
//
//     2     4
        TreeNode res = kthSmallestInBinarySearchTree.kthSmallest(node1, 1);
        System.out.println(res.key);
    }
}
