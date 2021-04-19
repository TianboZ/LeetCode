package debugLaicode;

class Node1 {
    public int val;
    public Node1 left;
    public Node1 right;

    public Node1() {}

    public Node1(int _val) {
        val = _val;
    }

    public Node1(int _val,Node1 _left,Node1 _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};

public class ConvertBinarySearchTreeToDoublyLinkedList {
    Node1 prev;
    Node1 head;
    public Node1 treeToDoublyList(Node1 root) {
        if (root == null) return null;


        dfs(root);

        // now prev is last node
        head.left = prev;
        prev.right = head;

        return head;
    }

    // inorder traverse BST
    private void dfs(Node1 root) {
        if (root == null ) return;

        dfs(root.left);
        if (prev == null) {
            prev = root;
            head = root;
        } else {
            prev.right = root;
            root.left = prev;
            prev = root;
        }
        dfs(root.right);
    }
}
