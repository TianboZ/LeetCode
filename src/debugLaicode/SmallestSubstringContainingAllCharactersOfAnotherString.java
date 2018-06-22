package debugLaicode;

import java.util.HashMap;
import java.util.Map;

public class SmallestSubstringContainingAllCharactersOfAnotherString {
    // s1: longer s2: shorter
    public String smallest(String s1, String s2) {
        // key: character value: number of it
        Map<Character, Integer> map = countMap(s2);
        // record how many distinct characters have been matched, only when all distinct characters are matched
        // match == map.size(), we find an anagram
        int match = 0;
        int j = 0;
        int min = Integer.MAX_VALUE;
        int index = -1;

        for (int i = 0; i < s1.length(); i++) {
            // handle the rightmost character
            char tmp = s1.charAt(i);
            Integer count = map.get(tmp);
            if (count != null) {
                map.put(tmp, count - 1);
                if (map.get(tmp) == 0) {
                    match++;
                }
            }
            // handle the leftmost character
            while (match == map.size()) {
                // update
                if (i - j + 1 < min) {
                    min = i - j + 1;
                    index = j;
                }
                tmp = s1.charAt(j);
                count = map.get(tmp);
                if (count != null) {
                    map.put(tmp, count + 1);
                    if (map.get(tmp) > 0) {
                        match--;
                    }
                }
                j++;
            }

        }
        if (min== Integer.MAX_VALUE) {
            // did not find
            return "";
        }
        return s1.substring(index, index + min);
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
        SmallestSubstringContainingAllCharactersOfAnotherString substringContainingAllCharactersOfAnotherString
                = new SmallestSubstringContainingAllCharactersOfAnotherString();
        String res = substringContainingAllCharactersOfAnotherString.smallest("The given test strings", "itsst");
        System.out.println(res);
    }
}
