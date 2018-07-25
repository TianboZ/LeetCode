package debugLaicode;

public class GetCountArray {
    public int[] countArray(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }
        Cell[] cells = new Cell[array.length];

        // initial
        for (int i = 0; i < array.length; i++) {
            cells[i] = new Cell(array[i], 0);
        }

        Cell[] helper = new Cell[cells.length];
        mergeSort(cells, 0, cells.length - 1, helper);
        int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = cells[array.length - array[i]].count;
        }
        for (int i : result) {
            System.out.println(i);
        }
        return result;
    }

    private void mergeSort(Cell[] cells, int left, int right, Cell[] helper) {
        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;
        mergeSort(cells, left, mid, helper);
        mergeSort(cells, mid + 1, right, helper);
        merge(cells, left, mid, right, helper);
    }
    private void merge(Cell[] cells, int left, int mid, int right, Cell[] helper) {
        // copy array
        for (int i = left; i <= right; i++) {
            helper[i] = cells[i];
        }
        int l = left;
        int r = mid + 1;
        while (l <= mid && r <= right) {
            if (helper[l].value < helper[r].value) {
                cells[left++] = helper[r++];
            } else {
                helper[l].count += (right - r + 1);
                cells[left++] = helper[l++];
            }
        }
        while (l <= mid) {
            cells[left++] = helper[l++];
        }
    }

    //create value-count pair
    private class Cell {
        int value;
        int count; // number of smaller values in the right
        public Cell(int value, int count) {
            this.value = value;
            this.count = count;
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 1, 3, 2};
        GetCountArray getCountArray = new GetCountArray();
        getCountArray.countArray(arr);
    }
}