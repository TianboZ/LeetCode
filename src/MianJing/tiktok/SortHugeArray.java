package MianJing.tiktok;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortHugeArray {
    public void sort(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();

        for (int i  : arr) {
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        }

        List<Integer> res = new ArrayList<>();

        for (int i = 0; i <= 9; i++) {
            if (freq.containsKey(i)) {
                for (int j = 0; j < freq.get(i); j++) {
                    res.add(i);
                }
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) {
        SortHugeArray sol = new SortHugeArray();
        int[] arr = {1,2,1,2,3,2,3,2,0,4,6,4,3,2,4,5,6,7,7,6,1};
        sol.sort(arr);
    }
}
