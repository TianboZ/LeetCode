package debugLaicode;

import java.util.Arrays;

public class MedianOfTwoSortedArrays {
    public double median(int[] a, int[] b) {
        // write your solution here
        Arrays.sort(a);
        Arrays.sort(b);
        int len = a.length + b.length;
        //odd
        if (len % 2 == 1) {
            int k = len / 2 + 1;
            return median(a, 0, b, 0, k);
        } else {//even
            int k1 = (len - 1) / 2 + 1;
            int k2 = (len + 1) / 2 + 1;
            return (double) (median(a, 0, b, 0, k1) + median(a, 0, b, 0, k2)) / 2;
        }

    }
    private int median(int[] a, int aLeft, int[] b, int bLeft, int k) {
        //base case
        if (aLeft >= a.length) {
            return b[bLeft + k - 1];
        } else if (bLeft >= b.length) {
            return a[aLeft + k - 1];
        } else if (k == 1) {
            return Math.min(a[aLeft], b[bLeft]);
        }
        //rule
        int aK = aLeft + k / 2 - 1 >= a.length ? Integer.MAX_VALUE : a[aLeft + k / 2 - 1];
        int bK = bLeft + k / 2 - 1 >= b.length ? Integer.MAX_VALUE : b[bLeft + k / 2 - 1];
        if (aK < bK) {
            return median(a, aLeft + k / 2, b, bLeft, k - k / 2);
        } else {
            return median(a, aLeft, b, bLeft + k / 2, k - k / 2);
        }
    }
}
