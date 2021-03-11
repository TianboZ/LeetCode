package debugLaicode;

import java.util.*;

public class AllSubsets1 {
    public List<String> subSets(String set) {
        // Write your solution here.
        // sanity check
        List<String> res = new ArrayList<>();
        if (set == null) {
            return res;
        }

        char[] setArr = set.toCharArray();
        dfs(setArr, 0, new StringBuilder(), res);
        return res;
    }

    private void dfs(char[] setArr, int index, StringBuilder sb, List<String> res ) {
        // basecase
        if (index == setArr.length) {
            res.add(sb.toString());
            return;
        }

        // recursive rule
        // case1, take char at index
        sb.append(setArr[index]);
        dfs(setArr, index + 1, sb, res);
        sb.deleteCharAt(sb.length() - 1); // backtracking to prev state

        // case2, not take char at index
        dfs(setArr, index + 1, sb, res);
    }

    public static void main(String[] args) {
        AllSubsets1 allSubsets1 = new AllSubsets1();
        System.out.println(allSubsets1.subSets("abcd"));
    }
}
