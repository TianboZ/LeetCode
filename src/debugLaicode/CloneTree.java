package debugLaicode;

import java.util.HashMap;
import java.util.Map;

public class CloneTree {
    public Tree cloneTree(Tree tree){
        Map<Tree, Tree> map = new HashMap<>();
        return helper(tree, map);
    }

    public Tree helper(Tree tree, Map<Tree, Tree> map){
        // add code here.
        // base-case
        if (tree == null) {
            return null;
        }
        if (map.containsKey(tree)) {
            return map.get(tree);
        }

        // recursive rule
        Tree copy = new Tree(tree.data);
        // case1: left
        copy.left = helper(tree.left, map);
        // case2: right
        copy.right = helper(tree.right, map);
        // case3: random
        copy.random = helper(tree.random, map);

        return copy;
    }

    public static void main(String[] args) {

    }
}
class Tree{
    int data;
    Tree left,right,random;
    Tree(int d){
        data=d;
        left=null;
        right=null;
        random=null;
    }
}