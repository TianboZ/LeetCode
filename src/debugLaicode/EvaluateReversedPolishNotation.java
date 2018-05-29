package debugLaicode;

import java.util.Stack;

public class EvaluateReversedPolishNotation {
    public int evalRPN(String[] tokens) {
        // Write your solution here
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            if (s.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (s.equals("-")) {
                stack.push(-stack.pop() + stack.pop());
            } else if (s.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (s.equals("/")) {
                int i = stack.pop();
                int j = stack.pop();
                stack.push(j / i);
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.peek();
    }
    public static void main(String[] args) {
        EvaluateReversedPolishNotation evaluateReversedPolishNotation = new EvaluateReversedPolishNotation();
        String[] tokens = {"11","2","/"};
        int a = evaluateReversedPolishNotation.evalRPN(tokens);
        System.out.println(a);
    }
}