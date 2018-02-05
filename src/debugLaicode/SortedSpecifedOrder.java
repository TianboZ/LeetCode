package debugLaicode;


import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class SortedSpecifedOrder {
    public static void main(String[] args) {
        SortedSpecifedOrder sortedSpecifedOrder = new SortedSpecifedOrder();
        int[] A1 = {2, 1, 2, 5, 7, 1, 9, 3};
        int[] A2 = {2, 1, 3};
        sortedSpecifedOrder.sortSpecial(A1, A2);
    }
    public int[] sortSpecial(int[] A1, int[] A2) {
        // Write your solution here.

        Integer[] arr = toIntegerArray(A1);
        CP cp = new CP(A2);
        Arrays.sort(arr, cp);
        int[] res = toIntArray(arr);


        return res;
    }
    class CP implements Comparator<Integer> {
        Map<Integer, Integer> map;
        public CP (int[] arr) {
            map = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                map.put(arr[i], i);
            }
        }
        @Override
        public int compare(Integer i1, Integer i2) {
            if (map.containsKey(i1) && map.containsKey(i2)) {
                return map.get(i1) - map.get(i2);
            } else if (map.containsKey(i1) || map.containsKey(i2)) {
                return map.containsKey(i1) ? -1 : 1;
            } else {
                return i1 - i2;
            }
        }
    }
    public int[] toIntArray(Integer[] arr) {
        int[] array = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            array[i] = arr[i];
        }
        return array;
    }
    public Integer[] toIntegerArray(int[] arr) {
        Integer[] array = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            array[i] = arr[i];
        }
        return array;
    }
}
