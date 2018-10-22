package debugLaicode;


import java.util.*;

public class WordLadder2 {
    public static void main(String[] args) {
        WordLadder2 wordLadder2 = new WordLadder2();


        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        wordList.add("dot");

        wordLadder2.findLadders(beginWord, endWord, wordList);
    }
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        Map<String, List<String>> prevMap = new HashMap<>();
        bfs(beginWord, endWord, prevMap, set);

        List<List<String>>  res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        // recover the all paths
        recoverPath(endWord, beginWord, prevMap, path, res);
        return res;
    }
    // run BFS algorithm, to find the shortest path from begin word to end word
    private void bfs(String beginWord, String endWord, Map<String, List<String>> prevMap, Set<String> set) {
        Queue<String> q = new LinkedList<>();
        Map<String, Integer> levels = new HashMap<>();
        int level = 0;
        // initial
        q.offer(beginWord);
        levels.put(beginWord, 0);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int k = 0; k < size; k++){
                // expand
                String curr = q.poll();
                if (curr.equals(endWord)) return; // terminate
                // generate
                char[] arr = curr.toCharArray();
                for (int i = 0; i < curr.length(); i++) {
                    char t = curr.charAt(i);
                    for (int j = 0; j < 26; j++) {
                        arr[i] = (char)('a' + j);
                        String next = new String(arr);
                        if (set.contains(next)) {
                            if (!levels.containsKey(next)) {
                                levels.put(next, level + 1);
                                prevMap.put(next, new ArrayList<>());
                                prevMap.get(next).add(curr);
                                q.offer(next);
                            } else if (level + 1 == levels.get(next)) {
                                prevMap.get(next).add(curr);
                            }
                        }
                    }
                    arr[i] = t;
                }
            }
            //if (levels.containsKey(endWord)) return;
            level++;
        }
    }

    private  void recoverPath(String node, String init,  Map<String, List<String>> prevMap, List<String> path, List<List<String>> res) {
        // base-case
        if (node.equals(init)) {
            path.add(init);
            List<String> tmpt =  new ArrayList<>(path);
            Collections.reverse(tmpt);
            res.add(tmpt);
            path.remove(path.size() - 1);
            //System.out.println(res.size());
            return;
        }
        // recursive rule
        path.add(node);
        if (prevMap.containsKey(node)) {
            for (String nei: prevMap.get(node)) {
                recoverPath(nei, init, prevMap, path, res);
            }
        }
        path.remove(path.size() - 1);
    }
}
