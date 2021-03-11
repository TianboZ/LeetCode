package debugLaicode;

import java.util.*;

public class TopKFrenquentWords {
    public String[] topKFrequent(String[] combo, int k) {

        Map<String, Integer> map = new HashMap<>(); // key: word  value: frequency

        // count frequency
        for (String str : combo) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        Queue<String> pq = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (map.get(o1) == map.get(o2)) return 0;
                return map.get(o1) < map.get(o2) ? -1 : 1;
            }
        });  // min heap

        for (String str : map.keySet()) {
            if (pq.size() < k) {
                pq.offer(str);
            } else {
                if (map.get(str) > map.get(pq.peek())) {
                    pq.poll();
                    pq.offer(str);
                }
            }
        }

        String[] res = new String[pq.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = pq.poll();
        }
        return res;
    }
}

