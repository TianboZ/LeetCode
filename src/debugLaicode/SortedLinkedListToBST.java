package debugLaicode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SortedLinkedListToBST {
    public  static void main(String[] args) {
        SortedLinkedListToBST sortedLinkedListToBST = new SortedLinkedListToBST();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);


        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        // 1 -> 2 -> 3 -> 4 -> 5 -> 6
        TreeNode root = sortedLinkedListToBST.sortedListToBST(node1);
        System.out.println(root.key);
    }

    ListNode curr;
    public TreeNode sortedListToBST(ListNode head) {
        curr = head;
        int len = findSize(head);
        return helper(0, len - 1);
    }
    // given left and right bound, build balanced BST, return root
    private TreeNode helper(int lo, int hi) {
        // base case
        if (lo > hi) {
            return null;
        }

        // recursive rule
        int mid = (lo + hi) / 2;
        TreeNode left = helper(lo, mid - 1);

        TreeNode root = new TreeNode(curr.val);
        curr = curr.next;
        root.left = left;


        TreeNode right = helper(mid + 1, hi);
        root.right = right;
        return root;
    }
    private int findSize(ListNode head) {
        ListNode ptr = head;
        int c = 0;
        while (ptr != null) {
            ptr = ptr.next;
            c += 1;
        }
        return c;
    }
}
