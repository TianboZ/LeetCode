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

    public String verticalOrder(TreeNode root) {
        // Write your solution here
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(root, 0));
        Map<Integer, List<Integer>> map = new TreeMap<>();

        while (!queue.isEmpty()) {
            // expand
            Point cur = queue.poll();
            int curCol = cur.col;
            int curVal = cur.node.key;

            if (map.containsKey(curCol)) {
                map.get(curCol).add(curVal);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(curVal);
                map.put(curCol, list);
            }
            // generate rule
            if (cur.node.left != null) {
                queue.offer(new Point(cur.node.left, curCol - 1));
            }
            if (cur.node.right != null) {
                queue.offer(new Point(cur.node.right, curCol + 1));
            }
        }
        System.out.println(map);
        List<List<Integer>> result = new ArrayList<>();
        //System.out.println(map.get(0).toString());
        for (List<Integer> list : map.values()) {
            result.add(list);
        }
        System.out.println(result.toString());
        return null;
    }
}
class Point {
    TreeNode node;
    int col;
    public Point(TreeNode node, int col) {
        this.node = node;
        this.col = col;
    }
}

