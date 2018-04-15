package debugLaicode;


import java.util.*;

public class BinaryTreeDiagnoseTraverse {
    public static void main(String[] args) {
        BinaryTreeDiagnoseTraverse binaryTreeDiagnoseTraverse = new BinaryTreeDiagnoseTraverse();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);


        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node4.left = node6;
        node3.left = node7;

        List<Integer> list = new ArrayList<>();
        System.out.println(list.size() < 0);
        binaryTreeDiagnoseTraverse.diagonalSum(node1);
    }

    public void diagonalSum(TreeNode root) {
        // Write your solution here
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, res, 0);
        System.out.println(res);
    }
    private void dfs(TreeNode root, List<List<Integer>> res, int level) {
        // base-case
        if (root == null) {
            return;
        }
        // recursive rule
        System.out.println(level);
        if (res.size() < level + 1) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(root.key);
        dfs(root.right, res, level);
        dfs(root.left, res, level + 1);
    }
}