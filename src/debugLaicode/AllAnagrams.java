package debugLaicode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllAnagrams {
    public List<Integer> allAnagrams(String s, String l) {
        List<Integer> res = new ArrayList<>();
        if (l.length() == 0) {
            return res;
        }
        if (s.length() > l.length()) {
            return res;
        }
        // key: character value: number of it
        Map<Character, Integer> map = countMap(s);
        // record how many distinct characters have been matched, only when all distinct characters are matched
        // match == map.size(), we find an anagram
        int match = 0;
        // we have a sliding window of size s.length(), and since the size is fixed, we only need to record the end index
        // of the window by one step from left to right
        for (int i = 0; i < l.length(); i++) {
            // handle the rightmost character
            char tmp = l.charAt(i);
            Integer count = map.get(tmp);
            if (count != null) {
                map.put(tmp, count - 1);
                if (count == 1) {
                    match++;
                }
            }
            // handle the leftmost character
            if (i >= s.length()) {
                tmp = l.charAt(i - s.length());
                count = map.get(tmp);
                if (count != null) {
                    map.put(tmp, count + 1);
                    if (count == 0) {
                        match--;
                    }
                }
            }

            // for the current sliding window, if all the distinct characters are matched
            if (match == map.size()) {
                res.add(i - s.length() + 1);
            }
        }
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

}