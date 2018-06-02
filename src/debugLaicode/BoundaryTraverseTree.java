package debugLaicode;

//Java program to print boundary traversal of binary tree

/* A binary tree node has data, pointer to left child
   and a pointer to right child */


public class BoundaryTraverseTree {

    Node1 root;

    // A simple function to print leaf nodes of a binary tree
    void printLeaves(Node1 node) {
        if (node != null) {
            printLeaves(node.left);

            // Print it if it is a leaf node
            if (node.left == null && node.right == null)
                System.out.print(node.data + " ");
            printLeaves(node.right);
        }
    }

    // A function to print all left boundry nodes, except a leaf node.
    // Print the nodes in TOP DOWN manner
    void printBoundaryLeft(Node1 node) {
        if (node != null) {
            if (node.left != null) {

                // to ensure top down order, print the node
                // before calling itself for left subtree
                System.out.print(node.data + " ");
                printBoundaryLeft(node.left);
            } else if (node.right != null) {
                System.out.print(node.data + " ");
                printBoundaryLeft(node.right);
            }

            // do nothing if it is a leaf node, this way we avoid
            // duplicates in output
        }
    }

    // A function to print all right boundry nodes, except a leaf node
    // Print the nodes in BOTTOM UP manner
    void printBoundaryRight(Node1 node) {
        if (node != null) {
            if (node.right != null) {
                // to ensure bottom up order, first call for right
                //  subtree, then print this node
                printBoundaryRight(node.right);
                System.out.print(node.data + " ");
            } else if (node.left != null) {
                printBoundaryRight(node.left);
                System.out.print(node.data + " ");
            }
            // do nothing if it is a leaf node, this way we avoid
            // duplicates in output
        }
    }

    // A function to do boundary traversal of a given binary tree
    void printBoundary(Node1 node) {
        if (node != null) {
            System.out.print(node.data + " ");

            // Print the left boundary in top-down manner.
            printBoundaryLeft(node.left);

            // Print all leaf nodes
            printLeaves(node.left);
            printLeaves(node.right);

            // Print the right boundary in bottom-up manner
            printBoundaryRight(node.right);
        }
    }

    // Driver program to test above functions
    public static void main(String args[]) {
        BoundaryTraverseTree tree = new BoundaryTraverseTree();
        tree.root = new Node1(20);
        tree.root.left = new Node1(8);
        tree.root.left.left = new Node1(4);
        tree.root.left.right = new Node1(12);
        tree.root.left.right.left = new Node1(10);
        tree.root.left.right.right = new Node1(14);
        tree.root.right = new Node1(22);
        tree.root.right.right = new Node1(25);
        tree.printBoundary(tree.root);

    }


    static class Node1 {
        int data;
        Node1 left, right;

        Node1(int item) {
            data = item;
            left = right = null;
        }
    }
}
