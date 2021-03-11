package debugLaicode;

import java.util.Deque;
import java.util.LinkedList;

public class ArrayDeduplication4 {
    public int[] deDup(int[] array) {
        // Write your solution here
        if (array == null || array.length == 0) {
            return new int[] {};
        }
        // Write your solution here
        Deque<Integer> stack = new LinkedList<>(); // each char store once
        int i = 0;
        while (i < array.length) {
            int num = array[i];
            if (!stack.isEmpty() && stack.peekFirst() == num) {
                int j = i;
                while (j < array.length && array[j] == num) {
                    j++;
                }
                i = j;
                stack.pollFirst();
            } else {
                stack.offerFirst(num);
                i++;
            }
        }
        int[] res = new int[stack.size()];
        int k = 0;
        while (!stack.isEmpty()) {
            res[k] = stack.pollLast();
            k++;
        }
        return res;
    }

    public static void main(String[] args) {
        ArrayDeduplication4 arrayDeduplication4 = new ArrayDeduplication4();
        arrayDeduplication4.deDup(new int[] {1,1,2,3,3,3,2,1,6});
    }
}
