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
        int slow = 0;
        int fast = 0;
        while (fast < chars.length) {
            int tmpt = fast;
            while (fast + 1 < chars.length && chars[fast] == chars[fast + 1]) fast++;
            // fast is last same consecutive character
            if (tmpt == fast) {
                // no duplicate
                chars[slow] = chars[fast];
                slow++;
            } else {
                int dup = fast - tmpt + 1;
                String s = Integer.toString(dup);
                chars[slow] = chars[fast];
                slow++;
                for (int i = 0; i < s.length(); i++) {
                    chars[slow] = s.charAt(i);
                    slow++;
                }
            }
            fast++;
        }
        return slow;
    }
}
