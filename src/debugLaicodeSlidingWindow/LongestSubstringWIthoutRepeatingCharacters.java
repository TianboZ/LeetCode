package debugLaicodeSlidingWindow;

import java.util.*;

public class LongestSubstringWIthoutRepeatingCharacters {

    public int longest(String s) {
        int fast = 0;
        int slow =0;
        Map<Character, Integer> map = new HashMap<>();
        int max = -1;
        int repeat = 0;

        while (fast < s.length()) {
            // handle fast
            char c = s.charAt(fast);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (map.get(c) > 1) repeat++;

            // handle slow
            while (repeat > 0) {
                c = s.charAt(slow);
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 1) repeat--;
                slow++;
            }

            max = Math.max(max, fast - slow + 1);
            fast++;
        }

        return max == -1 ? 0 : max;
    }
    // time o(n)   slow and fast moves at most n times, n is length of string

//    public int lengthOfLongestSubstring(String s) {
//        int slow = 0;
//        int fast = 0;
//        int repeat = 0;
//        int max = 0;
//        Map<Character, Integer> map = new HashMap<>();
//
//        while (fast < s.length()) {
//            // handle right most pointer
//            char c = s.charAt(fast);
//            map.put(c, map.getOrDefault(c, 0) + 1);
//            if (map.get(c) > 1) repeat++;
//
//            // handle left most pointer
//            while (repeat > 0) {
//                c = s.charAt(slow);
//                Integer count = map.get(c);
//                if (count != null) {
//                    map.put(c, count - 1);
//                    if (map.get(c) == 0) {
//                        map.remove(c);
//                    } else {
//                        repeat--;
//                    }
//                }
//                slow++;
//            }
//
//            // update
//            // repeat == 0
//            max = Math.max(max, fast - slow + 1);
//
//            fast++;
//        }
//        return max;
//    }
}
