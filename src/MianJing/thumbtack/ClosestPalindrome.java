package MianJing.thumbtack;

import java.util.HashSet;
import java.util.Set;

/*

case1: odd
e.g.980
case1.1 take first half: "98", get the reverse of "98", which is "89".
    connect "98" and "89" like "989". middle character is overlapped
case1.2 take first half: "97", get the reverse of "97", which is "79".
    connect "97" and "79" like "979". middle character is overlapped
case1.3 take first half: "99", get the reverse of "99", which is "99".
    connect "99" and "99" like "999". middle character is overlapped

case2: even
e.g. 9800
case2.1 take first half: "98", get the reverse of "98", which is "89".
    connect "98" and "89" like "9889"
case2.2 ...
case2.3 ...


solution:

get first half of string, convert it to integer, store it as num1

num = num - 1
num = num + 0
num = num + 1

for each cases, convert num to string, store it as left, then revese it, call it right
try all the possible way to concatenate left + right


time is constant

*/

public class ClosestPalindrome {
    public String nearestPalindromic(String n) {
        // corner cases:
        long x = Long.parseLong(n);
        if (x <= 10) {
            x--;
            return Long.toString(x);
        }
        if (x == 11) {
            x = 9;
            return Long.toString(x);
        }

        if (isPower10(x)) {
            x--;
            return Long.toString(x);
        }

        Set<Long> set = new HashSet<>();

        int len = 0; // first half lenght
        if(n.length() % 2 == 0) {
            len = n.length() / 2;
        } else {
            len = n.length() / 2 + 1;
        }

        String s1 = n.substring(0, len); // first half
        long num1 = Long.parseLong(s1); // first half value
        for (int i = -1; i <= 1; i++) {
            long num2 = num1 + i;
            String left = Long.toString(num2);
            String right = reverse(left); // second half

            // try all the possible concatenate way
            String str1 = left + right;
            String str2 =  left.substring(0, left.length()-1) + right;

            set.add(Long.parseLong(str1));
            set.add(Long.parseLong(str2));
        }

        set.remove(Long.parseLong(n)); // remove the number itseft

        long num  = Long.parseLong(n);
        long res = Integer.MAX_VALUE;
        long diff = Integer.MAX_VALUE;
        // find the cloeset num in the set
        for (Long i : set) {
            System.out.println(i);
            if (Math.abs(i - num) < diff) {
                diff = Math.abs(i - num);
                res = i;
            }
        }
        // check if there exist tie
        if (res > num && set.contains(num - (res - num))) {
            res = num - (res - num);
        }
        return Long.toString(res);
    }

    public  boolean isPower10(long x) {
        while (x > 9 && x % 10 == 0) {
            x /= 10;
        }
        return x == 1;
    }
    private  String reverse(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }
}