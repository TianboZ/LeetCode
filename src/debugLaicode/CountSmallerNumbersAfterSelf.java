package debugLaicode;

import java.util.HashMap;
import java.util.Map;

public class CountSmallerNumbersAfterSelf {
    public int[] countArray(int[] array) {
        int[] old = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            old[i] = array[i];
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            map.put(array[i], 0);
        }
        mergeSort(0, array.length - 1, array, map);

        int[] res = new int[array.length];
        for (int i = 0; i < old.length; i++) {
            res[i] = map.get(old[i]);
        }
        return res;
    }
    private void mergeSort(int left, int right, int[] arr, Map<Integer, Integer> map) {
        // base-case
        if (left >= right) {
            return;
        }
        // recursive rule
        int mid = left + (right - left) / 2;
        mergeSort(left, mid, arr, map);
        mergeSort(mid + 1, right, arr, map);
        merge(left, mid, right, arr, map);
    }
    private void merge(int left, int mid, int right, int[] arr, Map<Integer, Integer> map)  {
        int[] tmpt = new int[arr.length];
        for (int i = left; i <= right; i++) {
            tmpt[i] = arr[i];
        }

        int l = left;
        int r = mid + 1;
        int i = left;

        while (l <= mid && r <= right) {
            if (tmpt[l] <= tmpt[r]) {
                arr[i] = tmpt[l];
                map.put(arr[i], map.get(arr[i]) + r - (mid + 1));
                l++;
                i++;
            } else {
                arr[i] = tmpt[r];
                r++;
                i++;
            }
        }
        while (l <= mid) {
            arr[i] = tmpt[l];
            map.put(arr[i], map.get(arr[i]) + r - (mid + 1));
            l++;
            i++;
        }
    }



    public static void main(String[] args) {
        CountSmallerNumbersAfterSelf countSmallerNumbersAfterSelf = new CountSmallerNumbersAfterSelf();
        countSmallerNumbersAfterSelf.countArray(new int[] {4, 1, 3, 2});
    }
}
