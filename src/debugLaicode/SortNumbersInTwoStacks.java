package debugLaicode;

import java.util.Stack;

public class SortNumbersInTwoStacks {
    private void sort(Stack<Integer> s1, Stack<Integer> s2) {
        while (!s1.isEmpty()) {
            int size = s1.size();
            int min = Integer.MAX_VALUE;
            int count = 0;


            // try to largestSmaller the min in s1
            for (Integer e : s1) {
                min = Math.min(min, e);
            }

            // move all elements from s1 to s2
            while (!s1.isEmpty()) {
                if (min == s1.peek()) {
                    count++;
                }

                s2.push(s1.pop());
            }

            // move back elements from s2 to s1
            for (int i = 0; i < size; i++) {
                if (s2.peek() == min) {
                    s2.pop();
                } else {
                    s1.push(s2.pop());
                }
            }

            // store min to s2
            for (int i = 0; i < count; i++) {
                s2.push(min);
            }

        }
    }

    public static void main(String[] args) {
        SortNumbersInTwoStacks sortNumbersInTwoStacks = new SortNumbersInTwoStacks();
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        s1.push(1);
        s1.push(2);
        s1.push(-1);
        s1.push(2);
        s1.push(10);
        s1.push(10);
        s1.push(10);



        sortNumbersInTwoStacks.sort(s1, s2);
        System.out.println(s2);
    }
}
