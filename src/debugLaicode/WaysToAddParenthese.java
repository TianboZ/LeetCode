package debugLaicode;

import java.util.*;

public class WaysToAddParenthese {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                String left = expression.substring(0, i);
                String right = expression.substring(i + 1);

                List<Integer> list1 = diffWaysToCompute(left);
                List<Integer> list2 = diffWaysToCompute(right);

                for (Integer n1 : list1) {
                    for (Integer n2 : list2) {
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

        if (res.size() == 0) {
            res.add(Integer.parseInt(expression));
        }
        return res;
    }
}
