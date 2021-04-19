package MianJing.ixl.onsite;

import java.util.Stack;

public class CalculatorAddSub {
    public int calculate(String s) {
        // preprocess
        s = s.replaceAll(" ", ""); // remove all white space

        //Stack<Integer> stack = new Stack<Integer>(); // store operand
        int i = 0;
        char sign = '+'; // sign for the current operand
        int res = 0;

        while (i < s.length()) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int j = i;
                while (j < s.length() && Character.isDigit(s.charAt(j))) {
                    j++;
                }
                int num = Integer.parseInt(s.substring(i, j));
                i = j;

                if (sign == '+') {
                    res += num;
                } else if (sign == '-') {
                   res -= num;
                }
            } else {
                sign = c;
                i++;
            }
        }

        // final result
        System.out.println(res);
        return res;
    }

    public static void main(String[] args) {
        CalculatorAddSub sol = new CalculatorAddSub();
        sol.calculate("-2-2");
    }
}
