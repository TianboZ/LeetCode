package debugLaicode;

import java.util.*;

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
    StringBuilder sb = new StringBuilder();
    Set<String> set = new HashSet<>();
    int max = 0;

    public List<String> removeInvalidParentheses(String s) {
        dfs(0, s, 0, 0);

        //System.out.println(set);
        List<String> res = new ArrayList<>();
        for (String str : set) {
            if (str.length() == max) res.add(str);
        }
        return new ArrayList<>(res);
    }
    // left: count (
    // right : count )
    private void dfs(int i, String s, int left, int right) {
        // base case
        if (i == s.length()) {
            //System.out.println(sb.toString());
            //System.out.println(left + "," + right);

            if (left == right) {
                // System.out.println(sb.toString());
                set.add(sb.toString());
                max = Math.max(max, sb.length());
            }

            return;
        }

        // recursive rule
        char c = s.charAt(i);
        if (c != '(' && c != ')') {
            sb.append(c);
            dfs(i + 1, s, left, right);
            sb.deleteCharAt(sb.length() - 1);
        } else {
            // append
            if (c == ')') {
                if (left > right) {
                    sb.append(c);
                    dfs(i + 1, s, left, right + 1);
                    sb.deleteCharAt(sb.length() - 1);
                }
            } else {
                sb.append(c);
                dfs(i + 1, s, left + 1, right);
                sb.deleteCharAt(sb.length() - 1);
            }

            // not append
            dfs(i + 1, s, left, right);
        }
    }

    public static void main(String[] args) {

    }
}

// time (2^n)
// space (n)