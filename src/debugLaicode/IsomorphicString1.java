package debugLaicode;

import java.util.*;

public class IsomorphicString1 {
    public boolean isomorphic(String s, String t) {
        // word pattern
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        Set<Character> set = new HashSet<>();

        if (s.length() != t.length()) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (map.containsKey(c1)) {
                if (c2 != map.get(c1)) return false;
            } else {
                if (set.contains(c2)) return false;
                map.put(c1, c2);
                set.add(c2);
            }
        }
        return true;
    }
}
