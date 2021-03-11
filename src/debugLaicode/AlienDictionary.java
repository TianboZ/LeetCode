package debugLaicode;

import java.util.*;

public class AlienDictionary {
    public String alienOrder(String[] words) {
        // Write your solution here
        Map<Character, Set<Character>> graph = new HashMap<>();
        buildGraph(graph, words);
        Deque<Character> stack = new LinkedList<>();
        Map<Character, Integer> state = new HashMap<>();
        Set<Character> nodes = new HashSet<>();
        // get all nodes
        for (String s : words) {
            for (char ch : s.toCharArray()) {
                nodes.add(ch);
            }
        }

        for (Character node : nodes) {
            if (dfs(graph,state, node, stack)) {
                return "";
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollFirst());
        }
        return sb.toString();
    }


    // return true if has cycle
    private boolean dfs(
            Map<Character, Set<Character>> graph,
            Map<Character, Integer> state,
            char c,
            Deque<Character> stack
    ) {
        // baes case
        Integer i = state.get(c);
        if (i != null) {
            if (i == 0) return true; // visiting
            if (i == 1) return false; // visited
        }

        // recursive rule
        state.put(c, 0);
        Set<Character> neis = graph.get(c);
        if (neis != null) {
            for (Character ch : neis) {
                if (dfs(graph, state, ch, stack)) return true;
            }
        }

        state.put(c, 1);
        stack.offerFirst(c);
        return false;
    }

    private void buildGraph(Map<Character, Set<Character>> map, String[] arr) {
        // take two words and find the first mis-match character
        for (int i = 0; i < arr.length - 1; i++) {
            String s1 = arr[i];
            String s2 = arr[i + 1];
            int j = 0;
            while (j < s1.length() && j < s2.length()) {
                if (s1.charAt(j) != s2.charAt(j)) {
                    Set<Character> set = map.get(s1.charAt(j));
                    if (set == null) {
                        set = new HashSet<>();
                        map.put(s1.charAt(j), set);
                    }
                    set.add(s2.charAt(j));
                    break;
                }
                j++;
            }
        }
    }

//    // step1: get adjacent map, e.g. Map<Character, Set<Character>> map    key: character value: all the character after key
//    // step2: get all characters, store in the HashSet<Character>
//    // step3: topoloty sort
//    public String alienOrder(String[] words) {
//        Set<Character> set = getAllChar(words);
//        Map<Character, Set<Character>> map = buildGraph(words);
//        Map<Character, Integer> state = new HashMap<>();
//        //System.out.println(map);
//        Deque<Character> stack = new LinkedList<>();
//        //System.out.println(set);
//        for (Character c : set) {
//            if (!topologySort(map, stack, state, c)) return "";
//        }
//        StringBuilder sb = new StringBuilder();
//        while (!stack.isEmpty()) {
//            sb.append(stack.pollFirst());
//        }
//
//        return sb.toString();
//    }
//    // time O(n * m)             n is # of words, m is length of each word
//    private Map<Character, Set<Character>> buildGraph(String[] words) {
//        Map<Character, Set<Character>> map = new HashMap<>();
//        for (int i = 0; i < words.length - 1; i++) {
//            String s1 = words[i];
//            String s2 = words[i + 1];
//
//            // compare pair of words
//            int i1 = 0;
//            int i2 = 0;
//
//            boolean isDiff = false;
//            while (i1 < s1.length() && i2 < s2.length()) {
//                if(s1.charAt(i1) != s2.charAt(i2)) {
//                    // character is diff
//                    if (!isDiff) {
//                        // fisrt time find the diff character
//                        isDiff = true;
//                        Set<Character> set = map.get(s1.charAt(i1));
//                        if (set == null) {
//                            set = new HashSet<>();
//                            set.add(s2.charAt(i2));
//                            map.put(s1.charAt(i1), set);
//                        } else {
//                            set.add(s2.charAt(i2));
//                        }
//                    } else {
//                        break;
//                    }
//                    i1++;
//                    i2++;
//                } else {
//                    i1++;
//                    i2++;
//                }
//            }
//        }
//        return map;
//    }
//
//    private Set<Character> getAllChar(String[] arr) {
//        Set<Character> set = new HashSet<>();
//        for (String s : arr) {
//            for (int i = 0; i < s.length(); i++) {
//                set.add(s.charAt(i));
//            }
//        }
//        return set;
//    }
//
//    // return false if find cycle
//    private boolean topologySort(Map<Character, Set<Character>> map, Deque<Character> stack, Map<Character, Integer> state, char c) {
//        //System.out.println("a");
//        //System.out.println(state);
//        // base-case
//        if (state.containsKey(c)) {
//            if (state.get(c) == 0) return true;
//            if (state.get(c) == 1) return false;
//        }
//
//
//        // recursive rule
//        state.put(c, 1); // visiting a node
//        Set<Character> set = map.get(c);
//        if (set != null) {
//            for (Character nei : set) {
//                if (!topologySort(map, stack, state, nei)) return false;
//            }
//
//        }
//        stack.offerFirst(c);
//        state.put(c, 0); // finished visiting a ndoe
//        return true;
//    }

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