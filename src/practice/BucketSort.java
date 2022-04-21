package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSort {
    public void sort(double[] arr) {
        int n = arr.length;
        List<List<Double>> helper = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            helper.add(new ArrayList<>());
        }
        for (double d : arr) {
            int index = (int)(n * d);
            helper.get(index).add(d);
        }
        for (List<Double> list : helper) {
            Collections.sort(list);
        }

        int index = 0;
        for (List<Double> list : helper) {
            for (Double d : list) {
                arr[index] = d;
                index++;
            }
        }

        // result
        for (double d : arr) {
            System.out.println(d);
        }

        // time o(n)
        // space o(n)
    }

    public static void main(String[] args) {
        BucketSort bucketSort = new BucketSort();
        double[] arr = {0.1, 0.2, 0.34, 0.65, 0.55, 0.77, 0.21, 0.99};
        bucketSort.sort(arr);
    }
}
