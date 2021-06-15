package debugLaicode;

import java.util.*;

public class PalindromePartition {
    List<String> path = new ArrayList<>();
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        dfs(0, s);
        return res;
    }

    private void dfs(int i, String s) {
        // base case
        if (i == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        // recursive rule
        for (int j = i + 1; j <= s.length(); j++) {
            String sub = s.substring(i, j);
            if (isP(sub)) {
                path.add(sub);
                dfs(j, s);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isP(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
