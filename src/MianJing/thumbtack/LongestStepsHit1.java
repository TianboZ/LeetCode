package MianJing.thumbtack;


import java.util.*;

public class LongestStepsHit1 {
    public static void main(String args[]) {
        System.out.println(findLongestSteps(300)); // recursion
        //System.out.println(findLongesetSteps3(100000));
        System.out.println(longest(300)); // naive
    }

    private static int findLongesetSteps3(int limit) {
        int max = 0;
        int num = 0;
        int result = 0;
        int chainSize = 0;

        for (int i = 2; i < limit; i++) {
            chainSize = 0;
            num = i;
            while (num != 1) {
                if (num % 2 == 0) {
                    num = num / 2;
                } else {
                    num = 3 * num + 1;
                }
                chainSize++;
            }
            if (chainSize > max) {
                max = chainSize;
                result = i;
            }
        }
        System.out.println("number: " + result + " length: " + max);
        System.out.println();
        return max;

    }

    // naive, iterative
    private static int longest(int limit) {
        if (limit == 1) return 1;
        int max = 0;
        for (int i = 2; i <= limit; i++) {
            int count = 1;
            int num = i;
            while (num != 1) {
                count++;
                if (num % 2 == 0) {
                    num = num / 2;
                } else {
                    num = num * 3 + 1;
                }
            }
            //System.out.println("a");
            max = Math.max(max, count);
        }
        return max;
    }


    // recursion + memo solution
    private static int findLongestSteps(int limit) {
        if (limit < 1) {
            return 0;
        }
        Map<Integer, Integer> memo = new HashMap<>(); // memo
        int longest = 0;
        for (int i = 1; i <= limit; i++) {
            longest = Math.max(longest, findSteps(i, memo));
        }
        return longest;
    }
    private static int findSteps(int num, Map<Integer, Integer> memo) {
        if (num <= 1) {
            return 1;
        }
        if (memo.containsKey(num)) {
            return memo.get(num);
        }
        int result = 0;
        if (num % 2 == 0) {
            result = findSteps(num / 2, memo) + 1;
        } else {
            result = findSteps(3 * num + 1, memo) + 1;
        }
        memo.put(num, result);
        return result;
    }
}