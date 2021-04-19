package debugLaicode;

import java.util.*;


/*

solution:
steps:
1.for each word, find the words that it can change to
time O( k * 26) = O(k)    n = wordlist size   k is word length

2. start from begin word, run breadth first search, to find the shortest path to end word
time O(V + E) = O(n * k)

-----------
total time O(n*K)
total space O(n)

*/
public class WordLadder1 {
    // 2021
    Map<String, Set<String>> adjMap = new HashMap<>();
    Map<String, String> map = new HashMap<>();
    Set<String> words = new HashSet<>();

    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        wordList.add(beginWord);
        for (String s : wordList) words.add(s);
        Map<String, Set<String>> adjMap1  = adjMap;
        //System.out.println(adjMap1);

        return bfs(beginWord, endWord);
    }

    private int bfs(String begin, String end) {
        Set<String> visit = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        int level = 0;  // shortest distance
        boolean found = false;
        // initial
        q.offer(begin);
        visit.add(begin);

        // terminal
        loop:
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                // expand
                String curr = q.poll();

                // generate
                List<String> neis = findNeis(curr);
                for (String nei : neis) {
                    if (visit.add(nei)) {
                        q.offer(nei);

                        map.put(nei, curr);

                        if (nei.equals(end)) {
                            found = true;
                            level++; // found target at  level
                            break loop;
                        }
                    }
                }
            }
            level++;

        }
        // reconstruct shortest path
        if (found) {

            //System.out.println(end);
            String curr = end;
            while (!curr.equals(begin)) {
                curr = map.get(curr);
                //System.out.println(curr);
            }
        }
        if (found) return level + 1;
        return 0;
    }

    private List<String>  findNeis(String s) {
        List<String> neis = new ArrayList<>();

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            for (int j = 0; j < 26; j++) {
                char newC = (char)('a' + j);
                if (newC != c) {
                    chars[i] = newC;
                    String tmp = new String(chars);
                    if (words.contains(tmp)) {
                        neis.add(tmp);
                    }
                    chars[i] = c;
                }
            }
        }
        return neis;
    }


    // 2020
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // Write your solution here
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        Set<String> words = new HashSet<>(wordList);

        int level = 0;

        // initial
        q.offer(beginWord);
        visited.add(beginWord);

        // terminate
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                // expand
                String curr = q.poll();
                if (curr.equals(endWord)) return level;

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
        return 0;
    }

//    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//        Set<String> set = new HashSet<>(wordList);
//        return bfs(beginWord, endWord, set);
//    }
//    // run BFS algorithm, to find the shortest path from begin word to end word
//    private int bfs(String beginWord, String endWord, Set<String> set) {
//        Queue<String> q = new LinkedList<>();
//        Set<String> visited = new HashSet<>();
//        int level = 0;
//        q.offer(beginWord);
//        visited.add(beginWord);
//
//        while (!q.isEmpty()) {
//            int size = q.size();
//            for (int k = 0; k < size; k++){
//                // expand
//                String curr = q.poll();
//                if (curr.equals(endWord)) return level + 1;
//
//                // generate
//                char[] arr = curr.toCharArray();
//                for (int i = 0; i < arr.length; i++) {
//                    char c = arr[i];
//                    for (int j = 0; j < 26; j++) {
//                        arr[i] = (char)('a'+j);
//                        String next = new String(arr);
//                        if (set.contains(next)) {
//                            if (!visited.contains(next)) {
//                                visited.add(next);
//                                q.offer(next);
//                            }
//                        }
//                    }
//                    arr[i] = c;
//                }
//            }
//            level++;
//        }
//        return 0;
//
//    }

    public static void main(String[] args) {
        char c = 'z';
        System.out.println((char)(c + 26));
        //WordLadder1 sol = new WordLadder1();
        //System.out.println(sol.ladderLength("git", "hot", Arrays.asList("git","hit","hog","hot")));
    }
}