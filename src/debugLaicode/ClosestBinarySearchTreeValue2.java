package debugLaicode;

import java.util.*;

public class ClosestBinarySearchTreeValue2 {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        AscIterator asc = new AscIterator(root, target);
        // while (asc.hasNext()) {
        //     //System.out.println(asc.stack.size());
        //     System.out.println(asc.next().val);
        // }
        System.out.println("-------");
        DesIteartor des = new DesIteartor(root, target);
        // while (des.hasNext()) {
        //     System.out.println(des.next().val);
        // }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (asc.hasNext() && des.hasNext()) {
                // case1, both iterator has next
                if (Math.abs((double)asc.stack.peekFirst().key - target) < Math.abs((double)des.stack.peekFirst().key - target)) {
                    res.add(asc.next().key);
                } else {
                    res.add(des.next().key);
                }
            } else if (!asc.hasNext()) {
                // case2: asc iterator is empty
                res.add(des.next().key);
            } else {
                // case3: des iterator is empty
                res.add(asc.next().key);
            }
        }
        return res;
    }
    // larger or equal
    class AscIterator {
        // field
        Deque<TreeNode> stack = new LinkedList<>();

        // constructor
        public AscIterator(TreeNode root, double target) {
            while (root != null) {
                if (root.key < target) {
                    root = root.right;
                } else {
                    stack.offerFirst(root);
                    root = root.left;
                }
            }
        }

        // API
        public boolean hasNext() {
            return stack.size() != 0;
        }

        public TreeNode next() {
            TreeNode curr = stack.pollFirst();
            pushLeft(curr.right);
            return curr;
        }

        private void pushLeft(TreeNode root) {
            while (root != null) {
                stack.offerFirst(root);
                root = root.left;
            }
        }
    }

    // smaller
    class DesIteartor {
        // field
        Deque<TreeNode> stack = new LinkedList<>();

        // constructor
        public DesIteartor(TreeNode root, double target) {
            while (root != null) {
                if (root.key >= target) {
                    root = root.left;
                } else {
                    stack.offerFirst(root);
                    root = root.right;
                }
            }
        }

        // API
        public boolean hasNext() {
            return stack.size() != 0;
        }

        public TreeNode next() {
            TreeNode curr = stack.pollFirst();
            pushRight(curr.left);
            return curr;
        }

        private void pushRight(TreeNode root) {
            while (root != null) {
                stack.offerFirst(root);
                root = root.right;
            }
        }
    }
}
