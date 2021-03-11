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
    private void dfs(List<List<Integer>> res, List<Integer> list, int n, int i) {
        // base-case
        if (i == n) {
            res.add(new ArrayList<>(list));
            return;
        }
        // recursive rule
        for (int j = 0; j < n; j++) {
            // check if put new queen at column i at current row is valid
            if (isValid(list, i, j)) {
                list.add(j);
                dfs(res, list, n, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }
    private boolean isValid(List<Integer> list, int row, int col) {
        for (int i = 0; i < list.size(); i++) {
            int col1 = list.get(i);
            int row1 = i;

            if (col1 == col) return false;

            if (Math.abs(row - row1) == Math.abs(col - col1)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        NQueen nQueen = new NQueen();
        List<List<Integer>> res = nQueen.nqueens(8);
        System.out.println(res);
    }
}

// time o(n^n)
// space o(n)