package debugLaicode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringKTypeCharacters {
    public static void main(String[] args) {
        LongestSubstringKTypeCharacters longestSubstringKTypeCharacters = new LongestSubstringKTypeCharacters();
        System.out.println( longestSubstringKTypeCharacters.longest("adfddsadfadfadf", 1) );
    }
    public String longest(String input, int k) {
        // Write your solution here.
        if (input == null || input.length() == 0) {
            return new String("");
        }
        int len = -1;
        int right = 0;
        int match = 0;
        int left = 0;
        int res = -1;
        Map<Character,Integer> pattern = new HashMap<>();

        while (right < input.length()) {
            // handle right
            char tmp1 = input.charAt(right);
            pattern.put(tmp1, pattern.getOrDefault(tmp1, 0) + 1);
            if (pattern.get(tmp1) == 1) {
                match++;
            }
            right++;
            System.out.println("right = " + right);
            // handle left
            while (match == k) {
                System.out.println("left = " + left);
                char tmp2 = input.charAt(left);
                if (pattern.containsKey(tmp2)) {
                    pattern.put(tmp2, pattern.get(tmp2) - 1);
                    if (pattern.get(tmp2) == 0) {
                        match--;
                    }
                }
                // update
                if (right - left > len) {
                    len = right - left;
                    res = left;
                }
                left++;
                System.out.println("aaa");
            }
        }
        return res == -1 ? "" : input.substring(res, res + len);
    }
}
