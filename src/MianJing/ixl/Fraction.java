package MianJing.ixl;

import java.util.*;

public class Fraction {
    public void fraction3(int a, int b) {
        //a = 1;
        int aa = Math.abs(1);
        int bb = Math.abs(b);

        int rem = 1 % bb; // reminder
        StringBuilder sb = new StringBuilder();
        Set<Integer> set = new HashSet<>();

        while (rem != 0) {
            rem = rem * 10;
            int quotient = rem / bb;
            rem = rem % bb;

            if (set.contains(rem)) {
                // seen duplicate, end loop
                break;
            } else {
                set.add(rem);
                sb.append(quotient);
            }
        }

        System.out.println(sb.toString());
    }

    // follow up
    public void fraction4(int a, int b) {
        // sanity check
        // todo


        int aa = Math.abs(a);
        int bb = Math.abs(b);

        StringBuilder sb = new StringBuilder();
        int rem = aa % bb;


        if (rem == 0) {
            sb.append(a / b);
            System.out.println(sb.toString());
        } else {
            if (a / b < 0) {
                sb.append("-");
            }
            sb.append(aa / bb).append(".");
            Set<Integer> set = new HashSet<>();

            while (rem != 0) {
                rem = rem * 10;
                int quotient = rem / bb;
                rem = rem % bb;
                if (set.contains(rem)) {
                    break;
                } else {
                    sb.append(quotient);
                    set.add(rem);
                }
            }
            System.out.println(sb.toString());
        }
        return;
    }
    public String fractionToDecimal(int numerator, int denominator) {

        StringBuilder sb = new StringBuilder();

        if ((numerator > 0 && denominator <0 )  || (denominator > 0 && numerator < 0)) {
            sb.append("-");
        }

        long dividend = Math.abs((long)numerator);
        long divisor = Math.abs((long)denominator);
        long reminder = dividend % divisor;

        sb.append(dividend / divisor);

        if (reminder == 0) {
            return sb.toString();
        }

        sb.append(".");
        Map<Long, Integer> map = new HashMap<>();
        map.put(reminder, sb.length());

        while (reminder != 0) {
            reminder = 10 * reminder;
            sb.append(reminder / divisor);
            reminder = reminder % divisor;

            if (map.containsKey(reminder)) {
                int i = map.get(reminder);
                sb.insert(i, "(");
                sb.append(")");
                break;
            } else {
                map.put(reminder, sb.length());
            }
        }
        //System.out.println(map);
        System.out.println(sb.toString());
        return sb.toString();

    }

    public static void main(String[] args) {
        int a = 10;
        int b = -70;

        System.out.println((double) a /b);
        //System.out.println(1 % 3);

        Fraction sol = new Fraction();
        //sol.fraction3(a, b);
        sol.fraction4(a, b);
        sol.fractionToDecimal(a, b);
        //System.out.println();
    }
}
