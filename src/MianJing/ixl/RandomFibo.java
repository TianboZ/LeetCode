package MianJing.ixl;

import java.util.*;


/**
 *
 * 0
 * 1
 * 1
 * 2
 * 3
 * ...
 *
 *
 */

public class RandomFibo {
    public int fibo(int n) {
        // sanity check
        if (n == 1) return -1;

        List<Integer> fibos = new ArrayList<>();

        fibos.add(0);
        fibos.add(1);
        while (fibos.get(fibos.size() - 1) < n) {
            int size = fibos.size();
            fibos.add(fibos.get(size - 1) + fibos.get(size - 2));
        }

        // remove last element that is larger than n
        fibos.remove(fibos.size() - 1);

        System.out.println(fibos);
        random(fibos);

        return -1;
    }
    private void random(List<Integer> fibos) {
        if (fibos.size() > 2) {
            // remove duplicate 1
            fibos.remove(1);
        }
        System.out.println(fibos);
        Random rand = new Random();
        System.out.println( fibos.get(rand.nextInt(fibos.size())));;
    }

    public static void main(String[] args) {
        RandomFibo sol = new RandomFibo();
        sol.fibo(15);
    }
}
