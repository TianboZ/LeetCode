package debugLaicode;

import java.util.Arrays;
import java.util.Comparator;

public class a1b2c3d4abcd1234 {
    public void sort(String s) {
        Character[] arr = new Character[s.length()];
        for (int i = 0; i < s.length(); i++) {
            arr[i] = s.charAt(i);
        }
        Arrays.sort(arr, new MyComparator());
        for (Character c : arr) {
            System.out.println(c);
        }
    }
    class MyComparator implements Comparator<Character> {
        @Override
        public int compare(Character c1, Character c2) {
            if (Character.isAlphabetic(c1) && Character.isAlphabetic(c2)) {
                // both character
                return c1 < c2 ? -1 : 1;
            } else if (Character.isAlphabetic(c1) && Character.isDigit(c2)) {
                return -1;
            } else if (Character.isDigit(c1) && Character.isDigit(c2)) {
                // both digit
                return c1 < c2 ? -1 : 1;
            } else if (Character.isDigit(c1) && Character.isAlphabetic(c2)) {
                return 1;
            }
            return 0;
        }
    }

    public static void main(String[] args) {
        a1b2c3d4abcd1234 a1b2c3d4abcd1234 = new a1b2c3d4abcd1234();
        a1b2c3d4abcd1234.sort("d4b2c3a1");
    }
}
