package debugLaicode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DifferentWaysToAddParenthese {
    public List<Integer> diffWaysToCompute(String input) {
        // Write your solution here
        List<Integer>  res = dfs(input, 0, input.length() - 1);
        Collections.sort(res);
        return res;
    }

    private List<Integer> dfs(String s, int l, int r) {
        // base case
        if (l == r) {
            // this char is digit
            int num = s.charAt(l) - '0';
            return Arrays.asList(num);
        }

        // recursive rule
        List<Integer>  res = new ArrayList<>();

        for (int i = l; i <= r; i++) {
            char c = s.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> left  = dfs(s, l, i - 1);
                List<Integer> right  = dfs(s, i + 1, r);

                for (Integer n1: left) {
                    for (Integer n2: right) {
                        if (c == '+') {
                            res.add(n1 + n2);
                        } else if (c == '-') {
                            res.add(n1 - n2);
                        } else {
                            res.add(n1 * n2);
                        }
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "23a";
        int n = Integer.parseInt(s);
        System.out.println(n);
    }
}
