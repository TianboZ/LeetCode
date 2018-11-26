package debugLaicode;

import java.util.*;

/*

solutions:

insert element: if the element not exist before, append new element to the tail of ArrayList

remove element: first find its index in the ArrayList, then swap it to the tail, remove tail element of ArrayList
    use HashMap<key: element, value: index>

getRandom: generate a random number, use it as index, get the element in ArrayList

all operation, time O(1)

*/
public class InsertDeleteGetRandom {
    Map<Integer, Integer> map;
    Random random;
    List<Integer> list;
    /** Initialize your data structure here. */
    public InsertDeleteGetRandom() {
        map = new HashMap<>();
        random = new Random();
        list = new ArrayList<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        int index = list.size();
        if (!map.containsKey(val)) {
            map.put(val, index);
            list.add(val);
            return true;
        }
        return false;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (map.containsKey(val)) {
            int index = map.get(val);
            // to be deleted element is NOT the last one in the list, swap it to the tail
            if (index != list.size() - 1) {
                int lastone = list.get(list.size() - 1);
                map.put(lastone, index); // update lastone's index
                list.set(index, lastone);
            }
            map.remove(val);
            list.remove(list.size() - 1);
            return true;
        }
        return false;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int index = random.nextInt(list.size());
        return list.get(index);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
