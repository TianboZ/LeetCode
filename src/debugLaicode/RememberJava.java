package debugLaicode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class RememberJava {
    public static void main(String[] args) {

        // array
        int[] arr = new int[3];
        arr[0] = 1;
        System.out.println(arr.length);

        int[] arr1 = {1, 2, 3};
        System.out.println(arr1); // reference

        for (int e: arr1) {
            System.out.println(e);
        }

        // 2d array
        int[][] matrix = {{1,2}, {3,4}};
        int[][] matrix1 = new int[][]{{1,2}, {3,4}}; // same

        // String

        // char
        char c = 'a';



        // stack
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.pop();
        int peek = stack.peek();
        boolean isEmpty = stack.isEmpty();
        int stackSize = stack.size();

        System.out.println(stack);


        // linkedlist
        List<Integer> list = new LinkedList<Integer>(); // List is interface, LinkedList 具体实现
        list.size();
        list.add(1);

        // queue


        // arraylist

        // System.out.println(1234234);
    }
}
