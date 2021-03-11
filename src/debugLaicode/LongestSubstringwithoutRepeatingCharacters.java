package debugLaicode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class LongestSubstringwithoutRepeatingCharacters {

    public int longest(String input) {
        // Write your solution here
        // sanity check
        // todo

        int slow = 0;
        int fast = 0;
        int max = 0;
        Set<Character> set = new HashSet<>();

        while (fast < input.length()) {
            if (set.contains(input.charAt(fast))) {
                // handle slow pointer
                set.remove(input.charAt(slow));
                slow++;
            } else {
                // handle fast pointer
                set.add(input.charAt(fast));
                fast++;
                max = Math.max(max, fast - slow);
            }
        }

        return max;
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
