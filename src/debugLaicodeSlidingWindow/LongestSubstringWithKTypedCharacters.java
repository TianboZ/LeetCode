package debugLaicodeSlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithKTypedCharacters {
    public String longest(String input, int k) {
        // Write your solution here.
        if (input == null || input.length() == 0) {
            return "";
        }

        Map<Character, Integer> map = new HashMap<>();
        int j = 0;
        int max = -1;
        int index = -1;

        for (int i = 0; i < input.length(); i++) {
            // handle rightmost char
            char tmp = input.charAt(i);
            Integer count = map.get(tmp);
            if (count != null) {
                map.put(tmp, count + 1);
            } else {
                map.put(tmp, 1);
            }

            // handle leftmost char
            while (map.size() > k) {
                tmp = input.charAt(j);
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
                index = j;
            }
        }
        return input.substring(index, max + index);
    }
}
