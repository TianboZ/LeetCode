package practice;

import java.util.*;

public class ReviewSetAndMap {



    private static class Cell2 {
        int[] arr;
        int x;
        boolean y;

        Cell2(int _x, boolean _y) {
            x = _x;
            y = _y;
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Cell2 cell2 = (Cell2) o;
            return x == cell2.x &&
                    y == cell2.y &&
                    Arrays.equals(arr, cell2.arr);
        }

        @Override
        public int hashCode() {
            int result = Objects.hash(x, y);
            result = 31 * result + Arrays.hashCode(arr);
            return result;
        }
    }
    private static class Cell{
        int x;
        int y;

        Cell(int _x, int _y) {
            x = _x;
            y = _y;
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Cell cell = (Cell) o;
            return x == cell.x &&
                    y == cell.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
    private void hashMap() {
        String s = "abc";
        String s2 = "abcd";
        String s3 = "abcde";

        Map<String, Integer> map = new HashMap<>();
        map.put(s, 1);
        map.put(s2, 2);
        map.put(s3, 3);
        map.put(null, 0);

        Set<String> keys = map.keySet();
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        Collection<Integer> values = map.values();

        System.out.println(map);
        System.out.println(keys);
        System.out.println(entries);
        System.out.println(values);
        for (Integer i : values) {
            System.out.println(i);
        }
    }

    private void hashSet() {
        Set<Cell> set = new HashSet<>();
        Cell c1 = new Cell(1, 2);
        Cell c2 = new Cell(1, 2);
        Cell c3 = new Cell(2, 3);
        set.add(c1);
        set.add(c2);
        set.add(c3);

        System.out.println(c1.equals(c2)); // true
        System.out.println(set.size()); // 2
        System.out.println("-----------------------");

        Set<List<Integer>> set1 = new HashSet<>();
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1,2,3));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(4,5));
        List<Integer> list3 = new ArrayList<>(Arrays.asList(4,5));
        List<Integer> list4 = new ArrayList<>(Arrays.asList(5,4));

        System.out.println(list2.equals(list3));
        System.out.println(list2.hashCode());
        System.out.println(list3.hashCode());
        System.out.println(list4.hashCode());

        set1.add(list1);
        set1.add(list2);
        set1.add(list3);
        set1.add(list4);
        System.out.println(set1.size());

        System.out.println("-----------------------");

        List<Cell> list5  = new ArrayList<>();
        List<Cell> list6  = new ArrayList<>();
        List<Cell> list7  = new ArrayList<>();

        list5.add(c1);
        list6.add(c2);
        list7.add(c3);

        System.out.println(list5.hashCode());
        System.out.println(list6.hashCode());
        System.out.println(list7.hashCode());

        System.out.println(list5.equals(list6));


        System.out.println("-----------------------");
        Set<int[]> set2 = new HashSet<>();
        int[] arr1 = {1, 2,3};
        int[] arr2 = {1, 2,3};
        int[] arr3 = {1, 2};

        // https://stackoverflow.com/questions/51234678/java-setint-vs-setlistinteger
        // array1.equals() is doing a reference comparison.

        // compare two arrays content, use Arrays.equals(array1, array2)
        // but isn't possible when using a Set (which will automatically use array1.equals(array2)).
        System.out.println(arr1.equals(arr2)); // false
        System.out.println(arr1.hashCode());
        System.out.println(arr2.hashCode());
        System.out.println(arr3.hashCode());
    }



    public static void main(String[] args) {
        ReviewSetAndMap sol = new ReviewSetAndMap();
        // sol.hashMap();
        //sol.hashSet();

        Set<Integer> set = new HashSet<>();
        for (Integer i : set) {
            System.out.println('a');
            System.out.println(i);
        }
    }
}
