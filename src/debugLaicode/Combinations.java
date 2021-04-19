package debugLaicode;


import java.util.ArrayList;
import java.util.List;

public class Combinations {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        dfs(arr, 0, k);
        return res;
    }

    private void dfs(int[] arr, int i, int k) {
        // base case
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (i == arr.length) {
            if (path.size() == k) {
                res.add(new ArrayList<>(path));
            }
            return;
        }
        // recursive rule
        path.add(arr[i]);
        dfs(arr, i + 1, k);
        path.remove(path.size() - 1);

        dfs(arr, i + 1, k);

    }
}



// time o(branch ^ level)   branch  = 2, level = k
// space o(max(k, n))