package debugLaicode;

import java.util.HashSet;
import java.util.Set;

public class PlusOne {
    public int[] test(int[] digits) {
        System.out.println("sssss");

        int carries = 1;
        for(int i = digits.length-1; i>=0 && carries > 0; i--){  // fast break when carries equals zero
            int sum = digits[i] + carries;
            digits[i] = sum % 10;
            carries = sum / 10;
        }
        if(carries == 0)
            return digits;

        int[] rst = new int[digits.length+1];
        rst[0] = 1;
        for(int i=1; i< rst.length; i++){
            rst[i] = digits[i-1];
        }
        for (int i = 0; i < rst.length; i++) {
            System.out.println(rst[i]);
        }
        System.out.println("sssss");
        return rst;
    }
    public int[] test2(int[] digits) {
        long sum = 0;
        for (int i = digits.length - 1; i >=0; i--) {
            int j = digits.length - i - 1;
            long temp = (long)(Math.pow(10, j));
            System.out.println("temp = "+ temp);
            System.out.println("digit[i] = "+digits[i]);
            sum = sum + digits[i] * temp;
            System.out.println("sum = "+sum);
        }
        sum = sum + 1; // plus one
        String s = Long.toString(sum);
        System.out.println("s = "+s);

        //String reverse = new StringBuffer(s).reverse().toString();
        int[] res = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            int x = Character.getNumericValue(s.charAt(i));
            res[i] = x;
        }
        return res;
    }

}

class Solution {
    public String reverseVowels(String s) {
        if (s == null) {
            return s;
        }
        if (s.length() == 0) {
            return s;
        }
        int start = 0;
        int end = s.length() - 1;
        Set<Character> set = new HashSet<Character>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');

        char[] charArray = s.toCharArray();

        // 2 pointers
        while (start <= end) {
            System.out.println("1");
            while (start <= s.length()) {
                if (set.contains(charArray[start])) {
                    break;
                }
                start++;
            }

            while (end >= 0) {
                if (set.contains(charArray[end])) {
                    break;
                }
                end--;
            }

            if (start <= end) {
                // swap
                char c = charArray[start];
                charArray[start] = charArray[end];
                charArray[end] = c;
                start++;
                end--;
            }
        }
        String result = new String(charArray);
        return result;
    }
}
