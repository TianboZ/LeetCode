package debugLaicodeSlidingWindow;

import java.util.*;

public class ShortestSubstringWithKTypedCharacter {
    public String shortest(String input, int k) {
        String s = input;

        int fast = 0;
        int slow =0;
        Map<Character, Integer> map = new HashMap<>();
        int min = 1000;
        int start  = 0;

        while (fast < s.length()) {
            // handle fast
            char c = s.charAt(fast);
            map.put(c, map.getOrDefault(c, 0) + 1);

            // handle slow
            while (map.size() == k) {
                // update
                if (fast - slow + 1 <  min) {
                    min =  fast - slow + 1;
                    start = slow;
                }

                c = s.charAt(slow);
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) map.remove(c);

                slow++;
            }

            fast++;
        }

        return min == 1000 ? "" : input.substring(start, start + min);
    }
}
