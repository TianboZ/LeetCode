package debugLaicode;
/*
    barfoothefoobarman
         j  moves to right
     i moves to left (0 <= i <= j)

     for each substirng[i, j], where   i + m * k  - 1 = j, chech substring if can be concatenate by all the words

     time O((n - (m * k)) * m)   n is s.length()   m = words.legnth    k = word average length


*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || words.length == 0) return res;

        int m = words.length;
        int k = words[0].length();

        for (int i = 0; i < s.length(); i++) {
            int j = i + m * k - 1;
            if (j < s.length()) {
                String sub = s.substring(i, j + 1);
                Map<String, Integer> map = new HashMap<>();
                for (String word: words) {
                    map.put(word, map.getOrDefault(word, 0) + 1);
                }
                if (helper(sub, map, k)) {
                    res.add(i);
                }
            }
        }
        return res;
    }

    // check if s can be cancatenate by all the words
    private boolean helper(String s, Map<String, Integer> map, int k) {
        int match = 0;
        // catbig
        // 012345   len = 6
        for (int i = 0; i <= s.length() - k; i = i + k) {
            String str = s.substring(i, i + k);
            //System.out.println(str);
            Integer count = map.get(str);
            if (count == null) return false;
            else {
                map.put(str, count - 1);
                if (count == 1) match++;
            }
        }
        return match == map.size();
    }
}
