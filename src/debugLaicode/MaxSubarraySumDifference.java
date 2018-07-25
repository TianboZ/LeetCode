package debugLaicode;

public class MaxSubarraySumDifference {
    public int maxDiff(int[] array) {
        // Write your solution here
        int[] ps = new int[array.length];
        ps[0] = array[0];
        for (int i = 1; i < array.length; i++) {
            ps[i] = ps[i - 1] + array[i];
        }
        int max = 0;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j <= i; j++) {
                int sum1 = ps[i] - ps[j] + array[j];
                for (int m = i + 1; m < array.length; m++) {
                    for (int n = i + 1; n <= m; n++) {
                        int sum2 = ps[m] - ps[n] + array[n];
                        max = Math.max(max, Math.abs(sum1 - sum2));
                    }
                }
            }
        }
        return max;
    }
}
