package debugLaicode;

public class MergeSort {
    public void mergeSort(int[] arr, int left, int right) {
        // base-case
        if (left >= right) {
            return;
        }
        // recursive rule
        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge1(arr, left, mid, right);
    }
    private void merge(int[] arr, int left, int mid, int right) {
        int[] tmp = new int[arr.length];
        for (int i = left; i <= right; i++) {
            tmp[i] = arr[i];
        }
        // 谁小移动谁
        int i = left;
        int j = mid + 1;
        int index = left;
        while (i <= mid && j <= right) {
            if (tmp[i] <= tmp[j]) {
                arr[index] = tmp[i];
                i++;
                index++;
            } else {
                arr[index] = tmp[j];
                j++;
                index++;
            }
        }
        // left part is remaining
        while (i <= mid) {
            arr[index] = tmp[i];
            i++;
            index++;
        }
    }

    private void merge1(int[] arr, int left, int mid, int right){
        int[] tmpt = new int[arr.length];
        for (int i = left; i<= right; i++) {
            tmpt[i] = arr[i];
        }

        // move the pointer with smaller value
        int l = left;
        int r = mid + 1;
        int i = left;
        while (l <= mid && r <= right) {
            if (tmpt[l] < tmpt[r]) {
                arr[i] = tmpt[l];
                i++;
                l++;
            } else {
                arr[i] = tmpt[r];
                i++;
                r++;
            }
        }
        // remaining
        while (l <= mid) {
            arr[i] = tmpt[l];
            i++;
            l++;
        }
        while (r <= right) {
            arr[i] = tmpt[r];
            i++;
            r++;
        }
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] arr = {1,3,4,5,-1,-6,100};
        mergeSort.mergeSort(arr, 0, arr.length - 1);

        for (int i : arr) {
            System.out.println(i);
        }
    }
}
