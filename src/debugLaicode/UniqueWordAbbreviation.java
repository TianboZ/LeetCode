package debugLaicode;

import java.util.*;

public class UniqueWordAbbreviation {
    // key: abbr  value: set of original words
    private final Map<String, Set<String>> abbrDict = new HashMap<>();

    public UniqueWordAbbreviation(String[] dictionary) {
        for (String s : dictionary) {
            String abbr = toAbbr(s);

            Set<String> words = abbrDict.get(abbr);
            if (words == null) {
                words = new HashSet<>();
            }
            words.add(s);
            abbrDict.put(abbr, words);
        }
    }

    public boolean isUnique(String word) {
        String abbr = toAbbr(word);
        Set<String> words = abbrDict.get(abbr);
        if (words == null) return true;
        return (words.size() == 1 && words.contains(word));
    }

    private String toAbbr(String s) {
        int n = s.length();
        if (n <= 2) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0)).append(s.length() - 2).append(s.charAt(s.length() - 1));
        return sb.toString();
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);

        List<Integer> list1 = new ArrayList<>();
        list.add(1);
        list.add(2);

        Set<List<Integer>> set = new HashSet<>();
        set.add(list);
        set.add(list1);
        System.out.println(set.size());
    }
}
