package debugLaicode;

import java.util.*;

public class Factors {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //factorCombo ref = new factorCombo();
        //System.out.println(ref.factorcombo(12));
        Factors factors= new Factors();
        /*int arr[] = factors.getFactor(12);
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        factors.dfs(res, list, arr, 12, 0);
        System.out.println(res);*/

        factors.factors(32);

    }

    public int[] getFactor(int target) {//[2,3,4,6]
        List<Integer> arr = new ArrayList<>();
        for (int i = 2; i < target; i++) {
            if (target % i == 0) {
                arr.add(i);
                //arr.add(target / i);//duplicated
            }
        }
        int[] res = new int[arr.size()];
        int index = res.length - 1;
        for (int i : arr) {
            res[index--] = i;
        }
        for (int i : res) {
            System.out.println(i);
        }
        return res;
    }

    public void dfs(List<List<Integer>> res, List<Integer> cur, int[] arr, int target, int level) {
        // base case
        if (level == arr.length) {
            if (target == 1) {
                res.add(new ArrayList<>(cur));
                System.out.println(cur);
                System.out.println("fffffffffffffffffffffffffffff");
            }
            return;
        }

        // recursive rule
        System.out.println("target: ");
        System.out.println(target);
        int factor = arr[level];
        int max = target / factor;

        for (int i = 0; i  <= max; i++) {
            cur.add(i);
            int tmp = i * factor;
            if (tmp == 0) {
                tmp = 1;
            }
            System.out.println("tmp: " + tmp);
            if (target % tmp == 0) {
                dfs(res, cur, arr, target / tmp, level + 1);
            }
            cur.remove(cur.size() - 1);
        }
    }

    /////
    public Set<List<Integer>> factors(int n) {
        // Write your solution here
        Set<Integer> set = helper(n);
        List<Integer> factors = new ArrayList<>(set);
        System.out.println(factors);
        Set<List<Integer>> res = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        factors(n, factors, res, list);
        System.out.println(res);
        return res;
    }
    public void factors(int n, List<Integer> factors, Set<List<Integer>> res, List<Integer> list) {
        // base-case
        if (n == 1) {
            List<Integer> copy = new ArrayList<>(list);
            Collections.sort(copy);
            res.add(copy);
            return;
        }
        // recursive rule
        for (int i = 0; i < factors.size(); i++) {
            if (n % factors.get(i) == 0) {
                int tmp = factors.get(i);
                list.add(tmp);
                factors(n / tmp, factors, res, list);
                list.remove(list.size() - 1);
            }
        }
    }
    public Set<Integer> helper(int n) {
        Set<Integer> set = new HashSet<>();
        for (int i = 2; i <= n; i++) {
            if (n % i == 0) {
                set.add(i);
            }
        }

        return set;
    }
}
