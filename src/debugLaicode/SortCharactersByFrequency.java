package debugLaicode;

import java.util.*;

public class SortCharactersByFrequency {
    // sol1: use max heap
    public String frequencySort(String s) {
        // use maxHeap. Put entry into maxHeap so we can always poll a number with largest frequency
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < s.length(); i++){
            Integer count = map.get(s.charAt(i));
            if (count == null) {
                map.put(s.charAt(i), 1);
            } else {
                map.put(s.charAt(i),map.get(s.charAt(i)) + 1);
            }
        }

        Queue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(new CP());

        for(Map.Entry<Character,Integer> entry: map.entrySet()){
            maxHeap.add(entry);
        }

        StringBuilder sb = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            Map.Entry e = maxHeap.poll();
            for (int i = 0; i < (int)e.getValue(); i++) {
                sb.append(e.getKey());
            }
        }
        return sb.toString();
    }

    // sol2: just sort then Map.Entry
    public String frequencySort1(String s) {
        // use maxHeap. Put entry into maxHeap so we can always poll a number with largest frequency
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < s.length(); i++){
            Integer count = map.get(s.charAt(i));
            if (count == null) {
                map.put(s.charAt(i), 1);
            } else {
                map.put(s.charAt(i),map.get(s.charAt(i)) + 1);
            }
        }

        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new CP());

        StringBuilder sb = new StringBuilder();

        for (Map.Entry<Character, Integer> entry : list) {
            int count = entry.getValue();
            for (int i = 0; i < count; i++) {
                sb.append(entry.getKey());
            }
        }

        return sb.toString();
    }

    class CP implements Comparator<Map.Entry<Character, Integer>> {
        @Override
        public int compare(Map.Entry<Character, Integer> entry1, Map.Entry<Character, Integer> entry2) {
            if (entry1.getValue() == entry2.getValue()) return 0;
            // decrease order
            return entry1.getValue() < entry2.getValue() ? 1: -1;
        }
    }
}

// space O(n)
// time O(nlogn)

