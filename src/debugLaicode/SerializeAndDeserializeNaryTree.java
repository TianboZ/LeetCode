package debugLaicode;


import java.util.ArrayList;
import java.util.List;

// solution1:
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
}

public class SerializeAndDeserializeNaryTree {


    // Encodes a tree to a single string.
    public String serialize(Node root) {
        if (root == null) return null;
        String res =  preOrder(root);
        System.out.println(res);
        return res;
    }
    // start root node, reutrn e.g. [1[2][22][222]]
    private String preOrder(Node root) {
        // base-case
        if (root == null) {
            return "";
        }

        // recursive rule
        StringBuilder sb = new StringBuilder();
        sb.append( "[" + root.val);
        for (Node node : root.children) {
            sb.append(preOrder(node) );
        }
        sb.append("]");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if (data == null) return null;
        return reconstruct(data, 0);
    }
    // reconstruct the tree following the preorder
    int index = 0;
    Node reconstruct(String preorder, int depth) {
        // recursive rule
        index++; // skip first [
        int tmpt = index;
        while (preorder.charAt(index) >= '0' && preorder.charAt(index) <= '9'){
            index++;
        }
        int num = Integer.parseInt(preorder.substring(tmpt, index));
        Node root = new Node(num, new ArrayList<>());
        // index is first [
        while (preorder.charAt(index) != (']')) {
            root.children.add(reconstruct(preorder, depth + 1));
        }
        System.out.println("index: " + index + " depth: " + depth);
        index++;
        return root;
    }
}

// solution2:
//
class SerializeAndDeserializeNaryTree2 {
    // Encodes a tree to a single string.
    public String serialize(Node root) {
        // sanity check
        if (root == null) return "";

        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
        return sb.toString();
    }

    private void preorder(Node root, StringBuilder sb) {
        // base-case
        if (root == null) return;

        // recursive rule
        sb.append("" + root.val + ",");
        sb.append(root.children.size() + ",");

        for (Node node : root.children) {
            preorder(node, sb);
        }
    }
    // Decodes your encoded data to tree.

    int index;

    public Node deserialize(String data) {
        // sanity check
        if (data.equals("")) return null;

        String[] arr = data.split(",");
        index = 0;

        return construct(arr);
    }
    private Node construct(String[] arr) {
        // base-case

        // recursive rule
        int val = Integer.parseInt(arr[index]); // current node value
        index++;
        int num = Integer.parseInt(arr[index]); // number of children of current node
        index++;

        Node root = new Node(val, new ArrayList<>());
        for (int i = 0; i < num; i++) {
            root.children.add(construct(arr));
        }
        return root;
    }
}