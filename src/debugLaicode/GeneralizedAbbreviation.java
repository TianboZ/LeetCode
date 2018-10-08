package debugLaicode;

import java.util.ArrayList;
import java.util.List;


/*

             [ ]
            /   \
          w      1
        /  \
      wo    w1
     /   \
   wor     wo1
   /\       /   \
 word wor1 wo1r  wo2

*/
public class GeneralizedAbbreviation {
    public List<String> generateAbbreviations(String word) {
        StringBuilder sb = new StringBuilder();
        List<String> res = new ArrayList<>();
        dfs(word, 0, sb, res, 0);
        return res;
    }
    // count: how many char we abbreviated
    private void dfs(String s, int index, StringBuilder sb, List<String> res, int count) {
        // base-case
        if (index == s.length()) {
            int len = sb.length();
            if (count != 0) sb.append(count);
            res.add(sb.toString());
            sb.setLength(len);  // this API is O(1)!
            return;
        }
        // rule
        // case1 keep
        char c = s.charAt(index);
        if (count != 0) {
            int len = sb.length();
            sb.append(count).append(c);
            dfs(s, index + 1, sb, res, 0);
            sb.setLength(len); // this API is O(1)!

        } else {
            sb.append(c);
            dfs(s, index + 1, sb, res, 0);
            sb.deleteCharAt(sb.length() - 1);
        }

        // case2 not keep
        dfs(s, index + 1, sb, res, count + 1);
    }
}
// time o(2^n)