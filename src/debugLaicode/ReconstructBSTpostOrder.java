package debugLaicode;

public class ReconstructBSTpostOrder {
    public TreeNode reconstruct(int[] post) {
        // Write your solution here.
        TreeNode root =  helper(post, 0, post.length - 1);
        preorder(root);

        return root;
    }

    public void preorder(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.println(root.key);
        preorder(root.left);
        preorder(root.right);
    }


    public TreeNode helper(int[] post, int postLeft, int postRight) {
        // base-case
        if (postLeft > postRight) {
            return null;
        }

        // recursive rule
        int nodeVal = post[postRight];
        TreeNode root = new TreeNode(nodeVal);
        int divideIndex = find(nodeVal, post); // e.g. post[] : 1,2,3,4,10,8  then index 3 is divideIndex

        //System.out.println("ddd");
        TreeNode left = helper(post, postLeft, divideIndex);

        TreeNode right = helper(post, divideIndex + 1, postRight - 1);
        System.out.println("sssss");

        root.left = left;
        root.right = right;

        return root;
    }

    public int find(int nodeVal, int[] post) {
        int temp = -11;
        for (int i = 0; i < post.length; i++) {
            if (post[i] < nodeVal) {
                temp = i;
            }
        }

        System.out.println("index: " + temp);
        return temp;
    }
}
