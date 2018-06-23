package debugLaicode;

import java.util.*;


/**
 * public class TreeNode {
 *   public int key;
 *   public TreeNode left;
 *   public TreeNode right;
 *   public TreeNode(int key) {
 *     this.key = key;
 *   }
 * }
 */
public class VerticalTraversalBinaryTree {

    public static void main(String[] args) {
        VerticalTraversalBinaryTree verticalTraversalBinaryTree = new VerticalTraversalBinaryTree();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

        node1.left = node2;
        node1.right = node3;
        node2.right = node4;
        node3.left = node5;
        node5.left = node6;

        String a = "abc";
        String b = "abd";
        System.out.println(a.compareTo(b));

        verticalTraversalBinaryTree.verticalOrder(node1);

    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Map<Integer, List<Integer>> map = new TreeMap<>();
        Queue<Node> q = new LinkedList<>();
        // initial
        q.offer(new Node(root, 0));

        while (!q.isEmpty()) {
            // expand
            Node curr = q.poll();
            int col = curr.col;
            TreeNode node = curr.node;

            if (map.containsKey(col)) {
                map.get(col).add(node.key);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(node.key);
                map.put(col, list);
            }
            // generate
            if (node.left != null) {
                q.offer(new Node( node.left, col - 1));
            }
            if (node.right != null) {
                q.offer(new Node(node.right, col + 1));
            }
        }

        for (List<Integer> list : map.values()) {
            res.add(list);
        }
        return res;
    }

    class Node {
        // fields
        TreeNode node;
        int col;
        // constructor
        public Node (TreeNode node, int col) {
            this.node = node;
            this.col = col;
        }
        // API
    }
}


