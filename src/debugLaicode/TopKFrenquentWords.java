package debugLaicode;

import java.util.*;

public class TopKFrenquentWords {
    public String[] topKFrequent(String[] combo, int k) {
        // use online algorithm
        if (combo == null || combo.length == 0) {
            return new String[0];
        }
        Map<String, Integer> map = new HashMap<>();

        for (String s : combo) {
            Integer count = map.get(s);
            if (count == null) {
                map.put(s, 1);
            } else {
                map.put(s, count + 1);
            }
        }

        Queue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(11, new MyComparator());

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            // step1: add k candidates
            if (minHeap.size() < k) {
                minHeap.offer(entry);
            }
            // step2: if new element smaller than peek in the heap,
            // then ignore it; otherwise, poll peek, offer new element
            else {
                if (entry.getValue() < minHeap.peek().getValue()) {
                    continue;
                } else {
                    minHeap.poll();
                    minHeap.offer(entry);
                }
            }
        }

        String[] arr = new String[minHeap.size()];
        for (int i = minHeap.size() - 1; i >= 0; i--) {
            arr[i] = minHeap.poll().getKey();
        }

        return arr;
    }

    class MyComparator implements Comparator<Map.Entry<String, Integer>> {
        @Override
        public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
            if (e1.getValue() == e2.getValue()) {
                return 0;
            }
            return e1.getValue() < e2.getValue() ? -1 : 1;
        }
    }
}

