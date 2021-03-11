package debugLaicode;

import java.util.ArrayList;
import java.util.List;

public class CommonNumbersInThreeSortedArray {
    public List<Integer> common(int[] a, int[] b, int[] c) {
        // Write your solution here
        List<Integer> res = new ArrayList<>();

        int i = 0; int j = 0; int k = 0;
        while (i < a.length && j < b.length && k < c.length) {
            if (a[i] == b[j] && b[j] == c[k]) {
                res.add(a[i]);
                i++; j++; k++;
            } else {
                // find the current smallest element, index++
                if (a[i] <= b[j] && a[i] <= c[k]) {
                    i++;
                } else if (b[j] <= a[i] && b[j] <= c[k]) {
                    j++;
                } else {
                    k++;
                }

            }
        }
        return res;
    }
//    public List<Integer> common(int[] a, int[] b, int[] c) {
//        int i = 0;
//        int j = 0;
//        int k = 0;
//        List<Integer> res = new ArrayList<>();
//        // 谁小移谁
//        while (i < a.length && j < b.length && k < c.length) {
//            if (a[i] == b[j] && b[j] == c[k]) {
//                res.add(a[i]);
//                i++;
//                j++;
//                k++;
//            } else if (a[i] <= b[j] && a[i] <= c[k]) {
//                i++;
//            } else if (b[j] <= a[i] && b[j] <= c[k]) {
//                j++;
//            } else {
//                k++;
//            }
//        }
//        return res;
//    }
}
