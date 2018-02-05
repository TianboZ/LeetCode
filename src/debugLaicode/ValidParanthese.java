package debugLaicode;


import java.util.ArrayList;
import java.util.List;

public class ValidParanthese {
    public List<String> validParentheses(int n) {
        // Write your solution here.
        List<String> result = new ArrayList<String>();
        if (n == 0) {
            return result;
        }

        StringBuilder sb = new StringBuilder();
        helper(result, sb, n, 0, 0);
        return result;
    }

    public void helper(List<String> result, StringBuilder sb, int n, int left, int right) {
        System.out.println(sb.toString());
        // base-case
        if (2*n == left + right) {
            result.add(sb.toString());
            return;
        }

        // case 1
        // add '('
        if (left < n) {
            sb.append('(');

            helper(result, sb, n, left + 1, right);
            // back-tracking
            sb.deleteCharAt(sb.length() - 1);
        }

        // case 2
        // add ')'
        if (left > right) {
            sb.append(')');
            helper(result, sb, n, left, right + 1);
            // back-tracking
            sb.deleteCharAt(sb.length() - 1);

        }

    }
}