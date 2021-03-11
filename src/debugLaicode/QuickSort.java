package debugLaicode;

public class QuickSort {
    public void quickSort(int[] arr) {
        // sanity check
        if (arr == null || arr.length == 0) return;

        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int left, int right) {
        // basecase
        if (left >= right) {
            return;
        }

        // recursive rule
        int pivotIdx = partition(arr, left, right);

        quickSort(arr, left, pivotIdx - 1);
        quickSort(arr, pivotIdx + 1, right);
    }

    private int partition(int[] arr, int left, int right) {
        int pivotIdx = left + (int) (Math.random() * (right - left + 1));
        int pivot = arr[pivotIdx];

        // two pointers
        int l = left;  //   [left, l): elements <= pivot
        int r = right - 1;  // (r, right - 1]: elements > pivot
        // swap pivot to last index
        swap(arr, pivotIdx, right);

        while (l <= r) {
            if (arr[l] <= pivot) {
                l++;
            } else if (arr[r]> pivot) {
                r--;
            } else {
                swap(arr, l, r);
                l++;
                r--;
            }
        }

        // swap back pivot
        swap(arr, l, right);

        return l;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] arr = {-1, 0, 1, 99, -8};
        //int[] arr = null;
        quickSort.quickSort(null);

        for (int e: arr) {
            System.out.println(e);
        }
    }
}
