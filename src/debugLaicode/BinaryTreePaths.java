package debugLaicode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    public String[] binaryTreePaths(TreeNode root) {
        // Write your solution here
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(root, paths, path);
        return helper(paths);
    }
    private String[] helper(List<List<Integer>> paths) {
        String[] res = new String[paths.size()];
        int k = 0;
        for (List<Integer> list : paths) {
            StringBuilder sb = new StringBuilder();
            for (Integer i : list) {
                sb.append(i);
                sb.append("->");
            }
            // delete tail "->"
            sb.deleteCharAt(sb.length() - 1);
            sb.deleteCharAt(sb.length() - 1);

            res[k] = sb.toString();
            k++;
        }
        return res;
    }
    private void dfs(TreeNode root, List<List<Integer>> paths, List<Integer> path) {
        // base-case
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            path.add(root.key);
            paths.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        }
        // recursive rule
        path.add(root.key);

        dfs(root.left, paths, path);
        dfs(root.right, paths, path);

        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        BinaryTreePaths binaryTreePaths = new BinaryTreePaths();
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

        binaryTreePaths.binaryTreePaths(node1);
    }
}
