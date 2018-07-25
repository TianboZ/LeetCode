package debugLaicode;

import java.util.*;

public class LaiofferFinalExam {
    // question 4
    public boolean canCircle(String[] arr) {
        return permutations(arr);
    }

    public boolean permutations(String[] arr) {
        List<List<String>> result = new ArrayList<>();
        List<String> list = new ArrayList<>();
        helper(result, arr, 0, list);

        // post-process
        for (List<String> i : result) {
            if (ifCanBeChained(i)) {
                return true;
            }
        }
        return false;
    }

    public boolean ifCanBeChained(List<String> list) {
        System.out.println(list);
        // check each pair
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).charAt(list.get(i).length() - 1) != list.get(i + 1).charAt(0)) {
                return false;
            }
        }

        // check first and last string
        if (list.get(0).charAt(0) != list.get(list.size() - 1).charAt(list.get(list.size() - 1).length() - 1)) {
            return false;
        }

        return true;
    }

    public void helper(List<List<String>> result,
                       String[] arr,
                       int index,
                       List<String> list) {
        // base-case
        if (index == arr.length) {
            // deep-copy
            result.add(new ArrayList<String>(list));
        }

        // k-branch, use for
        for (int i = index; i < arr.length; i++) {
            list.clear();
            swap(arr, index, i);
            for (String str : arr) {
                list.add(str);
            }
            helper(result, arr, index + 1, list);
            // back-tracking
            swap(arr, index, i);
            list.clear();
            for (String str : arr) {
                list.add(str);
            }
        }
    }

    public void swap(String[] arr, int i, int j) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // question 2
    public List<String> permutation(String str) {
        char[] arr = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();
        helper(arr, 0, sb, list, false);
        System.out.println(list);
        return list;
    }
    public void helper(char[] arr,
                       int index,
                       StringBuilder sb,
                       List<String> list,
                       boolean flag) {

        // base-case
        if (index == arr.length) {
            //sb.append(arr[index]);
            list.add(sb.toString());
            //sb.deleteCharAt(sb.length() - 1);
            return;
        }
        // recursive rule
        // case1, last time is _
        if (flag) {
            sb.append(arr[index]);
            helper(arr, index + 1, sb, list, false);
            // back-tracking
            sb.deleteCharAt(sb.length() - 1);
        }
        // case2, last time is NOT _
        else {
            // case2.1, add _
            if (index != 0) {
                sb.append("_");
                helper(arr, index, sb, list, true);
                // back-tracking
                sb.deleteCharAt(sb.length() - 1);
            }


            // case2.2, add next character
            sb.append(arr[index]);
            helper(arr, index + 1, sb, list, false);
            // back-tracking
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    // question 2
    public boolean findCousin(TreeNode node1,
                              TreeNode node2,
                              TreeNode root) {
        // first levelOrderTraverse, to largestSmaller the path of values of each
        // layer
        // now, each level node’s value is represented like
        // 7,8,x,x,x,9 (there are must be even numbers!)
        // x means not exist value, since assume that all node’s
        // value >= 0, we can use -1 to represent x
        // e.g. 7,8,x,x,x,9 = 7, 8, -1, -1, -1, 9
        // we can see, if exist two nodes are cousins, then their
        // index satisfy:
        // case1: left_node_index is even, right_node_index is NOT
        // left_node_index + 1
        // case2: left_node_index is odd, right_node_index >
        // left_node_index
        return levelOrderTraverse(root, node1, node2);
    }

    public boolean levelOrderTraverse(TreeNode root,
                                      TreeNode node1,
                                      TreeNode node2) {
        if (root == null) {
            return false;
        }

        Queue<TreeNode> open = new LinkedList<TreeNode>();
        open.offer(root);
        while(!open.isEmpty()) {
            int size = open.size();
// left is flag, try to largestSmaller the left node first, after
// found left node, then start to largestSmaller right node
            boolean left = true;
            boolean found = false;
            int[] index = new int[2];
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < size; i++) {
                TreeNode head = open.poll();
                set.add(head.key);
                if (left && (head.key == node1.key || head.key == node2.key)) {
                    index[0] = i;
                    left = false;
                } else if (!left && (head.key == node1.key || head.key == node2.key)) {
                    index[1] = i;
                    // found possible cousins!!!
                    found = true;
                }

                if (head.left != null) {
                    open.add(head.left);
                } else {
                    open.add(new TreeNode(-1));
                }
                if (head.right != null) {
                    open.add(head.right);
                } else {
                    open.add(new TreeNode(-1));
                }

            }
            // when only element in the set is -1, then we have traversed whole tree
            if (set.size() == 1) {
                break;
            }
            // determine if consins are legal or not

            if (found && index[0] % 2 == 0) {
                if (index[1] - 1 > index[0]) {
                    return true;
                }
            } else if (found && index[0] % 2 == 1){
                if (index[1] > index[0]) {
                    return true;
                }
            }
            System.out.println("a");
        }
        return false;
    }
}
