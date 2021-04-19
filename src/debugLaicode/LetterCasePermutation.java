package debugLaicode;
import java.util.*;

public class LetterCasePermutation {
    List<String> res = new ArrayList<>();
    public List<String> letterCasePermutation(String S) {
        dfs(S.toCharArray(), 0);
        return res;
    }
    private void dfs(char[] chars, int i) {
        // base case
        if (i == chars.length) {
            res.add(new String(chars));
            return;
        }

        // recursive rule
        char c = chars[i];
        if (Character.isLetter(c)) {
            // case 1, lowercase
            chars[i] = Character.toLowerCase(c);
            dfs(chars, i + 1);
            chars[i] = c;

            // caes2, uppercase
            chars[i] = Character.toUpperCase(c);
            dfs(chars, i + 1);
            chars[i] = c;

        } else {
            dfs(chars, i + 1);
        }
    }
}
