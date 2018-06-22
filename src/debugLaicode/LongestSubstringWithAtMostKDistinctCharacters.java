package debugLaicode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostKDistinctCharacters {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int j = 0;
        int max = -1;
        for (int i = 0; i < s.length(); i++) {
            // handle rightmost char
            char tmp = s.charAt(i);
            Integer count = map.get(tmp);
            if (count != null) {
                map.put(tmp, count + 1);
            } else {
                map.put(tmp, 1);
            }

            // handle leftmost char
            while (map.size() > k) {
                tmp = s.charAt(j);
                count = map.get(tmp);
                if (count == 1) {
                    map.remove(tmp);
                } else {
                    map.put(tmp, count - 1);
                }
                j++;
            }
            // update
            if (i - j + 1 > max) {
                max = i - j + 1;
            }
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
