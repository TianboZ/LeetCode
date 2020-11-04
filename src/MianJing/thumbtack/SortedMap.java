package MianJing.thumbtack;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class SortedMap {
    Map<Character,Integer> map;
    TreeSet<Character> set;

    SortedMap() {
        this.map = new HashMap<>();
        this.set = new TreeSet<>();
    }

    // time O(logn)
    public void insert(Character key, Integer value) {
            map.put(key, value);
            set.add(key);
    }

    // time O(logn + n)
    public void print() {
        for (Character c : set) {
            System.out.println("key: " + c +  " value: " + map.get(c));
        }
    }

}
