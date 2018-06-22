package debugLaicode;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public String minWindow(String S, String T) {
        if (T == null || T.length() == 0) {
            return "";
        }
        if (T.length() > S.length()) {
            return "";
        }
        // key: character value: number of it
        Map<Character, Integer> map = countMap(T);
        // record how many distinct characters have been matched, only when all distinct characters are matched
        // match == map.size(), we find an anagram
        int match = 0;
        int j = 0; // left bound of window
        int min = 1000;
        int index = 0;

        for (int i = 0; i < S.length(); i++) {
            // handle the rightmost character
            char tmp = S.charAt(i);
            Integer count = map.get(tmp);
            if (count != null) {
                map.put(tmp, count - 1);
                if (count == 1) {
                    match++;
                }
            }
            // handle the leftmost character
            while (match == map.size() && j <= i) {
                // update
                if (i - j + 1 < min) {
                    min = i - j + 1;
                    index = j;
                }

                tmp = S.charAt(j);
                count = map.get(tmp);
                if (count != null) {
                    map.put(tmp, count + 1);
                    if (count == 0) {
                        match--;
                    }
                }
                j++;
            }
        }
        String res = "";
        res = S.substring(index, index + min);
        return res;
    }
    private Map<Character, Integer> countMap(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            Integer i = map.get(ch);
            if (i == null) {
                map.put(ch, 1);
            } else {
                map.put(ch, i + 1);
            }
        }
        return map;
    }

    public static void main(String[] args) {
        MinimumWindowSubstring minimumWindowSubstring = new MinimumWindowSubstring();
        String res = minimumWindowSubstring.minWindow("AEFBGFCMNDCUIBA","ABCD");
        System.out.println(res);
    }
}
