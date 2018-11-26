package debugLaicode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        // sanity check
        List<Integer> res = new ArrayList<>();
        if (s.length() == 0) {
            return res;
        }
        if (p.length() > s.length()) {
            return res;
        }

        Map<Character, Integer> map = new HashMap<>();

        // count the frequency of each character in p
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int match = 0; // initial 0 characters match

        for (int fast = 0;  fast < s.length(); fast++) {
            // handle fast pointer
            char c = s.charAt(fast);
            Integer count = map.get(c);
            if (count != null) {
                map.put(c, count - 1);
                if (map.get(c) == 0) match++;
            }

            // 1 2 3 4
            // s     f
            // handle left pointer
            int slow = fast - p.length();
            if (slow >= 0) {
                c = s.charAt(slow);
                count = map.get(c);
                if (count != null) {
                    map.put(c, count + 1);
                    if (map.get(c) > 0) match--;
                }
            }

            // for the current window [slow, fast]
            if (match == map.size()) {
                res.add(slow + 1);
            }
        }
        Map<StringBuilder, StringBuilder> map1 = new HashMap<>();
        return res;
    }

    public List<Integer> findAnagrams1(String s, String p) {
        // sanity check
        List<Integer> res = new ArrayList<>();
        if (s.length() == 0) {
            return res;
        }
        if (p.length() > s.length()) {
            return res;
        }

        Map<Character, Integer> target = new HashMap<>(); // original target map
        Map<Character, Integer> window = new HashMap<>(); // sliding window map

        // count the frequency of each character in p
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            target.put(c, target.getOrDefault(c, 0) + 1);
        }

        int match = 0; // initial 0 characters match

        for (int fast = 0; fast < s.length(); fast++) {
            // handle fast pointer
            char c = s.charAt(fast);
            if (target.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c) >= target.get(c)) match++;
            }
            // handle left pointer
            int slow = fast - p.length();
            if (slow >= 0) {
                c = s.charAt(slow);
                if (target.containsKey(c)) {
                    window.put(c, window.get(c) - 1);
                    if (window.get(c) < target.get(c)) match--;
                }
            }
            // for the current window [slow, fast]
            if (match == target.size()) {
                res.add(slow + 1);
            }
        }
        return res;
    }

}

// time o(n)    n is size of l
// space o(m)   m is size of p