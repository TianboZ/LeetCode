package debugLaicodeSlidingWindow;

import java.util.HashMap;
import java.util.Map;

/*


corner case: s2.length >= s1

solution1:

    eidboaoo
        j   moves to right
      i moves to left   i == j - s1.length()

for each j, find substring[i, j] if is the permutation of s1

check substring if is permutaiton of s1 takes O(n)
time O(m * n)   n =  s1.length  m = s2.length
space O(n)

solution2:
sliding window

window [slow, fast] keeps the property that it is the permutation of s1
use HashMap<key: character, value: frenquency> to record the window

time O(m)  n =  s1.length  m = s2.length
space O(n)

*/
public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        // sanity check
        if (s1 == null || s2 == null || s2.length() < s1.length()) return false;

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int match = 0; // inital

        // sliding window
        for (int fast = 0; fast < s2.length(); fast++) {
            // handle right most pointer
            char c = s2.charAt(fast);
            Integer count = map.get(c);
            if (count != null) {
                map.put(c, count - 1);
                if (count == 1) match++;
            }
            // handle left most pointer
            int slow = fast - s1.length();
            if (slow >= 0) {
                c = s2.charAt(slow);
                count = map.get(c);
                if (count != null) {
                    map.put(c, count + 1);
                    if (count == 0) match--;
                }
            }

            // current window
            if(match == map.size()) return true;
        }
        return false;
    }

    // 偷懒写法
    public boolean checkInclusion2(String s1, String s2) {
        int size = s1.length();
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> target = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            target.put(c, target.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < s2.length(); i++) {
            // handle right most
            char c = s2.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);


            // handle element before window
            int j = i - size;
            if (j >= 0) {
                c = s2.charAt(j);
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) map.remove(c);
            }

            // current window
            if (map.equals(target)) return true;
        }

        return false;
    }
}