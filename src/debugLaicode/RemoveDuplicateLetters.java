package debugLaicode;

import java.util.*;

public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
        }
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(res, 0, s, sb, new HashSet<>(), set.size());

        Collections.sort(res);
        //System.out.println(res);
        return res.get(0);
    }
    // get all valid string  that has no duplicate
    private void dfs(List<String> res, int index, String s, StringBuilder sb, Set<Character> set, int len) {
        // base-case
        if (set.size() == len) {
            res.add(sb.toString());
            return;
        }
        if (index == s.length()) {

            return;
        }
        // recursive rule
        //case1, add s.charAt(index)
        boolean flag = false;
        if (!set.contains(s.charAt(index))) {
            sb.append(s.charAt(index));
            set.add(s.charAt(index));
            dfs(res, index + 1, s, sb, set, len);
            sb.deleteCharAt(sb.length() - 1);
            set.remove(s.charAt(index));
        }

        //case2, not add s.charAt(index)
        dfs(res, index + 1, s, sb, set, len);
    }

    public static void main(String[] args) {
        RemoveDuplicateLetters removeDuplicateLetters = new RemoveDuplicateLetters();
        removeDuplicateLetters.removeDuplicateLetters("bcabc");
    }
}
