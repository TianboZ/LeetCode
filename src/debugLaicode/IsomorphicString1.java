package debugLaicode;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicString1 {
    public boolean isomorphic(String source, String target) {
        // Write your solution here
        // sanity check
        if (source.length() != target.length()) return false;

        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();

        for (int i = 0; i < source.length(); i++) {
            char c1 = source.charAt(i);
            char c2 = target.charAt(i);

            map1.put(c1, c2);
            map2.put(c2, c1);
            if (map1.size() != map2.size()) return false;
        }
        return true;
    }
}
