package debugLaicode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
            (a))
            /\
0          (   x
         /\
1      (a  (x
      /   \
2    (a)   (ax
      / \
3   (a)) (a)x
    for each s.charAt(index), it can be moved or kept
    recursion tree has n(n is s.length) levels, two branches for each state
*/

public class RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        int l = 0;
        int r = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                l++;
            } else if (s.charAt(i) == ')') {
                if (l == 0) {
                    r++;
                } else {
                    l--;
                }
            }
        }
        Set<String> res = new HashSet();
        StringBuilder sb = new StringBuilder();
        dfs(l, r, s, 0, 0, sb, res);
        return new ArrayList<>(res);
    }
    // l: how many ( we can remove
    // r: how many ) we can remove
    // count: how many () pair
    private void dfs(int l, int r, String s, int idx, int count, StringBuilder sb, Set<String> res) {
        // base-case
        if (idx == s.length()) {
            if (count == 0) {
                res.add(sb.toString());
            }
            return;
        }

        // recursive rule
        char c = s.charAt(idx);

        if (c == '(') {
            // not keep
            if (l > 0) {
                dfs(l - 1, r, s, idx + 1, count, sb, res);
            }

            // keep
            sb.append(c);
            dfs(l, r, s, idx + 1, count + 1, sb, res);
            sb.deleteCharAt(sb.length() - 1);

        } else if (c == ')') {
            // not keep
            if (r > 0) {
                dfs(l, r - 1, s, idx + 1, count, sb, res);

            }

            // keep
            sb.append(c);
            dfs(l, r, s, idx + 1, count - 1, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        } else {
            // keep character
            sb.append(c);
            dfs(l, r, s, idx + 1, count, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}

// time (2^n)
// space (n)