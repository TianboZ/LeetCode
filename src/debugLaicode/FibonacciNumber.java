package debugLaicode;

import java.util.HashMap;
import java.util.Map;


/*
*
* solution: recursion + memo
*
* time O(n)
* space O(n)
*
* n is the number of fibonacci number
* */
public class FibonacciNumber {
    // return K-th fibo number, start from index 0
    public long fibonacci(int K) {
        // Write your solution here
        Map<Integer, Long> cache = new HashMap<>();
        return fibo(K, cache);
    }
    private long fibo(int K, Map<Integer, Long> cache) {
        if (K <= 0) return 0;
        if (K == 1) return 1;
        if (cache.containsKey(K)) return cache.get(K);

        long res = fibo(K - 1, cache) + fibo(K - 2, cache);
        cache.put(K, res);
        return res;
    }

}
