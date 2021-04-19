package debugLaicode;

import java.util.Stack;

public class EvaluateReversedPolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String t : tokens) {
            if (t.equals("*")
                    || t.equals("/")
                    || t.equals("+")
                    || t.equals("-")
            ) {
                // operand
                int num2 = stack.pop();
                int num1 = stack.pop();

                if (t.equals("*")) {
                    stack.push(num1 * num2);
                } else if (t.equals("/")) {
                    stack.push(num1 / num2);
                } else if (t.equals("+")) {
                    stack.push(num1 + num2);
                } else {
                    stack.push(num1 - num2);
                }

            } else {
                int num = Integer.parseInt(t);
                stack.push(num);
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        EvaluateReversedPolishNotation evaluateReversedPolishNotation = new EvaluateReversedPolishNotation();
        String[] tokens = {"11","2","/"};
        int a = evaluateReversedPolishNotation.evalRPN(tokens);
        System.out.println(a);
    }
}