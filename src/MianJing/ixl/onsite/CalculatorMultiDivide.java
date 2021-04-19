package MianJing.ixl.onsite;

import java.util.Stack;

public class CalculatorMultiDivide {
    public void calculate(String s) {
        // preprocess
        s = s.replace(" ", ""); // remove all white space

        Stack<Float> stack = new Stack<>(); // store operand
        int i = 0;
        char sign = '+'; // sign for the current operand, default +

        while (i < s.length()) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int j = i;
                int num = 0;
                while (j < s.length() && Character.isDigit(s.charAt(j))){
                    c = s.charAt(j);
                    num = num * 10 + c - '0';
                    j++;
                }
                //int num = Integer.parseInt(s.substring(i, j));

                if (sign == '+') {
                    stack.push((float)num);
                } else if (sign == '-') {
                    stack.push((float)(-num));
                } else if (sign == '*') {
                    stack.push(stack.pop() * num);
                } else if (sign == '/') {
                    stack.push(stack.pop() / num);
                }

                i = j;
            } else {
                sign = c;
                i++;
            }
        }

        // final result
        float res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }

        System.out.println(res);
        //return res;
    }

    public static void main(String[] args) {
        CalculatorMultiDivide sol = new CalculatorMultiDivide();
        sol.calculate("-1-4*3");
    }
}
