package debugLaicode;

import java.util.*;

public class ShortestSubstringKTypeCharacters {
    public static void main(String[] args) {
        ShortestSubstringKTypeCharacters shortest = new ShortestSubstringKTypeCharacters();
        String input = "aaaaabbdaaaacccdddddeeffbbbbbbf";
        shortest.shortest(input, 5);
    }
    public String shortest(String input, int k) {
        // Write your solution here.
        if (input == null || input.length() == 0) {
            return "";
        }

        if (k == 0) {
            return "";
        }
        Map<Character, Integer> map = new HashMap<>();
        int match = 0;
        int left = 0;
        int right = 0;
        int len = Integer.MAX_VALUE;
        int res = -1;
        while (right < input.length()) {
            // handle right
            char tmp1 = input.charAt(right);
            map.put(tmp1, map.getOrDefault(tmp1, 0) + 1);
            if (map.get(tmp1) == 1) {
                match++;
            }
            right++;

            // handle left
            while (match >= k) {
                char tmp2 = input.charAt(left);
                if (map.containsKey(tmp2)) {
                    map.put(tmp2, map.get(tmp2) - 1);
                    if (map.get(tmp2) == 0) {
                        match--;
                    }
                }
                // updage
                if (match == k) {
                    if (len > right - left) {
                        len = right - left;
                        res = left;
                    }
                }
                System.out.println(input.substring(left, right));
                left++;
            }

        }
        return res == -1 ? "" : input.substring(res, res + len);
    }
}
