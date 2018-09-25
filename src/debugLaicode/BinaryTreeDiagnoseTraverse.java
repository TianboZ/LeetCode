package debugLaicode;


import java.util.*;

public class BinaryTreeDiagnoseTraverse {
    public static void main(String[] args) {
        BinaryTreeDiagnoseTraverse binaryTreeDiagnoseTraverse = new BinaryTreeDiagnoseTraverse();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);



        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node4.left = node6;
        node3.left = node7;

        List<Integer> list = new ArrayList<>();
        System.out.println(list.size() < 0);
        binaryTreeDiagnoseTraverse.diagonalTraversal(node1);
        binaryTreeDiagnoseTraverse.iterative(node1);
    }

    public List<List<Integer>> diagonalTraversal(TreeNode root) {
        // Write your solution here
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        dfs(root, res, 0);
        return res;
    }
    private void dfs(TreeNode root, List<List<Integer>> res, int level) {
        // base-case
        if (root == null) {
            return;
        }
        // recursive rule
        if (res.size() < level + 1) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(root.key);
        dfs(root.left, res, level + 1);
        dfs(root.right, res, level);
    }

    private void iterative(TreeNode root) {
        // base case
        if (root == null)
            return;

        // inbuilt
        Queue<TreeNode> q = new LinkedList<>();

        // push root
        q.offer(root);

        // push delimiter
        q.offer(null);

        // terminate condition
        while (!q.isEmpty()) {
            // expand
            TreeNode curr = q.poll();

            // if current is delimiter then insert another
            // for next diagonal and continue nextline
            if (curr == null) {
                // if queue is empty return
                if (q.isEmpty())
                    return;

                // output nextline
                System.out.println("");

                // push delimiter again
                q.offer(null);
            } else {
                while (curr != null) {
                    System.out.format("%d ", curr.key);

                    // if left child is present
                    // push into queue
                    if (curr.left != null)
                        q.offer(curr.left);

                    // current equals to right child
                    curr = curr.right;
                }
            }
        }
    }
}