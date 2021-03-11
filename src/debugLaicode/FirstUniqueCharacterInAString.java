package debugLaicode;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;


/*
solution:
iterate all the character in string, keep the frequency of each character, and we need to know the order of characters

so use HashMap<key: char, value: frequency>

iterate the the input string again, find the first character with frequency is 1

time O(n)
space O(n)

use this method, leetcode solution!

solution2：
optimize to one pass
use a hashset to record all the duplicate character
use linkedHashMap<key: char, value: index> to record all the unique character and keep them in order

*/

public class FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        // sanity check
        if (s == null || s.length() == 0) return -1;

        Set<Character> set = new HashSet<>(); // duplicate characters
        Map<Character, Integer> map = new LinkedHashMap<>(); // key: char  value: index
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                set.add(c);
                map.remove(c);
            } else {
                if (!set.contains(c)) {
                    map.put(c, i);
                }
            }
        }
        if (map.values().iterator().hasNext()){
            return map.values().iterator().next();
        }

        return -1;
    }
}
