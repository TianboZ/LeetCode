package debugLaicode;

import java.util.HashMap;
import java.util.Map;

/*
map<key: char, value: frequency>
d: 2
c: 4
a: 1
f: 99

we can only use once odd frequency character. e.g. in above map, use d two times, use c four times, use a one time, use f 98 times
*/
public class LongestPalindrome {
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) return 0;

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Integer count = map.get(s.charAt(i));
            if (count == null) {
                map.put(s.charAt(i), 1);
            } else {
                map.put(s.charAt(i), count + 1);
            }
        }
        int len = 0;
        boolean odd = false; // use odd or not
        for (Integer i : map.values()) {
            if (i % 2 == 0) {
                // even
                len = len + i;
            } else {
                // odd
                if (!odd) {
                    // first time use
                    len = len + i;
                    odd = true;
                } else {
                    // not first time use
                    len = len + i - 1;
                }
            }
        }
        return len;
    }
}