package debugLaicode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class MinimumWindowSubsequence {
    public String minWindow(String S, String T) {
        // key: char   value: set of index, store them in the treeset in incrasing order
        Map<Character, TreeSet<Integer>> map = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            TreeSet<Integer> set = map.get(S.charAt(i));
            if (set == null) {
                set = new TreeSet<>();
                map.put(S.charAt(i), set);
            }
            set.add(i);
        }
        String res = "";
        int min = Integer.MAX_VALUE;

        TreeSet<Integer> indice = map.get(T.charAt(0));
        if (indice == null) return "";

        // iterate each char in T, to find the smallest window
        for (Integer index : indice) {
            int prev = index; // initial
            boolean find = true;
            for (int i = 1; i < T.length(); i++) {
                char c = T.charAt(i);
                TreeSet<Integer> set = map.get(c);
                if (set == null) {
                    find = false;
                    break;
                }

                Integer tmpt = set.higher(prev); // find the smallest larger value than prev
                if (tmpt == null) {
                    find = false;
                    break;
                }
                prev = tmpt;
            }
            if (find && prev + 1 - index < min) {
                min = prev + 1 - index;
                res = S.substring(index, prev + 1);
            }
        }
        return res;
    }
}