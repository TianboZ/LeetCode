package debugLaicode;

import java.util.HashMap;
import java.util.Map;


/*

solution1:
        eceba
           j       j moves to right
        i      (0 <= i <= j)  i moves to left
for each j, find the left most j, where substring[slow, fast] contains k distinct characters

use map<key: character, value: frenquecy> to record the substring [slow, fast] property

time O(n^2)
space O(n)

solution2:
use a sliding window

window [slow, fast]: keep the property that contains at most k distinct characters

for each j, find the i, that window[i, j] with at most k distinck chars

time o(n)


*/

public class LongestSubstringWithAtMostKDistinctCharacters {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // sanity check
        // todo
        if (s == null || s.length() == 0) return 0;

        int slow = 0;
        int fast = 0;
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();

        while (fast < s.length()) {
            // handle right most pointer
            char c = s.charAt(fast);
            map.put(c, map.getOrDefault(c, 0) + 1);

            // handle left most pointer
            while (map.size() > k) {
                c = s.charAt(slow);
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) - 1);
                    if (map.get(c) == 0) map.remove(c);
                }
                slow++;
            }

            // update
            max = Math.max(max, fast - slow + 1);

            fast++;
        }
        return max;
    }

    public static void main(String[] args) {
        LongestSubstringWithAtMostKDistinctCharacters longestSubstringWithAtMostKDistinctCharacters
                = new LongestSubstringWithAtMostKDistinctCharacters();
        int res = longestSubstringWithAtMostKDistinctCharacters.lengthOfLongestSubstringKDistinct("eddeffffggg", 2);
        System.out.println(res);
    }
}
