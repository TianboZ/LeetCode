package debugLaicode;
import java.util.*;

public class JumpGame3 {
    Set<Integer> visit = new HashSet<>();

    public boolean canReach(int[] arr, int start) {
        return dfs(start, arr);
    }

    private boolean dfs(int i, int[] arr) {
        // base case
        if (visit.contains(i)) return false;
        if (arr[i] == 0) return true;

        // recursive rule
        visit.add(i);
        int j = i + arr[i];
        if (j >= 0 && j < arr.length) {
            if ( dfs(j, arr)) return true;
        }

        j = i - arr[i];
        if (j >= 0 && j < arr.length) {
            if ( dfs(j, arr)) return true;
        }

        return false;
    }
}
