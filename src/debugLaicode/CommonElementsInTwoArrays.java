package debugLaicode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonElementsInTwoArrays {
    public  static void main(String[] args) {
        CommonElementsInTwoArrays commonElementsInTwoArrays = new CommonElementsInTwoArrays();
        List<Integer> lis11 = new ArrayList<>();
        List<Integer> lis12 = new ArrayList<>();
        lis11.add(1);
        lis11.add(1);
        lis11.add(2);
        lis11.add(3);
        lis11.add(3);

        lis12.add(2);
        lis12.add(2);
        lis12.add(2);
        lis12.add(1);
        lis12.add(1);
        lis12.add(4);
        lis12.add(5);
        lis12.add(6);
        lis12.add(7);
        lis12.add(3);

        commonElementsInTwoArrays.common(lis11,lis12);

    }
    public List<Integer> common(List<Integer> A, List<Integer> B) {
        /*// Write your solution here.

        // solution1: two pointers

        // use HashMap
        Map<Integer, Integer> mapA = new HashMap<>();
        for (Integer i : A) {
            if (!mapA.containsKey(i)) {
                mapA.put(i, 1);
            } else {
                mapA.put(i, mapA.get(i) + 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : mapA.entrySet()) {
            System.out.println(entry);
        }


        Map<Integer, Integer> mapB = new HashMap<>();
        for (Integer i : B) {
            if (!mapB.containsKey(i)) {
                mapB.put(i, 1);
            } else {
                mapB.put(i, mapB.get(i) + 1);
            }
        }

        System.out.println();
        for (Map.Entry<Integer, Integer> entry : mapB.entrySet()) {
            System.out.println(entry);
        }

        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : mapA.entrySet()) {
            if (mapB.containsKey(entry.getKey())) {
                System.out.println("common: " + entry.getKey());
                int count = Math.min(mapB.get(entry.getKey()), entry.getValue());
                for (int i = 0; i < count; i++) {
                    result.add(entry.getKey());
                }
            }
        }*/
        //write your solution here
        Map<Integer, Integer> mapA = new HashMap<>();
        for (Integer i : A) {
            if (mapA.containsKey(i)) {
                mapA.put(i, mapA.get(i) + 1);
            } else {
                mapA.put(i, 1);
            }
        }
        Map<Integer, Integer> mapB = new HashMap<>();
        for (Integer i : B) {
            if (mapB.containsKey(i)) {
                mapB.put(i, mapB.get(i) + 1);
            } else {
                mapB.put(i, 1);
            }
        }
        System.out.println("a");
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> mapAentry : mapA.entrySet()) {
            System.out.println("ab");
            if (mapB.containsKey(mapAentry.getKey())) {
                int count = Math.min(mapAentry.getValue(), mapB.get(mapAentry.getKey()));
                int i = 1;
                while (i <= count) {
                    list.add(mapAentry.getKey());
                    i++;
                }

            }
            System.out.println("abc");
        }
        System.out.println(list);
        return list;
    }


}
