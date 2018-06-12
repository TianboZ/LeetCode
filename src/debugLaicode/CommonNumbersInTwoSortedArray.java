package debugLaicode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonNumbersInTwoSortedArray {
    // sol1: it is sorted, no matter if there is any duplicates
    public List<Integer> common(List<Integer> A, List<Integer> B) {
        int i = 0;
        int j = 0;
        List<Integer> res = new ArrayList<>();
        while (i < A.size() && j < B.size()) {
            if (A.get(i) == B.get(j)) {
                res.add(A.get(i));
                i++;
                j++;
            } else if (A.get(i) < B.get(j)) {
                i++;
            } else {
                j++;
            }
        }
        System.out.println("sol1: " + res);
        return res;
    }

    // sol2: no matter if it is sorted, it is used for duplicates, if no duplicates, use hashset
    public List<Integer> common1(List<Integer> A, List<Integer> B) {
        Map<Integer, Integer> mapA = count(A);
        Map<Integer, Integer> mapB = count(B);
        List<Integer> res = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : mapA.entrySet()) {
            Integer count = mapB.get(entry.getKey());
            if (count != null) {
                int appear = (Math.min(count, entry.getValue()));
                for (int i = 0; i < appear; i++) {
                    res.add(entry.getKey());
                }
            }
        }

        System.out.println(res);
        return res;

    }

    private Map<Integer, Integer> count(List<Integer> list) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer ele : list) {
            Integer count = map.get(ele);
            if (count == null) {
                map.put(ele, 1);
            } else {
                map.put(ele, count + 1);
            }
        }
        System.out.println(map);
        return  map;
    }

    public static void main(String[] args) {
        CommonNumbersInTwoSortedArray commonNumbersInTwoSortedArray = new CommonNumbersInTwoSortedArray();
        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(1);
        a.add(1);
        a.add(1);

        List<Integer> b = new ArrayList<>();
        b.add(1);
        b.add(1);
        b.add(1);
        b.add(1);

        commonNumbersInTwoSortedArray.common1(a, b);
        commonNumbersInTwoSortedArray.common(a, b);
    }
}
