package debugLaicode;

import java.util.Map;

public class KthSmallestInTwoSortedArrays {
    public int kth(int[] a, int[] b, int k) {
        // Write your solution here
        return helper(a, b, 0, 0, k);
    }
    private int helper(int[] a, int[] b, int lefta, int leftb, int k) {
        // basecase
        if (lefta >= a.length) { // nothing left in a
            return b[leftb + k - 1];
        }
        if (leftb >= b.length) {
            return a[lefta + k - 1];
        }
        if (k == 1) {
            return Math.min(a[lefta], b[leftb]);
        }

        // recursive rule
        int ath = lefta + k/2 - 1 < a.length ? a[lefta + k/2 - 1]: Integer.MAX_VALUE;
        int bth = leftb + k/2 - 1 < b.length ? b[leftb + k/2 - 1]: Integer.MAX_VALUE;

        if (ath < bth) {
            return helper(a, b, lefta + k/2, leftb, k - k/2);
        } else {
            return helper(a, b, lefta, leftb + k/2, k - k/2);
        }
    }

    public static void main(String[] args) {
        KthSmallestInTwoSortedArrays sol = new KthSmallestInTwoSortedArrays();
        int res = sol.kth(new int[]{1,4,6}, new int[]{2,3}, 3);
        System.out.println(res);
    }
}
