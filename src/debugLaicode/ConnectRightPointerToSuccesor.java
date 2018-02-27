package debugLaicode;

public class ConnectRightPointerToSuccesor {

    public static void main(String[] args) {

        ConnectRightPointerToSuccesor connectRightPointerToSuccesor = new ConnectRightPointerToSuccesor();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        //node2.right = node5;
        //node3.left = node6;
        //node3.right = node7;
        //node7.left = node8;

        connectRightPointerToSuccesor.connect(node1);
        //connectRightPointerToSuccesor.preorder(node1);
    }

    TreeNode pre = null;
    boolean connect = true;

    public void connect(TreeNode root) {
        // Write your solution here
        inorder(root);
        return;
    }

    public void inorder(TreeNode root) {
        // base-case
        if (root == null) {
            return;
        }

        // recursive rule
        inorder(root.left);

        if (pre == null) {
            pre = root;
        } else {
            pre.right = root;
            if (root.right == null) {

                pre = root;
            } else {
                pre = null;
            }
        }

        inorder(root.right);
    }

    public void preorder(TreeNode root) {
        // base-case
        if (root == null) {
            return;
        }

        if (root.right != null) {
            System.out.println("root.val = " + root.key + " right.val = " + root.right.key);
        }
        preorder(root.left);
        preorder(root.right);
    }
}
