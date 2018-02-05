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
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);
        ListNode node9 = new ListNode(9);
        ListNode node10 = new ListNode(10);
        ListNode node11 = new ListNode(11);
        ListNode node12 = new ListNode(12);
        ListNode node13 = new ListNode(13);
        ListNode node14 = new ListNode(14);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        node9.next = node10;
        node10.next = node11;
        node11.next = node12;
        node12.next = node13;
        node13.next = node14;

        sortedLinkedListToBST.layerByLayer(sortedLinkedListToBST.sortedListToBST(node1));
    }
    public TreeNode sortedListToBST(ListNode head) {
        // base-case
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        // recursive rule
        ListNode pre = findMid(head);
        ListNode mid = pre.next;
        ListNode next = mid.next;

        System.out.println(pre.val);
        System.out.println(mid.val);
        System.out.println(next.val);
        System.out.println();

        TreeNode newRoot = new TreeNode(mid.val);
        pre.next = null;
        mid.next = null;
        newRoot.left = sortedListToBST(head);
        newRoot.right = sortedListToBST(next);

        return newRoot;
    }

    public ListNode findMid(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            dummy = dummy.next;
            slow = slow.next;
        }
        return dummy;
    }
    public List<List<Integer>> layerByLayer(TreeNode root) {
        // Write your solution here.
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) {
            return res;
        }
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<Integer>();
            for (int i = 0; i < size; i++) {
                // expand
                TreeNode cur = queue.poll();
                list.add(cur.key);
                // generate rule
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            System.out.println(list);
            System.out.println();
            res.add(new ArrayList<>(list));
        }
        return res;
    }
}
