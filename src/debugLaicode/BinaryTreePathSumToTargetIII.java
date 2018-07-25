package debugLaicode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePathSumToTargetIII {
    boolean found = false;
    public boolean exist(TreeNode root, int target) {
        List<TreeNode> path = new ArrayList<>();
        //return exist(root, target, path);
        exist(root, target, path);
        return found;
    }

    // method1
    private boolean exist(TreeNode root, int target, List<TreeNode> path) {
        // base-case
        if (root == null) {
            return false;
        }
        //recursive rule
        path.add(root);
        int sum = 0;
        for (int i = path.size() - 1; i >= 0; i--) {
            sum = sum + path.get(i).key;
            if (sum == target) {
                return true;
            }
        }

        // go left
        //path.add(root);
        if (exist(root.left, target, path)) {
            return true;
        }
        //path.remove(path.size() - 1);

        // go right
        //path.add(root);
        if (exist(root.right, target, path)) {
            return true;
        }
        path.remove(path.size() - 1);

        return false;
    }

    // method2
    // record a path prefix
    private void exist1(TreeNode root, int target, List<TreeNode> path) {
        // base-case
        if (root == null) {
            return;
        }
        if (found == true) {
            return;
        }
        //recursive rule
        int sum = 0;
        path.add(root);
        for (int i = path.size() - 1; i >= 0; i--) {
            sum = sum + path.get(i).key;
            if (sum == target) {
                found = true;
            }
        }

        exist(root.left, target, path);
        exist(root.right, target, path);

        // cleanup when to back to previous layer
        // back-tracking
        path.remove(path.size() - 1);
    }














    private void dfs(TreeNode root, List<TreeNode> path) {
        // base-case
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            path.add(root);
            for (TreeNode node : path) {
                System.out.println(node.key);
            }
            System.out.println();
            path.remove(path.size() - 1);
        }
        // recursive rule
        path.add(root);

        dfs(root.left, path);
        dfs(root.right, path);

        path.remove(path.size() - 1);
    }

    private void dfs1(TreeNode root, List<TreeNode> path) {
        // base-case
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            path.add(root);
            for (TreeNode node : path) {
                System.out.println(node.key);
            }
            System.out.println();
            path.remove(path.size() - 1);
        }
        // recursive rule
        path.add(root);
        dfs(root.left, path);
        path.remove(path.size() - 1);

        path.add(root);
        dfs(root.right, path);
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        BinaryTreePathSumToTargetIII binaryTreePathSumToTargetIII = new BinaryTreePathSumToTargetIII();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

        node1.left = node2;
        node1.right = node3;
        node2.right = node4;
        node4.left = node5;
        node4.right = node6;

        List<TreeNode> list = new ArrayList<>();
        //binaryTreePathSumToTargetIII.dfs(node1, path);
        binaryTreePathSumToTargetIII.dfs1(node1, list);
        System.out.println("path size = " + list.size());
    }
}
