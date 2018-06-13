package debugLaicode;

import java.util.ArrayList;
import java.util.List;

public class NQueen {
    public List<List<Integer>> nqueens(int n) {
        // Write your solution here.
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(res, list, n, 0);
        return res;
    }
    private void dfs(List<List<Integer>> res, List<Integer> list, int n, int index) {
        // base-case
        if (index == n) {
            res.add(new ArrayList<>(list));
            return;
        }
        // recursive rule
        for (int i = 0; i < n; i++) {
            // check if put new queen at column i at current row is valid
            if (isValid(list, i)) {
                list.add(i);
                dfs(res, list, n, index + 1);
                list.remove(list.size() - 1);
            }
        }
    }
    private boolean isValid(List<Integer> list, int col) {
        int row = list.size();
        for (int i = 0; i < row; i++) {
            if (col == list.get(i) || Math.abs(list.get(i) - col) == (row - i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        NQueen nQueen = new NQueen();
        List<List<Integer>> res = nQueen.nqueens(8);
        System.out.println(res);
    }
}
