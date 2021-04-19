package debugLaicode;

import java.util.*;

public class WordBreak {
    Set<String> words = new HashSet<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        for(String w: wordDict) words.add(w);
        return dfs(s, 0, new Boolean[s.length()]);
    }
    private boolean dfs(String s, int i, Boolean[] memo) {
        // baes case
        if (i == s.length()) return true;
        if (memo[i] != null) {
            return memo[i];
        }

        // recursive rule
        for (int j = i + 1; j <= s.length(); j++) {
            if (words.contains(s.substring(i, j)) && dfs(s, j, memo)) {
                memo[i] = true;
                return true;
            }
        }
        memo[i] = false;
        return false;
    }
}
