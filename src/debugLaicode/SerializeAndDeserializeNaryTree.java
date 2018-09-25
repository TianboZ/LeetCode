package debugLaicode;

//public class SerializeAndDeserializeNaryTree {

import java.util.ArrayList;
import java.util.List;

public class SerializeAndDeserializeNaryTree {
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    // Encodes a tree to a single string.
    public String serialize(Node root) {
        StringBuilder preSb = new StringBuilder();
        StringBuilder postSb = new StringBuilder();

        traverse(root, preSb, postSb);
        preSb.deleteCharAt(preSb.length() - 1);
        postSb.deleteCharAt(postSb.length() - 1);

        preSb.append("-").append(postSb.toString());
        return preSb.toString();
    }
    private void traverse(Node root, StringBuilder preSb, StringBuilder postSb) {
        if (root == null) {
            preSb.append("#,");
            postSb.append("#,");
            return;
        }
        preSb.append(root.val + ",");
        for (Node child : root.children) {
            traverse(child, preSb, postSb);
        }
        postSb.append(root.val + ",");
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        System.out.println(data);  // 1,3,5,6,2,4-5,6,3,2,4,1
        String[] s = data.split("-");
        String[] pre = s[0].split(",");
        String[] post = s[1].split(",");
        System.out.println(s[0]); // 1,3,5,6,2,4
        System.out.println(s[1]);  //5,6,3,2,4,1

        return construct(pre, post);
    }
    int preIndex = 0;
    int postIndex = 0;
    private Node construct(String[] pre, String[] post) {
        // base-case

        // recursive rule
        Node root = new Node();
        root.val = Integer.valueOf(pre[preIndex]);
        root.children = new ArrayList<>();
        //System.out.println(preIndex + " , " + postIndex);
        preIndex++;
        System.out.println(root.val);
        while (Integer.valueOf(post[postIndex]) != root.val) {
            root.children.add(construct(pre, post));
        }
        postIndex++;
        return root;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1, new ArrayList<Node>());

        Node node2 = new Node(2, new ArrayList<Node>());

        Node node3 = new Node(3, new ArrayList<Node>());

        node1.children.add(node2);
        node1.children.add(node3);

        SerializeAndDeserializeNaryTree serializeAndDeserializeNaryTree = new SerializeAndDeserializeNaryTree();
        String s = serializeAndDeserializeNaryTree.serialize(node1);
        Node root = serializeAndDeserializeNaryTree.deserialize(s);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));