package MianJing.ixl.onsite;

import java.util.*;

public class Calculator3 {
    public int calculate(String s) {
        return helper(s);
    }

    private  int helper(String s) {
        Stack<Integer> stk = new Stack<>();
        char sign = '+';

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int j = i;
                while (j < s.length() && Character.isDigit(s.charAt(j))) {
                    j++;
                }

                int num = Integer.parseInt(s.substring(i, j));
                compute(sign, stk, num);

                i = j - 1;
            } else if(c == '(') {
                int j = i + 1;
                int pCnt = 1; // count (

                while (j < s.length()) {
                    char tmp = s.charAt(j);
                    if (tmp == '(') pCnt++;
                    if (tmp == ')') pCnt--;
                    if (pCnt == 0) break;

                    j++;
                }

                int num = helper(s.substring(i + 1, j));
                compute(sign, stk, num);

                i = j;
            } else {
                sign = c;
            }
        }

        // final result
        int res = 0;
        while (!stk.isEmpty()) {
            res += stk.pop();
        }
        return res;
    }

    private void compute(char sign, Stack<Integer> stk, int num) {
        if (sign == '+') {
            stk.push(num);
        } else if (sign == '-') {
            stk.push(-num);
        } else if (sign == '*') {
            stk.push(stk.pop() * num);
        } else {
            stk.push(stk.pop() / num);
        }
    }

    public static void main(String[] args) {
        Calculator3 sol = new Calculator3();
        int res = sol.calculate("-1+(-2*2)");
        System.out.println(res);
    }
}
