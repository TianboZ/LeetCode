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

    ListNode curr = null;
    public TreeNode sortedListToBST(ListNode head) {
        curr = head;
        int length = getLength(head);
        return inorder(0, length - 1);
    }

    private TreeNode inorder(int start, int end) {
        // base-case
        if (start > end) return null;

        // recursive rule
        int mid = start + (end - start) / 2;
        TreeNode left = inorder(start, mid - 1);
        TreeNode root = new TreeNode(curr.val);
        curr = curr.next;
        TreeNode right = inorder(mid + 1, end);

        root.left = left;
        root.right = right;
        return root;
    }


    private int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }
}
