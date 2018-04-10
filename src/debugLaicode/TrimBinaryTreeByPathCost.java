package debugLaicode;

public class TrimBinaryTreeByPathCost {

    public static void main(String[] args) {
        TrimBinaryTreeByPathCost trimBinaryTreeByPathCost = new TrimBinaryTreeByPathCost();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node4.left = node6;

        TreeNode res = trimBinaryTreeByPathCost.trimTree(node1, 4);
        System.out.printf("a");

    }

    public TreeNode trimTree(TreeNode root, int k) {
        // Write your solution here
        trimTree(root, k, 0);
        return root;
    }

    // trim the tree that starts from root, return root
    private TreeNode trimTree(TreeNode root, int k, int level) {
        // base-case
        if (root == null) {
            return root;
        }

        // recursive rule
        int height = getHeight(root);
        System.out.println("path cost: " +  (level + height) + "  level=" + level + " height=" + height + " node.val = " + root.key);
        if (level + height < k) {
            System.out.println(root.key + " is null");
            root = null;
            return root;
        }

        TreeNode left = trimTree(root.left, k, level + 1);
        TreeNode right = trimTree(root.right, k, level + 1);
        root.left = left;
        root.right = right;
        return root;
    }
    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
}
