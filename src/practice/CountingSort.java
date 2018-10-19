package practice;

public class CountingSort {
    public void sort(int[] arr, int lower, int upper) {
        // step1:
        int[] count = new int[upper - lower + 1];
        for (int x : arr) { // o(n)
            count[x - lower]++;
        }
        // step2:
        int index = 0;
        for (int i = 0; i < count.length; i++) {   // outter loop: o(range)
            while (count[i] > 0) { // total o(n)    there are total n numbers, so count[i]-- runs n times
                arr[index] = lower + i;
                index++;
                count[i]--;
            }
        }

        // space o(range)
        // time o(n + range)
    }

    public static void main(String[] args) {
        CountingSort countingSort = new CountingSort();
        int[] arr = {3, 8, 9, 1,4 ,3, 4, 4, 5, 6, 8, 9};
        countingSort.sort(arr, 1, 10);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}

// time o(range)
// space o(range)
