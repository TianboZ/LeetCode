package debugLaicode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/*
compare given s with word in the dictionary, determine if word is a sebsequence of s
find the longeset word that is sebsequence of s

how to determine w is subsequence of s?
s = abpcplea
    01234567

a: 0, 7
b: 1
p: 2, 4
c: 3
l: 5
e: 6

w = apple


time o(m * p * logn)   m = dict size       n = s.length();    p = average length of string in dict
*/
public class LongestWordInDictionaryThroughDeleting {
    public String findLongestWord(String s, List<String> d) {
        Map<Character, TreeSet<Integer>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            TreeSet<Integer> set = map.get(s.charAt(i));
            if (set == null) {
                set = new TreeSet<>();
                map.put(s.charAt(i), set);
            }
            set.add(i);
        }

        int max = -1;
        String res = "";
        for (String word : d) {
            //if (helper(word, map)) {
            if (isSubsequence1(word, s)) {
                if (word.length() > max) {
                    max = word.length();
                    res = word;
                } else if (word.length() == max) {
                    if (word.compareTo(res) < 0) {
                        res = word;
                    }
                }
            }
        }
        return res;
    }
    // determine if word is a sebsequence of s
    private boolean helper(String d, Map<Character, TreeSet<Integer>> map) {
        int index = -1;
        for (int i = 0; i < d.length(); i++) {
            char c = d.charAt(i);
            TreeSet<Integer> set = map.get(c);
            if (set == null) return false;

            if (index == -1) {
                index = set.first();
            } else {
                Integer k = set.higher(index);
                if (k == null) return false;
                index = k;
            }
        }
        return true;
    }
    public boolean isSubsequence1(String s, String t) {
        int j = 0;
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == s.charAt(j)) {
                j++;
                if (j == s.length()) return true;
            }
        }
        return false;
    }
}