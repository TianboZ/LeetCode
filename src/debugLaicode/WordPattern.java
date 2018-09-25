package debugLaicode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordPattern {
    public boolean wordPatternMatch(String pattern, String input) {
        // Write your solution here
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        return dfs(map, pattern, input, 0, 0, set);
    }
    // map:   e.g.  a: apple   b: banana
    private boolean dfs(Map<Character, String> map, String pattern,
                        String input, int index, int start, Set<String> set) {
        // base-case
        if (index == pattern.length() && start == input.length()) {
            System.out.println(map);
            return true;
        }
        if (index >= pattern.length() || index >= input.length()) {
            return false;
        }
        // recursive rule
        System.out.println(map);
        char c = pattern.charAt(index);
        String toMatch = map.get(input.charAt(index));
        if (toMatch != null) {

        }


        for (int len = 1; start + len - 1 < input.length(); len++) {
            String s = input.substring(start, start + len);
            System.out.println(s);
            //String toMatch = map.get(input.charAt(index));
            if (toMatch == null) {

                if (set.contains(s)) {
                    continue;
                }

                set.contains(s);
                map.put(pattern.charAt(index), s);
                if( dfs(map, pattern, input, index + 1, start + len, set)) {
                    map.remove(pattern.charAt(index));
                    set.remove(s);
                    return true;
                }
                map.remove(pattern.charAt(index));
                set.remove(s);
            } else {
                if (toMatch.equals(s)) {
                    if( dfs(map, pattern, input, index + 1, start + len, set)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        WordPattern wordPattern = new WordPattern();
        wordPattern.wordPatternMatch("aab", "xyzxzyabc");
    }
}
