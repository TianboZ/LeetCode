package MianJing.thumbtack;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/*
* step1:
* for each string in dict, get the standardlized version, e.g. Reed --> rad
* rules: 1. change all letters to smaller case   2. change all consecutive vowels to one letter, which is 'a'
*
* step2:
* store them into map, Map<key: standard string, value: set of original string>
*     Map<String, Set<String>>
* */
public class CorrectMispelledWordDict {
    public static void main(String[] args) {
        Set<String> dict = new HashSet<>();
        dict.add("Red");
        dict.add("Blue");
        dict.add("Yellow");
        dict.add("YelloW");
        dict.add("aaa");
        dict.add("aa");
        System.out.println(correctMispelling(dict, "Red"));

    }
    public static Set<String> correctMispelling(Set<String> dict, String input) {
        // key: standard string, value: set of original string
        Map<String, Set<String>> map = new HashMap<>();
        for (String s : dict) {
            String std = standard(s);
            Set<String> set = map.get(std);
            if (set == null) {
                set = new HashSet<>();
                map.put(std, set);
            }
            set.add(s);
        }

        Set<String> res = map.get(standard(input));
        return res; // if cannot correct input string, return null

    }
    private static String standard(String s) {
        Set<Character> set = new HashSet<>();
        String str = s.toLowerCase();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length();i++) {
            if (set.contains(str.charAt(i))) {
                // vowel
                while (i < str.length() && set.contains(str.charAt(i))) {
                    i++;
                }
                sb.append('a');
            } else {
                // not vowel
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    // time O(mn + k)   n = dict size         m = dict word's average length   k = input string length
    // space O(n)

    ////////////////////////

}
