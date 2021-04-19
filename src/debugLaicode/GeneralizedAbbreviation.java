package debugLaicode;

import java.util.ArrayList;
import java.util.List;

/*

  DFS, backtracking problem

  use `1` to represent character is abbreviated
           word
           /  \
   w      w    1
          /\    /\

   o    wo  w1  1o 11


   ...



   keep track of path information
   at all recurstion tree leaf node, we post process e.g.  `111a` --> `3a`

   time o(n * branch ^ level)  =  (n * 2 ^ n)       n  is word length

*/
public class GeneralizedAbbreviation {
    StringBuilder sb = new StringBuilder();
    List<String> res = new ArrayList<>();

    public List<String> generateAbbreviations(String word) {
        dfs(word, 0);
        return res;
    }
    private void dfs(String w, int i) {
        // base case
        if (i >= w.length()) {
            res.add(process(sb));
            return;
        }
        // recursive rule
        char c = w.charAt(i);
        sb.append(c);
        dfs(w, i + 1);
        sb.deleteCharAt(sb.length() - 1);

        sb.append('1');
        dfs(w, i + 1);
        sb.deleteCharAt(sb.length() - 1);
    }
    private String process(StringBuilder sb) {
        // 111a --> 3a
        StringBuilder  tmp = new StringBuilder();

        int i = 0;
        while (i < sb.length()) {
            if (sb.charAt(i) == '1') {
                int j = i;
                while (j < sb.length() && sb.charAt(j) == '1') {
                    j++;
                }
                tmp.append(j - i);
                i = j;
            } else {
                tmp.append(sb.charAt(i));
                i++;
            }
        }
        return tmp.toString();
    }
}
