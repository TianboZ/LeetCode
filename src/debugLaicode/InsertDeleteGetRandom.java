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

    private Map<Integer, Integer> map;
    private List<Integer> list;
    private Random ran;

    /** Initialize your data structure here. */
    public InsertDeleteGetRandom() {
        map = new HashMap<>(); // key: num value: index
        list = new ArrayList<>();
        ran = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (!map.containsKey(val)) {
            int idx = list.size();
            map.put(val, idx);
            list.add(val);
            return true;
        } else {
            return false;
        }
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (map.containsKey(val)) {
            int idx = map.get(val);
            map.remove(val);

            if (idx != list.size() - 1) {
                int tail = list.get(list.size() - 1);
                list.set(idx, tail);
                map.put(tail, idx);
            }

            list.remove(list.size() - 1);
            return true;
        } else {
            return false;
        }
    }

    /** Get a random element from the set. */
    public int getRandom() {

        int i = ran.nextInt(list.size());
        return list.get(i);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
