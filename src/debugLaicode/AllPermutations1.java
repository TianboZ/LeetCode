package debugLaicode;

import java.util.ArrayList;
import java.util.List;

public class AllPermutations1 {
    public List<String> permutations(String input) {
        // Write your solution here
        // sanity check
        char[] arr = input.toCharArray();
        List<String> res = new ArrayList<>();
        dfs(0, arr, res);
        return res;
    }
    private void dfs(int index, char[] arr, List<String> res) {
        // basecase
        if (index == arr.length) {
            res.add(new String(arr));
            return;
        }
        // recurive rule
        for (int i = index; i < arr.length; i++) {
            swap(arr, i, index);
            dfs(index + 1, arr, res);
            swap(arr, i, index);
        }

    }

    private void swap(char[] arr, int i, int j) {
        char tmpt = arr[i];
        arr[i] = arr[j];
        arr[j] = tmpt;
    }

    public static void main(String[] args) {
        AllPermutations1 allPermutations1 = new AllPermutations1();
        System.out.println(
                allPermutations1.permutations("abc")
        );
    }
}
