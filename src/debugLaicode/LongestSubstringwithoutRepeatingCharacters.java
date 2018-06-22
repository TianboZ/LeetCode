package debugLaicode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringwithoutRepeatingCharacters {
    public int longest(String input) {
        // Write your solution here
        Map<Character, Integer> map = new HashMap<>();
        boolean dup = false;
        int j = 0;
        int max = -1;
        for (int i = 0; i < input.length(); i++) {
            // handle rightmost char
            char tmpt = input.charAt(i);
            Integer count = map.get(tmpt);
            if (count != null) {
                map.put(tmpt, count + 1);
                dup = true;
            } else {
                map.put(tmpt, 1);
            }

            // handle leftmost char
            while (dup && j <= i) {
                tmpt = input.charAt(j);
                count = map.get(tmpt);
                if (count == 1) {
                    map.remove(tmpt);
                } else {
                    map.put(tmpt, count - 1);
                    dup = false;
                }
                j++;
            }
            // update
            if (i - j + 1>= max) {
                max = i - j + 1;
                System.out.println(input.substring(j, i + 1));
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LongestSubstringwithoutRepeatingCharacters longestSubstringwithoutRepeatingCharacters = new LongestSubstringwithoutRepeatingCharacters();
        longestSubstringwithoutRepeatingCharacters.longest("bcdfbd");
    }

}
