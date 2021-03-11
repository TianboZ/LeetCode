package debugLaicode;

import java.lang.reflect.Array;
import java.util.*;

public class KeepDistanceForIdenticalElements {
    boolean isFound = false;
    int[] result;

    public int[] keepDistance(int k) {
        // Write your solution here.
        int[] arr = new int[2 * k];
        for (int i = 0; i < k; i++) {
            arr[i * 2] = i + 1;
            arr[i * 2 + 1] = i + 1;

        }
        Set<Integer> set = new HashSet<>();

        dfs(arr, 0, set);
        return isFound ? arr : null;
    }

    private void dfs(int[] arr, int index, Set<Integer> set) {
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
        for (int i = index; i < arr.length; i++) {
            swap(arr, index, i);
            int distance = arr[index];
            boolean used = set.contains(distance);
            if (!used) {
                set.add(distance);
            }
            if (!used || index - distance - 1 >= 0 && arr[index - distance - 1] == arr[index]) {
                dfs(arr, index + 1, set);
            }
            swap(arr, index, i);
            if (!used) {
                set.remove(distance);
            }
        }
    }
    private void swap(int[] arr, int i, int j) {
        int tmpt = arr[i];
        arr[i] = arr[j];
        arr[j] = tmpt;
    }
    private boolean checkContains(int[] arr, int k, int j, int t) {
        if (j < 0) return false;
        for (int i = 0; i <= j; i++) {
            if (arr[i] == t) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        KeepDistanceForIdenticalElements sol = new KeepDistanceForIdenticalElements();
//        int[] res = sol.keepDistance(3);
//        System.out.println(res);
        System.out.println(Integer.parseInt("00023"));
    }
}
