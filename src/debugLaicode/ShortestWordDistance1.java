package debugLaicode;


/*
time   30: 40

solution:
i, j is two pointers to word1 or word2

linear scan from left to right, i represent the most recent word1's index, j ...

time O(n)
space O(1)

one pass




sol2:
two pointers, move smaller pointer

[1, 2, 4, 10]
 |

[0, 3, 5]
 |
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
                // update latest appearence of word1
                i = idx;
            }

            if(words[idx].equals(word2)) {
                // update latest appearence of word1
                j = idx;
            }

            if (i != -1 && j != -1) min = Math.min(min, Math.abs(i - j + 1));
        }
        return min;
    }
}

