package MianJing.thumbtack;


import java.util.*;

//  3:24
public class NaryTree {
    private static class Node {
        int val;
        int id;
        List<Node> children;
        boolean isEnd;

        Node(int val, int id) {
            this.val = val;
            this.id = id;
            this.children = new ArrayList<>();
        }
    }


    /*
    *
    *       node is id
    *
    *                0
    *              / \ \
    *             1  2  3
    *                   /
    *                  4
    *
    *
    * */
    public static void main(String[] args) {
        Node node1 = new Node(1, 0);
        Node node2 = new Node(10, 1);
        Node node3 = new Node(100, 2);
        Node node4 = new Node(5, 3);
        node4.isEnd = true;

        Node node5 = new Node(1000, 4);

        node1.children.add(node2);
        node1.children.add(node3);
        node1.children.add(node4);

        node4.children.add(node5);

        Set<Integer> ids = new HashSet<>();
        ids.add(0);
        ids.add(3);
        ids.add(4);

        NaryTree naryTree = new NaryTree();
        naryTree.preorder(node1, ids);
        System.out.println(naryTree.sum);
    }

    private int sum = 0; // global variable



    // time O(V + E)
    // space O(V)
    public void preorder(Node root, Set<Integer> ids) {
        // base-case
        if (root == null) return;

        // recursive rule
        if (ids.contains(root.id)) {
            sum = sum + root.val;
        }

        if (root.isEnd) return; // pruning

        for (Node child : root.children) {
            preorder(child, ids);
        }
    }
}
