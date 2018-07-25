package debugLaicode;

import java.util.HashSet;
import java.util.Set;

public class DictionaryWord1 {
    public boolean canBreak(String input, String[] dict) {
        // Write your solution here
        Set<String> set = new HashSet<>();
        for (String s : dict) {
            set.add(s);
        }
        boolean[] dp = new boolean[input.length() + 1];
        // dp[i] represnet if first i characters can be
        // composed by dictonary

        // base-case
        dp[0] = true;

        // inductive rule
        for (int i = 0; i <= input.length(); i++) {
            for (int j = 0; j <= i - 1; j++) {
                if (dp[j] && set.contains(input.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[input.length()];
    }
}
