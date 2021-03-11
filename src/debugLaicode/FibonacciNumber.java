package debugLaicode;

import java.util.HashMap;
import java.util.Map;


public class FibonacciNumber {
    /*
     *
     * solution: recursion + memo
     *
     * time O(n)
     * space O(n)
     *
     * n is the number of fibonacci number
     * */


    // return K-th fibo number, start from index 0
    public long fibo(int K) {
        // Write your solution here
        Map<Integer, Long> cache = new HashMap<>();
        return fibo(K, cache);
    }

    // pure recursion
    /*
    * time o(2^n)
    * space (n)
    *
    * will timeout
    * */
    public static long fibo1(int K) {
        // basecase
        if (K <= 0) return 0;
        if (K == 1) return 1;

        // recursive rule
        return fibo1(K - 1) + fibo1(K - 2);
    }

    private long fibo(int K, Map<Integer, Long> cache) {
        if (K <= 0) {
            return 0;
        }
        if (K == 1) {
            return 1;
        }

        if (cache.containsKey(K)) return cache.get(K);

        long res = fibo(K - 1, cache) + fibo(K - 2, cache);
        cache.put(K, res);
        return res;
    }

    public static void main(String[] args) {
        long res = fibo1(-30);

        System.out.println(res);
    }

}
