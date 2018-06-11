package debugLaicode;

import java.util.ArrayList;
import java.util.List;

public class AllValidPermutationsOfParentheses {
    public List<String> validParentheses(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }

        int left = 0; // how many ( already used
        int right = 0; // how many ) already used
        StringBuilder sb = new StringBuilder();
        dfs(left, right, n, res, sb);
        return res;
    }
    private void dfs(int left, int right, int n, List<String> res, StringBuilder sb) {
        // base-case
        if (left + right == 2 * n) {
            res.add(sb.toString());
            return;
        }
        // recursive rule
        // 1. add )
        if (left > right) {
            sb.append(")");
            dfs(left, right + 1, n, res, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

        // 2. add (
        if (left < n) {
            sb.append("(");
            dfs(left + 1, right, n, res, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    public static void main(String[] args) {
        AllValidPermutationsOfParentheses allValidPermutationsOfParentheses = new AllValidPermutationsOfParentheses();
        System.out.println(allValidPermutationsOfParentheses.validParentheses(4));
    }
}
