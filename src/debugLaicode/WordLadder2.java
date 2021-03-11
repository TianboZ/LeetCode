package debugLaicode;


import java.util.*;

public class WordLadder2 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        // Write your solution here
        List<List<String>> res = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        Set<String> words = new HashSet<>(wordList);
        Map<String, List<String>> map = new HashMap<>(); // key: string  value: list of strings that can
        // transform to key
        int level = 0;

        // initial
        q.offer(beginWord);
        visited.add(beginWord);

        // terminate
        label:
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                // expand
                String curr = q.poll();
                if (curr.equals(endWord)) {
                    break label;
                }

                // generate
                char[] currWord = curr.toCharArray();
                for (int j = 0; j < currWord.length; j++) {
                    for (int k = 0; k < 26; k++) {
                        currWord[j] = (char) ('a' + k);
                        String s = new String(currWord);
                        currWord[j] = curr.charAt(j); // ! restore
                        if (words.contains(s) && !visited.contains(s)) {
                            q.offer(s);
                            visited.add(s);
                        }
                    }
                }
            }
            level++;
        }

        dfs(wordList, res, new ArrayList<>(), new HashSet<>(), beginWord, endWord, 0, level);
        return res;
    }

    private void dfs(
            List<String> words,
            List<List<String>> res,
            List<String> path,
            Set<String> visited,
            String curr,
            String end,
            int currLevel,
            int level
    )  {
        // base case
        if (visited.contains(curr)) return;
        if (currLevel == level) {
            if (curr.equals(end)) {
                List<String> tmpt = new ArrayList<>(path);
                tmpt.add(curr);
                res.add(tmpt);
            }
            return;
        }

        // recursive rule
        path.add(curr);
        visited.add(curr);

        char[] currWord = curr.toCharArray();
        for (int j = 0; j < currWord.length; j++) {
            for (int k = 0; k < 26; k++) {
                currWord[j] = (char) ('a' + k);
                String s = new String(currWord);
                currWord[j] = curr.charAt(j); // ! restore
                if (words.contains(s) && !visited.contains(s)) {
                    dfs(words, res, path, visited, s, end, currLevel + 1, level);
                }
            }
        }

        visited.remove(curr);
        path.remove(path.size() - 1);
    }

    // will timeout, but easy to understand
    private boolean isOneCharDiff(String s1, String s2) {
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
                if (count == 2) return false;
            }
        }
        return true;
    }

//    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
//        Set<String> set = new HashSet<>(wordList);
//        Map<String, List<String>> prevMap = new HashMap<>();
//        bfs(beginWord, endWord, prevMap, set);
//
//        List<List<String>>  res = new ArrayList<>();
//        List<String> path = new ArrayList<>();
//        // recover the all paths
//        recoverPath(endWord, beginWord, prevMap, path, res);
//        return res;
//    }
//    // run BFS algorithm, to find the shortest path from begin word to end word
//    private void bfs(String beginWord, String endWord, Map<String, List<String>> prevMap, Set<String> set) {
//        Queue<String> q = new LinkedList<>();
//        Map<String, Integer> levels = new HashMap<>();
//        int level = 0;
//        // initial
//        q.offer(beginWord);
//        levels.put(beginWord, 0);
//
//        while (!q.isEmpty()) {
//            int size = q.size();
//            for (int k = 0; k < size; k++){
//                // expand
//                String curr = q.poll();
//                if (curr.equals(endWord)) return; // terminate
//                // generate
//                char[] arr = curr.toCharArray();
//                for (int i = 0; i < curr.length(); i++) {
//                    char t = curr.charAt(i);
//                    for (int j = 0; j < 26; j++) {
//                        arr[i] = (char)('a' + j);
//                        String next = new String(arr);
//                        if (set.contains(next)) {
//                            if (!levels.containsKey(next)) {
//                                levels.put(next, level + 1);
//                                prevMap.put(next, new ArrayList<>());
//                                prevMap.get(next).add(curr);
//                                q.offer(next);
//                            } else if (level + 1 == levels.get(next)) {
//                                prevMap.get(next).add(curr);
//                            }
//                        }
//                    }
//                    arr[i] = t;
//                }
//            }
//            //if (levels.containsKey(endWord)) return;
//            level++;
//        }
//    }
//
//    private  void recoverPath(String node, String init,  Map<String, List<String>> prevMap, List<String> path, List<List<String>> res) {
//        // base-case
//        if (node.equals(init)) {
//            path.add(init);
//            List<String> tmpt =  new ArrayList<>(path);
//            Collections.reverse(tmpt);
//            res.add(tmpt);
//            path.remove(path.size() - 1);
//            //System.out.println(res.size());
//            return;
//        }
//        // recursive rule
//        path.add(node);
//        if (prevMap.containsKey(node)) {
//            for (String nei: prevMap.get(node)) {
//                recoverPath(nei, init, prevMap, path, res);
//            }
//        }
//        path.remove(path.size() - 1);
//    }

    public static void main(String[] args) {
        WordLadder2 sol = new WordLadder2();
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
        sol.findLadders(beginWord, endWord, wordList);
    }

}