package debugLaicode;


import java.util.Stack;

public class SortNumbersInThreeStacks {

    private void sort(Stack<Integer> s1, Stack<Integer> s2, Stack<Integer> s3) {
        System.out.println("a");
        while (!s1.isEmpty()) {
            int min = Integer.MAX_VALUE;
            while (!s1.isEmpty()) {
                min = Math.min(min,s1.peek());
                s2.push(s1.pop());
                System.out.println("b");
            }
            while (!s2.isEmpty()) {
                if (s2.peek() == min) {
                    s3.push(s2.pop());
                } else {
                    s1.push(s2.pop());
                }
            }
            System.out.println("c");
        }
        System.out.println(s3);
    }
    public static void main(String[] args) {
        SortNumbersInThreeStacks sortNumbersInThreeStacks = new SortNumbersInThreeStacks();
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        Stack<Integer> s3 = new Stack<>();

        s1.push(1);
        s1.push(2);
        s1.push(-1);
        s1.push(2);
        s1.push(10);
        s1.push(-1);


        sortNumbersInThreeStacks.sort(s1, s2, s3);
    }
}
