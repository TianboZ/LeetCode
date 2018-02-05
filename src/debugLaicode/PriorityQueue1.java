package debugLaicode;

import java.util.*;

public class PriorityQueue1 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        // use maxHeap. Put entry into maxHeap so we can always poll a number with largest frequency

        Map<Integer, Integer> map = new HashMap<>();
        for(int n: nums){
            if (map.containsKey(n)) {
                map.put(n,map.get(n) + 1);
            }
            else {
                map.put(n, 1);
            }
        }

        CP comprator = new CP();
        PriorityQueue<Map.Entry<Integer, Integer>> queue =
                new PriorityQueue<Map.Entry<Integer, Integer>>(10,comprator);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.offer(entry);
        }

        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < k; i++) {
            result.add(queue.poll().getKey());
        }
        return result;
    }
}

class CP implements Comparator<Map.Entry<Integer, Integer>> {
    public int compare(Map.Entry<Integer, Integer> entry1,
                       Map.Entry<Integer, Integer> entry2) {
        return entry2.getValue() - entry1.getValue(); // decreasing order
    }
}