package debugLaicode;

import java.util.*;

public class AlienDictionary {

    public static void main(String[] args) {
        AlienDictionary alienDictionary = new AlienDictionary();
        String[] words = {  "wrt",
                            "wrf",
                            "er",
                            "ett",
                            "rftt"};
        alienDictionary.alienOrder(words);
    }

    String res;

    public String alienOrder(String[] words) {
        res = "";
        Map<Character, Set<Character>> map = findNeibor(words);
        System.out.println(map.size());
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Set<Character>> entry : map.entrySet()) {
            char firstChar = entry.getKey();
            System.out.println(firstChar);
            System.out.println("aaaaaaaaa");
            dfs(sb, firstChar, map);
        }
        System.out.println(res);
        return res;
    }
    // find all the path characters
    public void dfs(StringBuilder sb, char c, Map<Character, Set<Character>> map) {
        // base-case
        if (map.get(c).size() == 0) { // character c is last one, no character follows
            //System.out.println(sb.length());
            System.out.println(sb);
            if (sb.length() == map.size()) {
                res = sb.toString();
            }
            return;
        }

        // recursive rule
        Set<Character> set = map.get(c);
        for (Character character : set) {
            if (character == c) {
                continue;
            }
            sb.append(character);
            dfs(sb, character, map);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    // hardest part
    // build graph
    public Map<Character, Set<Character>> findNeibor(String[] words) {
        Map<Character, Set<Character>> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                char tmp = words[i].charAt(j);
                if (!map.containsKey(tmp)) {
                    map.put(tmp, new HashSet<>());
                }
                // rest char of same row
                for (int k = j + 1; k < words[i].length(); k++) {
                    map.get(tmp).add(words[i].charAt(k));
                }
                // rest char of whole String[]
                for (int h = i + 1; h < words.length; h++) {
                    for (int m = 0; m < words[h].length(); m++) {
                        map.get(tmp).add(words[h].charAt(m));
                    }
                }
                map.get(tmp).remove(tmp);
            }
        }
        System.out.println(map);
        return map;
    }
}