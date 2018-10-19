package MianJing.thumbtack;

import java.util.HashSet;
import java.util.Set;

public class ClosestPalindrome {

    public static void main(String[] args) {
        System.out.println(nearestPalindromic("0"));
        System.out.println(nearestPalindromic("1"));
        System.out.println(nearestPalindromic("6"));
        System.out.println(nearestPalindromic("9"));
        System.out.println(nearestPalindromic("10"));
        System.out.println(nearestPalindromic("11"));
        System.out.println(nearestPalindromic("12"));
        System.out.println(nearestPalindromic("71"));
        System.out.println(nearestPalindromic("74"));
        System.out.println(nearestPalindromic("79"));
        System.out.println(nearestPalindromic("99"));
        System.out.println(nearestPalindromic("100"));
        System.out.println(nearestPalindromic("101"));
        System.out.println(nearestPalindromic("999"));
        System.out.println(nearestPalindromic("1993"));
        System.out.println(nearestPalindromic( "1999"));
        System.out.println(nearestPalindromic("9900"));
        System.out.println(nearestPalindromic("999000"));
    }

    public static  String nearestPalindromic(String n) {
        // corner case
        if (n.equals("0")) return Integer.toString(1);

        Set<Integer> set = new HashSet<>(); // store all candidates palindrome integer

        int len = 0; // first half lenght
        if(n.length() % 2 == 0) {
            len = n.length() / 2;
        } else {
            len = n.length() / 2 + 1;
        }

        String s1 = n.substring(0, len); // first half
        int num1 = Integer.parseInt(s1); // first half value
        //System.out.println(num1);
        for (int i = -1; i <= 1; i++) {
            int newNum1 = num1 + i;
            //System.out.println(newNum1);
            String newS1 = Integer.toString(newNum1);
            String s2 = reverse(newS1); // second half
            if (n.length() % 2 == 0) {
                String str = newS1 + s2;
                set.add(Integer.parseInt(str));
            } else {
                String str = newS1.substring(0, newS1.length()-1) + s2;
                //System.out.println("new str:" + str);
                set.add(Integer.parseInt(str));
            }
        }

        set.remove(Integer.parseInt(n)); // remove the number itseft

        int res = 0;
        int num  = Integer.parseInt(n);
        // find the cloeset num in the set
        int diff = Integer.MAX_VALUE;
        for (Integer i : set) {
            if (Math.abs(i - num) < diff) {
                diff = Math.abs(i - num);
                res = i;
            }
        }
        //System.out.println(res);
        return Integer.toString(res);
    }
    private static String reverse(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }
}
