package debugLaicode;

import java.util.*;

public class InsertDeleteGetRandom2 {
    Map<Integer, Set<Integer>> map; // key: element  value: set of index it appears in the ArrayList
    Random random;
    List<Integer> list;

    /** Initialize your data structure here. */
    public InsertDeleteGetRandom2() {
        map = new HashMap<>();
        random = new Random();
        list = new ArrayList<>();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean flag = false;
        Set<Integer> set = map.get(val);
        if (set == null) {
            set = new HashSet<>();
            map.put(val, set);
            flag = true;
        }
        int index = list.size();
        set.add(index);
        list.add(val);
        return flag;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (map.containsKey(val)) {
            int index = map.get(val).iterator().next();
            map.get(val).remove(index);
            if (map.get(val).size() == 0) map.remove(val);

            // swap the val to the tail of arraylist, then delete it
            if(index != list.size() - 1) {
                // not last one
                int lastone = list.get(list.size() - 1);
                list.set(index, lastone);
                map.get(lastone).remove(list.size() - 1);
                map.get(lastone).add(index);
            }

            list.remove(list.size() - 1);
            return true;
        }
        return false;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        // System.out.println(list.size());
        int index = random.nextInt(list.size());
        return list.get(index);
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */