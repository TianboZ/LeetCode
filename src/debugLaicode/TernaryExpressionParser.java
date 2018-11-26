package debugLaicode;


import java.util.Deque;
import java.util.LinkedList;

/*

solution:
    stack: [3, f,


    iterate elements from the tail of string, use stack to store iterated elements
    if meet a "?", find out what element should retain

    time O(n)
    space O(n)
*/
public class TernaryExpressionParser {

    public String parseTernary(String expression) {
        Deque<Character> stack = new LinkedList<>();
        int i = expression.length() - 1;
        while (i >= 0) {
            char c = expression.charAt(i);
            if (c == ':') {
                i--;
                continue;
            }

            if (c == '?') {
                char prev = expression.charAt(i - 1);
                char first = stack.pollFirst();
                char second = stack.pollFirst();

                if (prev == 'T') {
                    stack.offerFirst(first);
                } else {
                    stack.offerFirst(second);
                }
                i = i - 2;
            } else {
                stack.offerFirst(c);
                i--;
            }
        }
        return Character.toString(stack.pollFirst());
    }
}
