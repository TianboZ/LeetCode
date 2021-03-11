package debugLaicode;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public List<String> permutations(String set) {
        // Write your solution here.
        List<String> res = new ArrayList<>();
        if (set == null) {
            return res;
        }
        char[] arr = set.toCharArray();
        dfs(0, arr, res);
        return res;
    }
    private void dfs(int i, char[] arr, List<String> res) {
        // base-case
        if (i == arr.length) {
            res.add(new String(arr));
            return;
        }
        // recursive rule
        for (int j = i; i < arr.length; i++) {
            swap(i, j, arr);
            dfs(i + 1, arr, res);
            // remember to swap back when back track to the previous state
            swap(i, j, arr);
        }
    }
    public void swap( int i, int j, char[] arr) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Permutation sol = new Permutation();
        System.out.println(sol.permutations("abccd"));

    }
}
