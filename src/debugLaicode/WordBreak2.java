package debugLaicode;

import java.util.*;

public class WordBreak2 {
    StringBuilder sb = new StringBuilder();
    Set<String> words = new HashSet<>();
    List<String>  res = new ArrayList<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        for (String w : wordDict) words.add(w);

        dfs(s, 0);
        return res;
    }
    private void dfs(String s, int i) {
        // base case
        if (i == s.length()) {
            sb.deleteCharAt(sb.length() - 1);
            res.add(sb.toString());
            return;
        }
        // recursive rule
        for (int j = i + 1; j <= s.length(); j++) {
            if (words.contains(s.substring(i, j))) {
                int len = sb.length();
                sb.append(s.substring(i, j)).append(" ");
                dfs(s, j);
                sb.setLength(len);
            }
        }
    }
}
