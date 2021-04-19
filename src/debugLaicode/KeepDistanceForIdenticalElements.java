package debugLaicode;

import java.lang.reflect.Array;
import java.util.*;

public class KeepDistanceForIdenticalElements {
    boolean isFound = false;
    int[] result;
    int[] used;

    public int[] keepDistance(int k) {
        // Write your solution here.
        int[] arr = new int[2 * k];
        for (int i = 0; i < k; i++) {
            arr[i * 2] = i + 1;
            arr[i * 2 + 1] = i + 1;

        }

        used = new int[k + 1];  // used[i]  means  # of times that i is used before

        dfs(arr, 0, k);
        return isFound ? result : null;
    }

    private void dfs(int[] arr, int index, int k) {
        // base case
        if (isFound) {
            return;
        }
        if (index == arr.length) {
            isFound = true;
            result = Arrays.copyOf(arr, arr.length);
            return;
        }

        // recursive rule
        for (int n = 1; n <= k; n++) {
            if (used[n] == 0) {
                arr[index] = n;
                used[n] = 1;
                dfs(arr, index + 1, k);
                used[n] = 0;
            } else if(used[n] == 1) {
                if (index - n - 1 >= 0 && arr[index - n - 1] == n) {
                    used[n] = 2;
                    arr[index] = n;
                    dfs(arr, index + 1, k);
                    used[n] = 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        KeepDistanceForIdenticalElements sol = new KeepDistanceForIdenticalElements();
//        int[] res = sol.keepDistance(3);
//        System.out.println(res);
        System.out.println(Integer.parseInt("00023"));
    }
}
