package debugLaicode;

import java.util.*;

public class Test {
    static class MyComparator implements Comparator<Character> {
        @Override
        public int compare(Character c1, Character c2) {
            if (c1.equals(c2)) {
                return 0;
            }
            if (c1 >= '0' && c1 <= '9' && c2 >= '0' && c2 <= '9') {
                return c1 < c2 ? -1 : 1;
            } else if (c1 >= 'A' && c1 <= 'Z' && c2 >= 'A' && c2 <= 'Z') {
                return c1 < c2 ? -1 : 1;
            } else if (c1 >= '0' && c1 <= '9' && c2 >= 'A' && c2 <= 'Z'){
                return c1 < c2 ? -1 : 1;
            } else {
                return c1 < c2 ? 1 : -1;
            }
        }
    }

    public static void main(String[] args) {
        List<Character> list = new ArrayList<>();
        list.add('1');
        list.add('2');
        list.add('A');
        list.add('3');
        list.add('D');
        list.add('4');
        list.add('B');
        list.add('C');

        Collections.sort(list, new MyComparator());
        System.out.println(list);
    }
}
