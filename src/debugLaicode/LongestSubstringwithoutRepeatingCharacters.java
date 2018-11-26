package debugLaicode;

import java.util.HashMap;
import java.util.Map;



/*

    abcabcbb
        j
      i


for  each j, find the corresponding i, substring[i, j] without repeating charcater

time O(n)
space O(n)


*/

public class LongestSubstringwithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        int slow = 0;
        int fast = 0;
        int repeat = 0;
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();

        while (fast < s.length()) {
            // handle right most pointer
            char c = s.charAt(fast);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (map.get(c) > 1) repeat++;

            // handle left most pointer
            while (repeat > 0) {
                c = s.charAt(slow);
                Integer count = map.get(c);
                if (count != null) {
                    map.put(c, count - 1);
                    if (map.get(c) == 0) {
                        map.remove(c);
                    } else {
                        repeat--;
                    }
                }
                slow++;
            }

            // update
            // repeat == 0
            max = Math.max(max, fast - slow + 1);

            fast++;
        }
        return max;
    }
}
