package MianJing.thumbtack;

import java.util.HashSet;
import java.util.Set;

public class AmicablePair {
    // pairs of amicable numbers
    private static int sumOfFactors(int n) {
        int sum = 0;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            // if 'i' is divisor of 'n'
            if (n % i == 0) {
                // if both divisors are same then add it once else add both
                if (i == (n / i)) {
                    sum += i;
                } else {
                    sum += (i + n / i);
                }
            }
        }
        return sum + 1;
    }

    public static int findPairs(int[ ] arr) {
        Set<Integer> set = new HashSet<>(); // store all numbers
        for (int i : arr) {
            set.add(i);
        }
        int count = 0;
        for (int i : arr) {
            if (set.contains(sumOfFactors(i))) {
                int sum = sumOfFactors(i);
                if (set.contains(sumOfFactors(sum))) count++;
            }
        }
        return count/ 2;
    }

    // time o(n^1.5)
    public static void main(String[] args) {
        //sumOfFactors(284);
        int[] arr = {2620, 2924, 5020, 5564, 6232, 6368 };
        int[] arr1 = {220, 284, 1184, 1210, 2, 5};
        int res = findPairs(arr);
        System.out.println(res);
    }
}
