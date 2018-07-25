package debugLaicode;

import java.util.Deque;
import java.util.LinkedList;

public class RemoveAdjacentRepeatedCharacters4 {
    public String deDup(String input) {
        // Write your solution here
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < input.length(); i++) {
            if (!stack.isEmpty() && stack.peekFirst() == input.charAt(i)) {
                int j = i;
                // find the last index of same character subarray
                while (j + 1 < input.length()
                        && input.charAt(j) == input.charAt(j + 1)) {
                    j++;
                }
                i = j;
                stack.pollFirst();
            } else {
                stack.offerFirst(input.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollFirst());
        }
        sb.reverse();
        return sb.toString();
    }
}
