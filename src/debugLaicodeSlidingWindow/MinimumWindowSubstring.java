package debugLaicodeSlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        // sanity check
        if (t.length() > s.length()) return "";
        if (s == null || s.length() == 0 || t == null || t.length() == 0) return "";

        int min = Integer.MAX_VALUE;
        int index = 0;

        Map<Character, Integer> map = new HashMap<>();
        countMap(map, t);

        int match = 0; // initial
        int fast = 0;
        int slow = 0;

        while (fast < s.length()) {
            // handle right most pointer
            char c = s.charAt(fast); // add fast
            // add c to the sliding window
            Integer count = map.get(c);
            if (count != null) {
                map.put(c, count - 1);
                if (map.get(c) == 0) match++;
            }

            // handle left most pointer
            while (match == map.size()) {
                c = s.charAt(slow);
                // update shortest window size   [slow, fast]
                if (fast - slow + 1 < min) {
                    min = fast - slow + 1;
                    index = slow;
                }

                // remove slow from the window
                count = map.get(c);
                if (count != null) {
                    map.put(c, count + 1);
                    if (map.get(c) > 0) match--;
                }

                slow++;
            }
            fast++;
        }
        return min == Integer.MAX_VALUE ? "" : s.substring(index, index + min);

    }
    private void countMap(Map<Character, Integer> count, String t) {
        for (int i = 0; i < t.length(); i++) {
            count.put(t.charAt(i), count.getOrDefault(t.charAt(i), 0) + 1);
        }
    }
    
    public static void main(String[] args) {
        MinimumWindowSubstring minimumWindowSubstring = new MinimumWindowSubstring();
        String res = minimumWindowSubstring.minWindow("AEFBGFCMNDCUIBA","ABCD");
        System.out.println(res);
    }
}
