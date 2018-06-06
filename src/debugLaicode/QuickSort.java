package debugLaicode;

public class QuickSort {
    public void quickSort(int[] arr, int left, int right) {
        // base-case
        if (left >= right) {
            return;
        }

        // recursive rule
        int index = partition(arr, left, right);
        quickSort(arr, left, index - 1);
        quickSort(arr, index + 1, right);
    }

    private int partition(int[] arr, int left, int right) {
        int pivotIndex = findPivot(arr, left, right);
        int pivot = arr[pivotIndex];

        int i = left;
        int j = right - 1;

        swap(arr, pivotIndex, right);

        // two bars, three areas
        // [0, i) : < pivot value     (j, last]: >= pivot    [i, j]: unknown area
        while (i <= j) {
            if (arr[i] < pivot) {
                i++;
            } else if (arr[j] >= pivot) {
                j--;
            } else {
                swap(arr, i, j);
                i++;
                j--;
            }
        }

        // swap back
        swap(arr, right, i);

        return i;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private int findPivot(int[] arr, int left, int right) {
        return left + (int)(Math.random() * (right - left + 1));
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] arr = {-1, 0, 1, 99, -8};
        quickSort.quickSort(arr, 0, arr.length - 1);

        for (int i : arr) {
            System.out.println(i);
        }
    }
}
