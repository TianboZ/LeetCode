package debugLaicode;
/*
solution:
use two pointers, slow and fast

[0, slow): retain
[slow, fast): discard
[fast, end]: to be visited


time O(n)
space O(1)
*/
public class StringCompression {
    public int compress(char[] chars) {
        int slow = 0;  // [0, slow)   remain
        int fast = 0;  // [slow, fast) : discard   [fast, end]: explore area
        while (fast < chars.length) {
            int fast2 = fast;
            while (fast2 < chars.length && chars[fast] == chars[fast2]) {
                fast2++;
            }
            int len = fast2 - fast;

            if (len == 1) {
                chars[slow] = chars[fast];
                slow++;
                fast = fast2;
            } else {
                chars[slow] = chars[fast];
                slow++;

                // len is e.g.   3,   11 ...
                String num = len + ""; // convert to string
                for (int i = 0;  i < num.length(); i++) {
                    chars[slow] = num.charAt(i);
                    slow++;
                }
                fast = fast2;
            }
        }
        return slow;
    }
}
