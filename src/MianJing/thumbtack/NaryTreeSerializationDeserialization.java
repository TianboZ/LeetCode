package MianJing.thumbtack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NaryTreeSerializationDeserialization {
    private static class Node {
        int val;
        List<Node> children;

        Node(int val) {
            this.val = val;
            this.children = new ArrayList<>();
        }
    }

//                1
//              /  \  \
//             3   4    5

    public String serilize(Node root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        preOrder(root, sb);
        sb.deleteCharAt(sb.length() - 1); // delete last ","  e.g.  1,2,3,0,4,0,5,0
        return sb.toString();

    }
    private void preOrder(Node root, StringBuilder sb) {
        // base-case
        if (root == null) return;
        // recursive rule
        sb.append(root.val + "," + root.children.size()+",");
        for (Node node : root.children) {
            preOrder(node, sb);
        }
    }

    public Node deSerilize(String s) {
        if (s == null || s.length() == 0) return null;
        String[] input = s.split(",");
        return helper(input);
    }
    int preIndex = 0;
    private Node helper(String[] input) {
        // base-case

        // rule
        int val = Integer.parseInt(input[preIndex]);
        preIndex++;
        Node root = new Node(val);

        int numOfChildren = Integer.parseInt(input[preIndex]);
        preIndex++;

        for (int i = 0; i < numOfChildren; i++) {
            root.children.add(helper(input));
        }
        return root;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        node1.children.add(node3);
        node1.children.add(node4);
        node1.children.add(node5);

        NaryTreeSerializationDeserialization naryTreeSerializationDeserialization = new NaryTreeSerializationDeserialization();
        Node res = naryTreeSerializationDeserialization.deSerilize(naryTreeSerializationDeserialization.serilize(node1));

        System.out.println("finish");
    }
}
