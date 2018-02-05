package debugLaicode;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RestoreBST {
    List<Integer> inOrderNodeTraverseList = new ArrayList<Integer>();
    int first;
    int second;
    TreeNode firstNode;
    TreeNode secondNode;

    public void recoverTree(TreeNode root) {
        inOrderTraverse(root);
        findWrongNode(inOrderNodeTraverseList);
        System.out.println("first = " + first);
        System.out.println("first = " + second);

        inOrderTraverse2(root);
        swap();
    }

    public void inOrderTraverse2(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println("find1");

        inOrderTraverse2(root.left);
        if (root.key == first) {
            firstNode = root;
            System.out.println("find1");
        }
        if (root.key == second) {
            secondNode = root;
            System.out.println("find2");
        }
        inOrderTraverse2(root.right);
    }

    public void inOrderTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderTraverse(root.left);
        inOrderNodeTraverseList.add(root.key);
        inOrderTraverse(root.right);
    }

    public void findWrongNode(List<Integer> inOrderNodeTraverseList) {
        List<Integer> list = new ArrayList<Integer>(inOrderNodeTraverseList);
        List<Integer> wrongList = new ArrayList<Integer>();
        Collections.sort(list);

        System.out.println(list);
        System.out.println(inOrderNodeTraverseList);

        for (int i = 0; i < inOrderNodeTraverseList.size(); i++) {
            if (inOrderNodeTraverseList.get(i) != list.get(i)) {
                wrongList.add(inOrderNodeTraverseList.get(i));
            }
        }
        first = wrongList.get(0);
        second = wrongList.get(1);
    }

    public void swap() {
        int temp = firstNode.key;
        firstNode.key = secondNode.key;
        secondNode.key = temp;
    }
}