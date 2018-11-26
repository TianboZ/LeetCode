package debugLaicode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/*

solution1；
just applay last question's solution, then for each query, time is O(n)
n is words.length
so it is not efficient


solution2:

pre-process the words
HashMap<key: word, value: list of index>

then for each query, we first get two words's list of index
we just neet to search these two list  of index, time is < O(n)

e.g.  word1: {0, 1, 4}
      word2: {2, 6, 10}

*/
public class ShortestWordDistance2 {
    Map<String, List<Integer>> map;
    public ShortestWordDistance2(String[] words) {
        this.map = new HashMap<>();
        int i = 0;
        for (String s : words) {
            List<Integer> list = map.get(s);
            if (list == null) {
                list = new ArrayList<>();
                map.put(s, list);
            }
            list.add(i);
            i++;
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);

        int i = 0;
        int j = 0;

        int min = Integer.MAX_VALUE;

        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) < list2.get(j)) {
                min = Math.min(min, list2.get(j) - list1.get(i));
                i++;
            } else {
                min = Math.min(min, list1.get(i) - list2.get(j));
                j++;
            }
        }
        return min;
    }
}
