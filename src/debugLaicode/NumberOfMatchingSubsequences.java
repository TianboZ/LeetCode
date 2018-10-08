package debugLaicode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class NumberOfMatchingSubsequences {
    public int numMatchingSubseq(String S, String[] words) {

        // o(mlogm)    m = s.length
        Map<Character, TreeSet<Integer>> map = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            TreeSet<Integer> set = map.get(S.charAt(i));
            if (set == null) {
                set = new TreeSet<>();
                map.put(S.charAt(i), set);
            }
            set.add(i);
        }
        int count = 0;
        for (String word : words) {
            if (isSubsequence(word, map)) count++;
        }
        // total: o(mlogm)  +  o(k * nlogm)   k = words.length
        return count;
    }

    // time o(nlogm)   n = word.length
    public boolean isSubsequence(String word, Map<Character, TreeSet<Integer>> map) {
        int prev = -1; // initial
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            TreeSet<Integer> set = map.get(c);
            if (set == null) return false;
            if (prev == -1) {
                prev = set.first();
            } else {
                Integer tmpt = set.higher(prev);
                if (tmpt == null) return false;
                prev = tmpt;
            }
        }
        return true;
    }
}
