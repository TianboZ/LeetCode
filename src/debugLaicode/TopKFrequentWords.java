package debugLaicode;

import java.util.*;

public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> freq = new HashMap<>(); // key: word. value: frequency
        for (String w: words) {
            freq.put(w, freq.getOrDefault(w, 0) + 1);
        }

        Queue<String> pq = new PriorityQueue<>((one, two) -> {
            if (freq.get(one) == freq.get(two)) {
                return two.compareTo(one); // sort by letter , decreasing order
            }
            return freq.get(one) - freq.get(two);
        }); // min heap,  1. sort by freq, 2. sort by letter


        for (String s: freq.keySet()) {
            pq.offer(s);
            if (pq.size() > k) pq.poll();
        }

        // get result
        List<String> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            res.add(pq.poll());
        }
        Collections.reverse(res);
        return res;
    }
}

