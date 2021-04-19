package debugLaicode;

import java.util.*;

public class GenerateParenthese {
    StringBuilder sb = new StringBuilder();
    int size;
    List<String>  res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        size = n * 2;
        dfs(0, 0, n);
        return res;
    }

    // left is ( count, right is ) count
    private void dfs(int left, int right, int n) {
        // base case
        if (sb.length() == size) {
            res.add(sb.toString());
            return;
        }
        // recursive rule
        if (left < n) {
            sb.append('(');
            dfs(left + 1, right, n);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (right < n && left > right) {
            sb.append(')');
            dfs(left, right + 1, n);
            sb.deleteCharAt(sb.length() - 1);
        }

    }
}
