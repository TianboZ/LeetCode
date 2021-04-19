package debugLaicode;


public class ConvertBinaryTreeToDoublyLinkedList {
    TreeNode prev;
    TreeNode head;

    public static void main(String[] str) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;

        ConvertBinaryTreeToDoublyLinkedList convertBinaryTreeToDoublyLinkedList = new ConvertBinaryTreeToDoublyLinkedList();
        convertBinaryTreeToDoublyLinkedList.toDoubleLinkedList(node1);
        convertBinaryTreeToDoublyLinkedList.print();
    }

    public void print() {

        TreeNode tail = null;
        while (head != null) {

            System.out.println(head.key);
            tail = head;
            head = head.right;
        }

        System.out.println("reverse: ");

        while (tail != null) {

            System.out.println(tail.key);
            tail = tail.left;
        }

    }

    public TreeNode toDoubleLinkedList(TreeNode root) {
        // Write your solution here
        inorder(root);
        return head;
    }
    public void inorder(TreeNode root) {
        // base-case
        if (root == null) {
            return;
        }

        // recursive rule
//        inorder(root.left);
//        System.out.println(root.key);
//        if (pre == null) {
//            head = root;
//        } else {
//            pre = root.left;
//            pre.right = root;
//        }
//        pre = root;

        inorder(root.left);
        if (prev == null)
            head = root;
        else {
            root.left = prev;
            prev.right = root;
        }
        prev = root;
        inorder(root.right);
    }
}