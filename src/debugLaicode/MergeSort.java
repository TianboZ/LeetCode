package debugLaicode;

public class MergeSort {
    // 2021
    public int[] mergeSort2(int[] array) {
        // Write your solution here
        if (array == null || array.length == 0) return array;
        sort(array, 0, array.length - 1);
        return array;
    }
    private void sort(int[] arr, int lo, int hi) {
        if (lo >= hi) return;

        int mid = (lo + hi) / 2;
        sort(arr, lo, mid);
        sort(arr, mid + 1, hi);
        merge(arr, lo, mid, hi);
    }
    private void merge(int[] arr, int lo, int mid, int hi) {
        int h1 = lo;
        int h2 = mid + 1;

        int[] tmp = new int[arr.length];
        for (int i = lo; i <= hi; i++) {
            tmp[i] = arr[i];
        }

        int i = lo;
        while (h1 <= mid && h2 <= hi) {
            if (tmp[h1] <= tmp[h2]) {
                arr[i] = tmp[h1];
                h1++;
                i++;
            } else {
                arr[i] = tmp[h2];
                h2++;
                i++;
            }
        }

        // remaning
        while (h1 <= mid) {
            arr[i] = tmp[h1];
            h1++;
            i++;
        }
    }


    // 2020
    public void mergeSort(int[] arr) {
        // sanity check
        if (arr == null) {
            return;
        }

        int[] helper = new int[arr.length];

        mergeSort(arr, 0, arr.length - 1, helper);
    }

    // left is array left bound index, right is...
    public void mergeSort(int[] arr, int left, int right, int[] helper) {
        // basecase
        if (left >= right) {
            return;
        }

        // recursive rule
        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid, helper);
        mergeSort(arr, mid + 1, right, helper);
        combine(arr, left, mid, right, helper);
    }

    private void combine(int[] arr, int left, int mid, int right, int[] helper) {
        for (int i = left; i <= right; i++) {
            helper[i] = arr[i];
        }

        int l = left;
        int r = mid + 1;
        // 谁小移谁
        while (l <= mid && r <= right) {
            if (helper[l] <= helper[r]) {
                arr[left] = helper[l];
                l++;
            } else {
                arr[left] = helper[r];
                r++;
            }
            left++;
        }

        // remaining elements in helper arr
        if (l <= mid) {
            arr[left] = helper[l];
        }
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] arr = {1,3,4,5,-1,-6,100};
        mergeSort.mergeSort(arr);

        for (int e : arr) {
            System.out.println(e);
        }
    }

    // time o()
}
