package debugLaicode;

import java.util.*;

public class AlienDictionary {
    public String alienOrder(String[] words) {
        // build graph
        Map<Character, Set<Character>> graph = new HashMap<>();
        for (String w : words) {
            for (char c : w.toCharArray()) {
                graph.put(c, new HashSet<>());
            }
        }
        for (int i = 0; i < words.length - 1; i++) {
            String s1 = words[i];
            String s2 = words[i + 1];
            // check s2 is not  prefix of s1
            if (s1.length() > s2.length() && s1.startsWith(s2)) {
                return "";
            }

            // first mis match char
            int j = 0;
            while (j < s1.length() && j < s2.length()) {
                if (s1.charAt(j) != s2.charAt(j)) {
                    Set<Character> set = graph.get(s1.charAt(j));
                    set.add(s2.charAt(j));
                    break;
                }
                j++;
            }
        }

        Map<Character, Integer> visit = new HashMap<>(); // 1: visiting  0: visited
        StringBuilder sb = new StringBuilder();

        // for each character, run DFS
        for (Character c : graph.keySet()) {
            if (dfs(graph, visit, sb, c)) return "";  // cycle
        }

        return sb.reverse().toString();
    }

    // return true if has cycle
    private boolean dfs(
            Map<Character, Set<Character>> graph,
            Map<Character, Integer> visit,
            StringBuilder sb,
            char node
    ) {
        // base case
        Integer state = visit.get(node);
        if (state != null && state == 1) return true;
        if (state != null && state == 0) return false;
        // recursive rule
        visit.put(node, 1);
        Set<Character> neis = graph.get(node);
        for (Character nei : graph.get(node)) {
            if (dfs(graph, visit, sb, nei)) return false;
        }
        visit.put(node, 0);
        sb.append(node);
        return false;
    }

    public static void main(String[] args) {
        AlienDictionary sol = new AlienDictionary();
        String[] words = {  "wrt",
                            "wrf",
                            "er",
                            "ett",
                            "rftt"
                         };

        Integer I = 1;
        int i = I;

        String s = sol.alienOrder(words);
        System.out.println(s);
    }
}