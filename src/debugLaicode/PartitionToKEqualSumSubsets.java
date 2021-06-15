package debugLaicode;

import java.util.*;

public class PartitionToKEqualSumSubsets {
    List<List<Integer>> path = new ArrayList<>();
    int sum;
    boolean found;

    public boolean canPartitionKSubsets(int[] nums, int k) {
        for (int n : nums) sum += n;
        sum = sum / k;

        for (int i = 0; i < k; i++) {
            path.add(new ArrayList<>());
        }

        dfs(nums, 0);
        return found;
    }

    private void dfs(int[] arr, int i) {
        // base case
        if (found) return;
        if (i == arr.length) {
            for (List<Integer> list : path) {
                int tmp = 0;
                for (Integer n : list) tmp += n;
                if (tmp != sum) return;
            }
            found = true;
            System.out.println("a");
            return;
        }

        // recursive rule
        int n = arr[i];
        for (int j = 0; j < path.size(); j++) {
            List<Integer> list = path.get(j);
            int sum1 = 0;
            for (Integer x : list) sum1 += x;
            if (sum1 + n > sum) return;

            System.out.println(list);
            list.add(n);
            dfs(arr, i + 1);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        PartitionToKEqualSumSubsets sol = new PartitionToKEqualSumSubsets();
        int[] arr = {1,2,3,4,5,6};

        boolean res  = sol.canPartitionKSubsets(arr, 6);
        System.out.println(res);
    }
}
