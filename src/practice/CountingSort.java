package practice;

public class CountingSort {
    public void sort(int[] arr, int min, int max) {
        // step1:
        int[] count = new int[max - min + 1];
        for (int x : arr) { // o(n)
            count[x - min]++;
        }
        // step2:
        int index = 0;
        for (int i = 0; i < count.length; i++) {   // outter loop: o(range)
            while (count[i] > 0) { // total o(n)    there are total n numbers, so count[i]-- runs n times
                arr[index] = min + i;
                index++;
                count[i]--;
            }
        }

        // space o(range)
        // time o(n + range)
    }
}
