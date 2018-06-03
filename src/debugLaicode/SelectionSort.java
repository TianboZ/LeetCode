package debugLaicode;

public class SelectionSort {
    public void selectionSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        for (int i = 0; i < arr.length - 1; i++) {
            int min = arr[i];
            int index = i;

            // find the min in the rest of array
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    index = j;
                }
            }

            // swap to current index
            swap(arr, index, i);
        }

        for (int i : arr) {
            System.out.println(i);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();

        int[] arr = {1, 2, 0, -1, 10, 5};

        selectionSort.selectionSort(arr);
    }
}

