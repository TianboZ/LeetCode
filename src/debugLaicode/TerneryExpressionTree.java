package debugLaicode;

import java.util.ArrayList;
import java.util.List;


public class TerneryExpressionTree {
    public static void main(String[] args) {
        TerneryExpressionTree terneryExpressionTree = new TerneryExpressionTree();
        ExpNode res = terneryExpressionTree.tree("a?b:c?d:e");
        System.out.println("a");
        List<Integer> list = new ArrayList<>();
        System.out.println();
    }

    int index = 0;

    public ExpNode tree(String exp) {
        // Write your solution here
        if (exp == null || exp.length() == 0) {
            return null;
        }
        return buildTree(exp);
    }

    private ExpNode buildTree(String exp) {
        // base-case
        if (index >= exp.length()) {
            return null;
        }
        // recursive rule
        char c = exp.charAt(index);
        ExpNode root = new ExpNode(c);
        boolean leftDone = false;
        index++;
        if (index < exp.length() && exp.charAt(index) == '?') {
            index++;
            root.left = buildTree(exp);
            leftDone = true;
        }
        if (index < exp.length() && exp.charAt(index) == ':' && leftDone) {
            index++;
            root.right = buildTree(exp);
        }
        return root;
    }
    class ExpNode {
        ExpNode left;
        ExpNode right;
        char val;
        public ExpNode(char c) {
            this.val = c;
        }
    }


    //
//    static int index = 0;
//    private static BinaryTreeNodeGeneric<character> convertToBT(String str) {
//        if (str == null)
//            return null;
//
//        if (index >= str.length())
//            return null;
//        BinaryTreeNodeGeneric<character> root = new BinaryTreeNodeGeneric(str.charAt(index));
//        index++;
//        boolean leftDone = false;
//        if (index < str.length() && str.charAt(index) == '?') {
//            index++;
//            root.left = convertToBT(str);
//            leftDone = true;
//        }
//        if (index < str.length() && str.charAt(index) == ':' && leftDone) {
//            index++;
//            root.right = convertToBT(str);
//        }
//        return root;
//    }
}