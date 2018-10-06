package debugLaicode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class NumberOfMatchingSubsequences {
    public int numMatchingSubseq(String S, String[] words) {
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
        for (String s : words) {
            if (isSubsequence(s, S, map)) count++;
        }
        return count;
    }
    public boolean isSubsequence(String s, String t, Map<Character, TreeSet<Integer>> map) {

        int prev = -1; // initial
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
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
