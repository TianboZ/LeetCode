package debugLaicode;


/*
time   30: 40

solution:
i, j is two pointers to word1 or word2

for each word index pair <i, j>  (i < j)
try to find the latest index i

2 cases:
j can be word1 or word2
if j is word2, find the latest word1's index i
if j is word2 ....  similar

time O(n)
space O(1)

one pass

*/

import java.util.Iterator;
import java.util.TreeMap;

public class ShortestWordDistance1 {
    public int shortestDistance(String[] words, String word1, String word2) {
        int i = -1; // word1
        int j = -1; // word2
        int min = Integer.MAX_VALUE;

        for (int idx = 0; idx < words.length; idx++) {
            if(words[idx].equals(word1)) {
                if (j != -1) {
                    min = Math.min(min, idx - j);
                }

                // update latest appearence of word1
                i = idx;
            }

            if(words[idx].equals(word2)) {
                if (i != -1) {
                    min = Math.min(min, idx - i);
                }

                // update latest appearence of word1
                j = idx;
            }
        }
        return min;
    }
}

