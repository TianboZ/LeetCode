package debugLaicode;

public class ChangeValueOfBSTtoSumOfAllNodesSmallerThanItself {
    public void changeValue(TreeNode root) {
        sum(root);
    }
    // get sum
    private int sum(TreeNode root) {
        if (root == null) return 0;

        int left = sum(root.left);
        int right = sum(root.right);

        int total = left + right + root.key;
        root.key = left + root.key;
        return total;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(0);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(8);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(12);

        node1.right = node2;
        node2.left = node3;
        node2.right = node4;
        node3.left = node5;
        node4.left = node6;
        node4.right = node7;

        ChangeValueOfBSTtoSumOfAllNodesSmallerThanItself changeValueOfBSTtoSumOfAllNodesSmallerThanItself = new ChangeValueOfBSTtoSumOfAllNodesSmallerThanItself();
        changeValueOfBSTtoSumOfAllNodesSmallerThanItself.changeValue(node1);
        System.out.println("a");
    }
}
