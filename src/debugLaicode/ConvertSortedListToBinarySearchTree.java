package debugLaicode;


/*
*
* solution:
* 1 --> 2 --> 3 --> 4
*       |
*
*
* since the BST inorder traverse is increasing order, we can construct the BST follow inorder
* while traverse BST follow inorder
*
* since the BST is balanced, we can use left, middle, right as boundary
*
* time O(n)
* space O(n)
*
* */
// convert to balanced BST
public class ConvertSortedListToBinarySearchTree {
    ListNode curr = null;
    public  TreeNode construct(ListNode head) {
        int left = 0;
        int right = getLength(head);
        curr = head;
        return construct(head, left, right);
    }

    private TreeNode construct(ListNode head, int left, int right) {
        // base-case
        if (left > right) return null;

        // recursive rule
        int mid = left + (right - left) / 2;

        TreeNode leftSub = construct(head, left, mid - 1);
        TreeNode root = new TreeNode(curr.val);
        curr = curr.next;
        root.left = leftSub;
        root.right = construct(head, mid + 1, right);

        return root;
    }
    private int getLength(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println("hello");
    }
}
