package debugLaicode;

import java.util.*;

public class FindLeavesOfBinaryTree {
    // sol2
    Map<Integer, List<Integer>> map = new HashMap<>();
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> findLeaves2(TreeNode root) {
        int height = dfs(root);
        for (int i = 1; i <= height; i++) {
            res.add(map.get(i));
        }
        return res;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;

        int height = Math.max(dfs(root.left), dfs(root.right)) + 1; // height

        List<Integer> nodes = map.get(height);
        if (nodes == null) {
            nodes = new ArrayList<>();
            map.put(height, nodes);
        }
        nodes.add(root.val);
        return height;
    }

    // sol1: naive
    List<Integer> leafs;
    List<List<Integer>>  res2 = new ArrayList<>();

    public List<List<Integer>> findLeaves(TreeNode root) {
        while (root != null ) {
            leafs =new ArrayList<>();
            root = remove(root);
            res2.add(leafs);
        }
        return res2;
    }

    // remove leaf node, return new root of tree
    private TreeNode remove(TreeNode root) {
        if (root == null) return null;
        if (root.left == null && root.right == null) {
            leafs.add(root.val);
            return null;
        }

        root.left = remove(root.left);
        root.right = remove(root.right);
        return root;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);

        n1.left = n2;
        n1.right = n3;

        FindLeavesOfBinaryTree sol = new FindLeavesOfBinaryTree();
        //sol.findLeaves2(n1);
        TreeNode n4 = n2;
        n2 = null;

        System.out.println(n1);
    }
}
