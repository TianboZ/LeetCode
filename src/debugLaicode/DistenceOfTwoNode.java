package debugLaicode;

public class DistenceOfTwoNode {
    public static void main(String[] args) {
        DistenceOfTwoNode distenceOfTwoNode= new DistenceOfTwoNode();

        TreeNode node1 = new TreeNode(7);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(9);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(8);
        TreeNode node7 = new TreeNode(10);
        TreeNode node8 = new TreeNode(2);
        TreeNode node9 = new TreeNode(4);
        TreeNode node10 = new TreeNode(6);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node4.right = node8;
        node5.left = node9;
        node5.right = node10;

        int k = distenceOfTwoNode.distance(node1,9,10);
        System.out.println(k);
    }
    public int distance(TreeNode root, int k1, int k2) {
        // Write your solution here.
        TreeNode node = lca(root, k1, k2);
        System.out.println("lca: " + node.key);
        if (node.key == k1) {
            int[] distence = {0};
            preorder(root, distence, k2, 0);
            return distence[0];
        } else if (node.key == k2) {
            int[] distence = {0};
            preorder(root, distence, k1, 0);
            return distence[0];
        } else {
            System.out.println("aaa");
            int[] distence = {0};
            preorder(node, distence, k1, 0);
            int dis1 = distence[0];
            System.out.println("dis1=" + dis1);
            distence[0] = 0;
            preorder(node, distence, k2, 0);
            int dis2 = distence[0];

            return dis1 + dis2;
        }
    }
    public void preorder(TreeNode root, int[] distence, int k, int length) {
        // base-case
        if (root == null) {
            return;
        }
        if (root.key == k) {
            distence[0] = length;
            return;
        }
        // recurusive rule
        preorder(root.left, distence, k, length + 1);
        preorder(root.right, distence, k, length + 1);
    }

    public TreeNode lca(TreeNode root, int one, int two) {
        // base-case
        if (root == null) {
            return root;
        }

        if (root.key == one || root.key == two) {
            return root;
        }

        // recursive rule
        TreeNode left = lca(root.left, one, two);
        TreeNode right = lca(root.right, one, two);

        if (left != null && right != null) {
            return root;
        }
        else if (left == null && right != null) {
            return right;
        }
        else if (right == null && left != null) {
            return left;
        }
        else{
            return null;
        }
    }
}
