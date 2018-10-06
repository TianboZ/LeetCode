package debugLaicode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class IsSubsequence {
    // ahbgdcab
    // 01234567

    // a: 0, 6
    // b: 2, 7
    // h: 1
    // g: 3
    // d: 4
    // Map<key: char, value: treeset<index>>
    public boolean isSubsequence(String s, String t) {
        Map<Character, TreeSet<Integer>> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            TreeSet<Integer> set = map.get(t.charAt(i));
            if (set == null) {
                set = new TreeSet<>();
                map.put(t.charAt(i), set);
            }
            set.add(i);
        }
        int prev = -1; // initial
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            TreeSet<Integer> set = map.get(c);
            if (set == null) return false;
            if (prev == -1) {
                prev = set.first();
            } else {
                Integer tmpt = set.higher(prev); // find the smallest larger than prev
                if (tmpt == null) return false;
                prev = tmpt;
            }
        }
        return true;
    }
}
