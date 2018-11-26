package debugLaicode;


import java.util.List;

/*
two passes:
first pass, to get the total deapth
            1 2 3 4
            4 3 2 1
    e.g.  total deapth is 4, then 1: 4, 2: 3, 3: 2, 4: 1

second pass, modify previous solution and use it
*/
public class NestedListWeightSum2 {
    public interface NestedInteger {
        // Constructor initializes an empty nested list.
        //public NestedInteger();

        // Constructor initializes a single integer.
        //public NestedInteger(int value);

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value);

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni);

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    int max = 0;
    public int depthSumInverse(List<NestedInteger> nestedList) {
        // first pass, get depth
        for (NestedInteger i : nestedList){
            getDeapth(i, 1);
        }

        // second pass, compute sum
        int sum = 0;
        for (NestedInteger i : nestedList){
            sum = sum + getSum(i, 1);
        }
        return sum;
    }
    private void getDeapth(NestedInteger nest, int depth) {
        if (nest.isInteger()) {
            max = Math.max(max, depth);
            return;
        }
        // recursive rule
        for (NestedInteger i : nest.getList()) {
            getDeapth(i, depth + 1);
        }
    }

    private int getSum(NestedInteger nest,int depth) {
        // base-case
        if (nest.isInteger()) {
            return nest.getInteger() * (1 + max - depth);
        }
        // recursive rule
        int sum = 0;
        for (NestedInteger i : nest.getList()) {
            sum = sum + getSum(i, depth + 1);
        }
        return sum;
    }
}