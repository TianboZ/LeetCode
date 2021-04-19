package debugLaicode;

/*

solution:
for each node, to find successor, there are two paths, to up or go down

if node.right exist
    - find smallest in root.right subtree
else
    - find the first parent that is parent.val > node.val

*/


// Definition for a Node.

class Node2 {
    public int val;
    public Node2 left;
    public Node2 right;
    public Node2 parent;
};

public class InorderSuccessorinBST2 {


    public Node2 inorderSuccessor(Node2 node) {
        // sanity check
        if (node == null) return null;


        if (node.right != null) {
            // find the smallest in root.right subtree
            Node2 root = node.right;
            //Node smallest = root;
            while (root.left != null) {
                root = root.left;
            }
            return root;
        } else {
            Node2 parent = node.parent;

            while (parent != null && parent.val < node.val) {
                parent = parent.parent;
            }
            // now parent is null or parent.val > node.val
            return parent;
        }
    }
    public static void main(String[] str) {
        System.out.println('a');
        Node2 n1 = new Node2();
    }
}
