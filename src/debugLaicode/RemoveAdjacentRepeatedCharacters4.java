package debugLaicode;

import java.util.Deque;
import java.util.LinkedList;

public class RemoveAdjacentRepeatedCharacters4 {
    public String deDup(String input) {
        // sanity check
        if (input == null || input.length() <= 1) {
            return input;
        }

        char[] arr = input.toCharArray();
        Deque<Character> stack = new LinkedList<>();
        int i = 0;
        while (i < arr.length) {
            if (!stack.isEmpty() && stack.peekFirst() == arr[i]) {
                int j = i;
                while (j < arr.length && arr[i] == arr[j]) {
                    j++;
                }
                // j - 1 is last index of consecutive arr[i]
                stack.pollFirst();
                i = j;

            } else {
                stack.offerFirst(arr[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollFirst());
        }
        sb.reverse();
        return  sb.toString();
    }
//    public String deDup(String input) {
//        // Write your solution here
//        Deque<Character> stack = new LinkedList<>();
//        for (int i = 0; i < input.length(); i++) {
//            if (!stack.isEmpty() && stack.peekFirst() == input.charAt(i)) {
//                int j = i;
//                // find the last index of same character subarray
//                while (j + 1 < input.length()
//                        && input.charAt(j) == input.charAt(j + 1)) {
//                    j++;
//                }
//                i = j;
//                stack.pollFirst();
//            } else {
//                stack.offerFirst(input.charAt(i));
//            }
//        }
//        StringBuilder sb = new StringBuilder();
//        while (!stack.isEmpty()) {
//            sb.append(stack.pollFirst());
//        }
//        sb.reverse();
//        return sb.toString();
//    }
}
