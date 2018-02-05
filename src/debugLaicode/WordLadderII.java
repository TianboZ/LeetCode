package debugLaicode;


import java.util.*;

public class WordLadderII {
    public static void main(String[] args) {
        WordLadderII wordLadderII = new WordLadderII();


        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        wordList.add("dot");

        wordLadderII.findLadders(beginWord, endWord, wordList);
    }
    public void findLadders(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(beginWord)) {
            wordList.add(beginWord);
        }
        if (!wordList.contains(endWord)) {
            wordList.add(endWord);
        }

        Map<String, Set<String>> map = new HashMap<>();

        for (int i = 0; i < wordList.size(); i++) {
            for (int j = 0; j < wordList.size(); j++) {
                if (i == j) {
                    continue;
                }
                if (oneCharDiff(wordList.get(i), wordList.get(j))) {
                    if (map.containsKey(wordList.get(i))) {
                        map.get(wordList.get(i)).add(wordList.get(j));
                    } else {
                        Set<String> nei = new HashSet<>();
                        nei.add(wordList.get(j));
                        map.put(wordList.get(i), nei);
                    }
                }
            }
        }
        List<String> list = new ArrayList<>();
        Set<String> used = new HashSet<>();
        List<List<String>> res = new ArrayList<>();
        List<List<String>> sol = new ArrayList<>();
        list.add(beginWord);
        dfs(list, res, used, map, beginWord, endWord);

        int min = 1000;
        for (int i = 0; i < res.size(); i++) {
            if (res.get(i).size() < min) {
                min = res.get(i).size();
            }
        }
        //System.out.println(min);
        //System.out.println(res);
        for (int i = 0; i < res.size(); i++) {
            if (res.get(i).size() == min) {
                sol.add(new ArrayList<>(res.get(i)));
            }
        }
        System.out.println(sol);
    }

    public boolean oneCharDiff(String s1, String s2) {
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
            }
        }
        if (count > 1) {
            return false;
        } else {
            return true;
        }
    }

    public void  dfs(List<String> list, List<List<String>> res, Set<String> used, Map<String, Set<String>> map, String node, String endWord) {
        // base-case
        if (node.equals(endWord)) {
            res.add(new ArrayList<>(list));
            return;
        }

        // inductive rule
        Set<String> neis = map.get(node);
        for (String nei : neis) {
            if (!used.contains(nei)) {
                list.add(nei);
                used.add(nei);
                dfs(list, res, used, map, nei, endWord);
                list.remove(list.size() - 1);
                used.remove(nei);
            }
        }

    }
}
