package debugLaicode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordPattern {
    Map<Character, String> map = new HashMap<>(); // p --> s
    Map<String, Character> map2 = new HashMap<>();  // s --> p
    boolean found;

    public boolean wordPatternMatch(String pattern, String s) {
        dfs(pattern, s, 0, 0);
        return found;
    }

    private void dfs(String p, String s, int ip, int is) {
        // base case
        if (found) return;
        if (ip >= p.length() || is >= s.length()) {

            if (ip == p.length() && is == s.length()) {
                found = true;
                return;
            }
            return;
        }

        // recursive rule
        char c = p.charAt(ip);
        if (map.containsKey(c)) {
            String subs = map.get(c);
            int start = s.indexOf(subs, is);

            if (start == is) {
                dfs(p, s, ip + 1, is + subs.length());
            }
        } else {
            for (int j = is + 1; j <= s.length(); j++) {
                String subString = s.substring(is, j);
                if (!map2.containsKey(subString)) {
                    map.put(c, subString);
                    map2.put(subString, c);
                    dfs(p, s, ip + 1, j);
                    map.remove(c);
                    map2.remove(subString);
                }
            }
        }
    }

    public static void main(String[] args) {
        WordPattern sol = new WordPattern();
        sol.wordPatternMatch("aab", "xyzxzyabc");
    }
}
