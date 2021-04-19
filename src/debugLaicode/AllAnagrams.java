package debugLaicode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class AllAnagrams {
    // sol0
    // time o(m + n)
    // space o(1) since map only has at most 26 chacters

    public List<Integer> findAnagrams3(String s, String p) {
        Map<Character, Integer> mapp = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        List<Integer> res = new ArrayList<>();

        for (char c: p.toCharArray()) {
            mapp.put(c, mapp.getOrDefault(c, 0) + 1);
        }

        int fast = 0;

        char[] chars = s.toCharArray();

        while (fast < chars.length) {
            // handle fast
            char ch = chars[fast];
            window.put(ch, window.getOrDefault(ch, 0) + 1);


            // handle element on the left side of window
            int slow = fast - p.length();
            if (slow >= 0) {
                ch  = chars[slow];
                if (window.get(ch) == 1) {
                    window.remove(ch);
                } else {
                    window.put(ch, window.get(ch) - 1);
                }
            }

            if(window.equals(mapp)) {
                res.add(slow + 1);
            }
            fast++;
        }
        return res;
    }

    // sol1
//    public List<Integer> allAnagrams(String sh, String lo) {
//        // sanity check
//
//        // key: character   value: how many needed
//        Map<Character, Integer> window = new HashMap<>();
//        countFrequency(window, sh);
//        List<Integer> res = new ArrayList<>();
//        int match = 0;
//
//        for (int fast = 0; fast < lo.length(); fast++) {
//            // handle rightmost character at current window
//            char c = lo.charAt(fast);
//            if (window.containsKey(c)) {
//                window.put(c, window.get(c) - 1);
//                if (window.get(c) == 0) {
//                    match++;
//                }
//            }
//
//            // handle leftmost character at previous current window
//            int slow = fast - sh.length();
//            if (slow >= 0) {
//                c = lo.charAt(slow);
//                if (window.containsKey(c)) {
//                    window.put(c, window.get(c) + 1);
//                    if (window.get(c) == 1) {
//                        match--;
//                    }
//                }
//            }
//            // current window
//            if (match == window.size()) {
//                res.add(slow + 1);
//            }
//        }
//        return res;
//    }

    // sol2:
    public List<Integer> allAnagrams2(String sh, String lo) {
        HashMap<Character, Integer> pattern = new HashMap<>();   // key: char   value: frequency
        HashMap<Character, Integer> window = new HashMap<>();   // key: char   value: frequency
        countFrequency(pattern, sh);
        List<Integer> res = new ArrayList<>();

        int fast = 0;
        int match = 0;

        while (fast < lo.length()) {
            // handle fast pointer
            char ch = lo.charAt(fast);
            if (pattern.containsKey(ch)) {
                window.put(ch, window.getOrDefault(ch, 0) + 1);
                if (window.get(ch) == pattern.get(ch)) {
                    match++;
                }
            }

            // handle leftmost element at previous window
            int slow = fast - sh.length() + 1; // leftmost element index of window
            if (slow - 1 >= 0) {
                ch = lo.charAt(slow - 1);
                if (pattern.containsKey(ch)) {
                    window.put(ch, window.get(ch) - 1);
                    if (window.get(ch) == pattern.get(ch) - 1) {
                        match--;
                    }
                }
            }


            // current window
            if (match == pattern.size()) {
                res.add(slow + 1);
            }
            fast++;
        }
        return res;
    }

    private void countFrequency(Map<Character, Integer> map, String str) {
        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
    }

//    public static void main(String[] args) {
//        AllAnagrams allAnagrams =new AllAnagrams();
//        System.out.println(allAnagrams.allAnagrams("aab", "ababacbbaac"));
//    }
}

// time o(n)    n is size of l
// space o(m)   m is size of p