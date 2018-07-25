package debugLaicode;

import java.util.Deque;
import java.util.LinkedList;

public class ArrayDeduplication4 {
    public int[] deDup(int[] array) {
        // Write your solution here
        if (array == null || array.length == 0) {
            return new int[] {};
        }
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < array.length; i++) {
            if (!stack.isEmpty()
                    && stack.peekFirst() == array[i]) {
                int j = i;
                // find the last index of same number subarray
                while (j + 1 < array.length
                        && array[j] == array[j + 1]) {
                    j++;
                }
                i = j;
                stack.pollFirst();
            } else {
                stack.offerFirst(array[i]);
            }
        }
        int[] res = new int[stack.size()];
        int i = res.length - 1;
        while (!stack.isEmpty()) {
            res[i] = stack.pollFirst();
            i--;
        }
        return res;
    }

    public static void main(String[] args) {
        ArrayDeduplication4 arrayDeduplication4 = new ArrayDeduplication4();
        arrayDeduplication4.deDup(new int[] {1,1,2,3,3,3,2,1,6});
    }
}
