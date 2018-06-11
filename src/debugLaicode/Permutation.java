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
    private void dfs(int index, char[] arr, List<String> res) {
        // base-case
        if (index == arr.length) {
            res.add(new String(arr));
            return;
        }
        // recursive rule
        for (int i = index; i < arr.length; i++) {
            swap(i, index, arr);
            dfs(index + 1, arr, res);
            // remember to swap back when back track to the previous state
            swap(i, index, arr);
        }
    }
    public void swap( int i, int j, char[] arr) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Permutation permutation = new Permutation();
        System.out.println(permutation.permutations("abcd"));

    }
}
